package com.nekose.sampleproject.controller.response;

import com.nekose.sampleproject.constant.ResultStatus;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Response<E> {
    private BaseResponse resultInfo;
    private E data;

    @Builder
    @Getter
    public static class BaseResponse {
        private ResultStatus status;
        private String statusReason;
    }
}
