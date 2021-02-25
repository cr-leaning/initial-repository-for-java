package com.nekose.sampleproject.controller.response;

import com.nekose.sampleproject.constant.ResultStatus;
import lombok.Data;

@Data
public class BaseResponse {
    private ResultStatus status;
    private String statusReason;
}
