package com.ntt_data.proyect.customer.domain.service;

import com.ntt_data.proyect.customer.service.dto.RequestCustomerDto;
import com.ntt_data.proyect.customer.service.dto.ResponseCustomerDto;
import java.util.List;

public interface ICustomerService {
    ResponseCustomerDto save(RequestCustomerDto requestCustomerDto);
    List<ResponseCustomerDto> findAll(String lastName, Long documentNumber);
    List<ResponseCustomerDto> findByCustomerType(Long customerTypeId);
}