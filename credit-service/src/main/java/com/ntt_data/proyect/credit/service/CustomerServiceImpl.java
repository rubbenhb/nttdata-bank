package com.ntt_data.proyect.credit.service;

import com.ntt_data.proyect.credit.domain.entity.Customer;
import com.ntt_data.proyect.credit.domain.repository.CustomerRepository;
import com.ntt_data.proyect.credit.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer findByNroDoc(Long nroDoc) {
        return customerRepository.findByNroDoc(nroDoc);
    }
}
