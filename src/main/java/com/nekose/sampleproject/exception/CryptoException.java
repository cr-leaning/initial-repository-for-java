package com.nekose.sampleproject.exception;

public class CryptoException extends RuntimeException {
    public CryptoException(Exception e) {
        super(e);
    }
}
