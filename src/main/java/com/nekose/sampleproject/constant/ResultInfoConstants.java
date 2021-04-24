package com.nekose.sampleproject.constant;

import com.nekose.sampleproject.controller.response.Response;

public class ResultInfoConstants {
    public static final String UNEXPECTED_ERROR = "unexpected error";

    private ResultInfoConstants() {}

    public static Response.BaseResponse RESULT_INFO_OK = Response.BaseResponse.builder()
            .status(ResultStatus.SUCCESS).statusReason(ResultStatus.SUCCESS.getValue()).build();
    public static Response.BaseResponse RESULT_INFO_ERROR = Response.BaseResponse.builder()
            .status(ResultStatus.ERROR).statusReason(ResultStatus.ERROR.getValue()).build();
}
