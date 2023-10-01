package com.ntt_data.proyect.customer.service.exceptions;

public class ExistsDocumentNumberException extends RuntimeException {
    public ExistsDocumentNumberException(String message) {
        super(message);
    }
}