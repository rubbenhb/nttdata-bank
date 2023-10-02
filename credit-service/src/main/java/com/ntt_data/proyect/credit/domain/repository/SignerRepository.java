package com.ntt_data.proyect.credit.domain.repository;

import com.ntt_data.proyect.credit.domain.entity.Signer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SignerRepository extends JpaRepository<Signer,Long> {
    List<Signer> findByCustomer_IdAndStateAndTypeProduct(Long customerId, String state, String typeProduct);
}
