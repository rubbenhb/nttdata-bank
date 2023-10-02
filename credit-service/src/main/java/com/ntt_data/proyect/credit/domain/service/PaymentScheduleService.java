package com.ntt_data.proyect.credit.domain.service;

import com.ntt_data.proyect.credit.domain.entity.Consumption;
import com.ntt_data.proyect.credit.domain.entity.PaymentSchedule;
import java.util.*;
public interface PaymentScheduleService {
    public void createCalendarByRetirement(Consumption consumption, Double tea);
    public List<PaymentSchedule> getCalendarByCustomer(Long nroDoc);
}
