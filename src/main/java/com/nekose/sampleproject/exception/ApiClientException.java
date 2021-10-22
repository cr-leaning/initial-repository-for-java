package com.nekose.sampleproject.exception;

import org.springframework.http.HttpStatus;

public class ApiClientException extends Exception {
    private String detail;

    public ApiClientException(HttpStatus status, Throwable th, String message) {
        super(message, th);
        this.detail = status.name();
    }
}
