package com.ntt_data.proyect.credit.service;

import com.ntt_data.proyect.credit.domain.entity.Consumption;
import com.ntt_data.proyect.credit.domain.repository.ConsumptionRepository;
import com.ntt_data.proyect.credit.domain.service.ConsumptionService;
import com.ntt_data.proyect.credit.domain.service.CreditService;
import com.ntt_data.proyect.credit.domain.service.PaymentScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@AllArgsConstructor
public class ConsumptioServiceImpl implements ConsumptionService {

    private final ConsumptionRepository consumptionRepository;
    private final PaymentScheduleService paymentScheduleService;
    private final CreditService creditService;
    @Override
    public Consumption create(Consumption consumption) {
        System.out.println("llega aca ");
        List<Consumption> cons = consumptionRepository.findAllByCreditId(consumption.getCredit().getId());
        if(cons.size()>0){
            double totalAmount = cons.stream().mapToDouble(Consumption::getAmout).sum();
            Double linea = creditService.creditById(consumption.getCredit().getId()).getCreditLine();
            if(linea>= (totalAmount+consumption.getAmout())){
                Consumption c = consumptionRepository.save(consumption);
                Double tea = (creditService.creditById(c.getCredit().getId())).getTea();
                paymentScheduleService.createCalendarByRetirement(c,tea);
                return c;
            }else { return null;}
        }else {
            Consumption c = consumptionRepository.save(consumption);
            Double tea = (creditService.creditById(c.getCredit().getId())).getTea();
            paymentScheduleService.createCalendarByRetirement(c, tea);
            return c;
        }
    }
}
