package com.ntt_data.proyect.credit.domain.service;
import com.ntt_data.proyect.credit.domain.entity.Credit;
import com.ntt_data.proyect.credit.domain.entity.PaymentSchedule;

import java.util.*;
public interface CreditService {
    public String paymentByInstallment(Long doc_nro, Date monthQuota);
    public List<PaymentSchedule> getAllMovements(Long customerId);
    public Credit creditById(Long id);
    List<Credit> findCreditsByNroDoc(Long nroDoc);

    public Credit createCreditWithoutCta(Credit credit);

}
