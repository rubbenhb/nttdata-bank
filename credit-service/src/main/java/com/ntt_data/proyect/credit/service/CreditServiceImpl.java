package com.ntt_data.proyect.credit.service;

import com.ntt_data.proyect.credit.domain.entity.Credit;
import com.ntt_data.proyect.credit.domain.entity.PaymentSchedule;
import com.ntt_data.proyect.credit.domain.service.CreditService;
//import com.ntt_data.proyect.credit.integration.CustomerService;
//import com.ntt_data.proyect.credit.integration.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
//@FeignClient(name = "customer-service", url = "${customer-service.url}")
public class CreditServiceImpl implements CreditService {

    //private final CustomerServiceFeignClient customerServiceFeignClient;
    @Override
    public List<PaymentSchedule> makeCreditQuotaPayment(Long doc_nro, Double amount, Date monthQuota) {
       // Customer customer = customerServiceFeignClient.getCustomerById(docNro);
        return null;
    }

    @Override
    public List<PaymentSchedule> createCredit(Credit credit, Double amount) {
        return null;
    }

    @Override
    public List<PaymentSchedule> getAllMovements(Long customerId) {
        return null;
    }
}
