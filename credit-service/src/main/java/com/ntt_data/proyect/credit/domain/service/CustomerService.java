package com.ntt_data.proyect.credit.domain.service;

import com.ntt_data.proyect.credit.domain.entity.Customer;

public interface CustomerService {
    public Customer findByNroDoc(Long nroDoc);
}
