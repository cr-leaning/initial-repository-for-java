package com.nekose.sampleproject.exception;

import feign.FeignException;

public class ApiClientException extends FeignException {
    private String detail;

    public ApiClientException(int status, String message, String detail) {
        super(status, message);
        this.detail = detail;
    }
}
