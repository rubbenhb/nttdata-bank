package com.ntt_data.proyect.customer.domain.repository;

import com.ntt_data.proyect.customer.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE " +
            "(:lastName IS NULL OR LOWER(c.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))) " +
            "AND (:documentNumber IS NULL OR LOWER(c.documentNumber) LIKE LOWER(CONCAT('%', :documentNumber, '%')))")
    List<Customer> findCustomers(String lastName, Long documentNumber);

    boolean existsByDocumentNumber(Long documentNumber);
}