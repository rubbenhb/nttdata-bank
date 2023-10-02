package com.ntt_data.proyect.credit.domain.repository;

import com.ntt_data.proyect.credit.domain.entity.PaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface PaymentScheduleRepository extends JpaRepository<PaymentSchedule,Long> {
    List<PaymentSchedule> findAllByConsumptionId(Long consumptioId);
}
