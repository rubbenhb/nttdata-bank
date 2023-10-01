package com.ntt_data.proyect.customer.service.exceptions;

public class MalformedDocumentNumberException extends RuntimeException{
    public MalformedDocumentNumberException(String message) {
        super(message);
    }
}