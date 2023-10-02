package com.ntt_data.proyect.credit.domain.repository;

import com.ntt_data.proyect.credit.domain.entity.Ctas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CtasRepository extends JpaRepository<Ctas,Long> {
}
