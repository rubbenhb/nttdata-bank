package com.ntt_data.proyect.account.domain.repository;

import com.ntt_data.proyect.account.domain.entity.Signer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignerRepository extends JpaRepository<Signer,Long> {
    Optional<Signer> findById(Long id);

}