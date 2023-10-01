package com.ntt_data.proyect.credit.domain.service;
import com.ntt_data.proyect.credit.domain.entity.Credit;
import com.ntt_data.proyect.credit.domain.entity.PaymentSchedule;

import java.util.*;
public interface CreditService {
    public List<PaymentSchedule> makeCreditQuotaPayment(Long doc_nro, Double amount, Date monthQuota);
    public List<PaymentSchedule> createCredit(Credit credit, Double amount);
    public List<PaymentSchedule> getAllMovements(Long customerId);

}
