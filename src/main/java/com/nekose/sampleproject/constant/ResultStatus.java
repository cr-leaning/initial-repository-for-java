package com.nekose.sampleproject.constant;

public enum ResultStatus {
    SUCCESS("success"),
    WARNING("warning"),
    ERROR("error");

    private String value;

    public String getValue() {
        return this.value;
    }

    ResultStatus(String value) {
        this.value = value;
    }
}
