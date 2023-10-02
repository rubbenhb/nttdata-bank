package com.ntt_data.proyect.credit.domain.repository;

import com.ntt_data.proyect.credit.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public Customer findByNroDoc(Long nroDoc);
}
