package com.example.certi.veri.exception;

public class CertificateNotFoundException extends RuntimeException {
    public CertificateNotFoundException(String message) {
        super(message);
    }
}
