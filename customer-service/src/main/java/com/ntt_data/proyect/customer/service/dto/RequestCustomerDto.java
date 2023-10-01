package com.ntt_data.proyect.customer.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class RequestCustomerDto {
    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String lastName;

    @NotNull
    @Digits(integer = Integer.MAX_VALUE, fraction = 0)
    private Long documentNumber;

    @NotNull
    @Min(value = 1)
    @Max(value = 2)
    private Integer gender;

    @NotNull
    @Digits(integer = Integer.MAX_VALUE, fraction = 0)
    private Long customerType;
}