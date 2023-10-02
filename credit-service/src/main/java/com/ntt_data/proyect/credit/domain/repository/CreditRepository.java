package com.ntt_data.proyect.credit.domain.repository;

import com.ntt_data.proyect.credit.domain.entity.Consumption;
import com.ntt_data.proyect.credit.domain.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit,Long> {
    List<Credit> findByNroDoc(Long nroDoc);
}
