package com.ntt_data.proyect.transaction.domain.repository;

import com.ntt_data.proyect.transaction.domain.model.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Integer> {

}
