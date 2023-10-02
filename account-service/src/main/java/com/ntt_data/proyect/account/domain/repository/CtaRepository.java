package com.ntt_data.proyect.account.domain.repository;

import com.ntt_data.proyect.account.domain.entity.Cta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CtaRepository extends JpaRepository<Cta, Long> {
    List<Cta> findByCta(Long cta);
}
