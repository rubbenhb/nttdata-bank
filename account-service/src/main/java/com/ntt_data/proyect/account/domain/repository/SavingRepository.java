package com.ntt_data.proyect.account.domain.repository;

import com.ntt_data.proyect.account.domain.entity.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SavingRepository extends JpaRepository<Saving, Long> {
    Optional<Saving> findById(Long id);
}