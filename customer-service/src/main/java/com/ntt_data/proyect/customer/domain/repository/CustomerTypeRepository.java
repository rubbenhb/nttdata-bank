package com.ntt_data.proyect.customer.domain.repository;

import com.ntt_data.proyect.customer.domain.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}