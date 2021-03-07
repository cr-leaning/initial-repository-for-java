package com.nekose.sampleproject.constant;

import com.nekose.sampleproject.controller.response.Response;

public class SampleProjectConstants {
    private SampleProjectConstants() {}

    public static Response.BaseResponse RESULT_INFO_OK = Response.BaseResponse.builder()
            .status(ResultStatus.SUCCESS).statusReason(ResultStatus.SUCCESS.getValue()).build();
}
