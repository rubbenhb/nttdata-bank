package com.ntt_data.proyect.customer.service.exceptions;

public class NotFoundCustomerTypeException extends RuntimeException{
    public NotFoundCustomerTypeException(String message) {
        super(message);
    }
}
