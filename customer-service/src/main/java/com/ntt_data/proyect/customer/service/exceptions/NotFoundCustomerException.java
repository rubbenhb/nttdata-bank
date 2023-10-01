package com.ntt_data.proyect.customer.service.exceptions;

public class NotFoundCustomerException extends RuntimeException {
    public NotFoundCustomerException(String message) {
        super(message);
    }
}
