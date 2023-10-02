package com.ntt_data.proyect.credit.service;

import com.ntt_data.proyect.credit.domain.entity.Consumption;
import com.ntt_data.proyect.credit.domain.entity.PaymentSchedule;
import com.ntt_data.proyect.credit.domain.repository.PaymentScheduleRepository;
import com.ntt_data.proyect.credit.domain.service.PaymentScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
@Service
@RequiredArgsConstructor
public class PaymentScheduleServiceImpl implements PaymentScheduleService {
    private final PaymentScheduleRepository paymentScheduleRepository;
    @Override
    public void createCalendarByRetirement(Consumption consumption, Double tea) {
        Double amount = consumption.getAmout();
        int numQuotas = consumption.getInstallments();
        LocalDate currentDate = LocalDate.now();

        BigDecimal monthlyInterestRate = BigDecimal.valueOf(tea / 12 / 100);
        BigDecimal monthlyPayment = BigDecimal.valueOf(amount * monthlyInterestRate.doubleValue() / (1 - Math.pow(1 + monthlyInterestRate.doubleValue(), -numQuotas)));
        int daysToAdd=0;
        List<PaymentSchedule> paymentSchedules = new ArrayList<>();

        for (int i = 0; i < numQuotas; i++) {
            daysToAdd=daysToAdd+30;
            PaymentSchedule paymentSchedule = new PaymentSchedule();
            paymentSchedule.setConsumption(consumption);
            paymentSchedule.setNumQuota(i + 1);
            LocalDate day = currentDate.plusDays(daysToAdd);
            paymentSchedule.setDateCreation(Date.from(day.atStartOfDay(ZoneId.systemDefault()).toInstant()));

            // Calcular el monto de la cuota
            BigDecimal interest = monthlyPayment.multiply(BigDecimal.valueOf(i)).multiply(monthlyInterestRate);
            BigDecimal principal = monthlyPayment.subtract(interest);
            paymentSchedule.setFeeAmount(principal.setScale(2, RoundingMode.HALF_UP).doubleValue());

            // Calcular la fecha límite de pago (date_creation + 5 días)
            LocalDate tolerance =day.plusDays(5);
            paymentSchedule.setDeadline(Date.from(tolerance.atStartOfDay(ZoneId.systemDefault()).toInstant()));

            // Estado inicial: "deuda"
            paymentSchedule.setState("sin pago");

            // Id de movimiento inicial: 0
            paymentSchedule.setMovement(0L);

            paymentSchedules.add(paymentSchedule);

            // Calcular la siguiente fecha de pago
            currentDate = currentDate.plusMonths(1);
        }

        paymentScheduleRepository.saveAll(paymentSchedules);
    }

    @Override
    public List<PaymentSchedule> getCalendarByCustomer(Long consumptionId) {
        return paymentScheduleRepository.findAllByConsumptionId(consumptionId);
    }
}
