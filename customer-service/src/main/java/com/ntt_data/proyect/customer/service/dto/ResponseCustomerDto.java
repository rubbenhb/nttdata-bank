package com.ntt_data.proyect.customer.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResponseCustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String documentType;
    private Long documentNumber;
    private String gender;
    private String state;
    private String customerType;
}