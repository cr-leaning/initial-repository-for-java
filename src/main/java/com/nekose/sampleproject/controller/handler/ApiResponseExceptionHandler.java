package com.nekose.sampleproject.controller.handler;

import com.nekose.sampleproject.constant.ResultInfoConstants;
import com.nekose.sampleproject.controller.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static com.nekose.sampleproject.constant.ResultInfoConstants.UNEXPECTED_ERROR;

@Slf4j
@ControllerAdvice
public class ApiResponseExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<String>> handleException(Exception ex, HttpServletRequest req) {
        log.error("[ERROR] Handle Exception: {}", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Response.<String>builder()
                        .resultInfo(ResultInfoConstants.RESULT_INFO_ERROR)
                        .data(UNEXPECTED_ERROR)
                        .build());
    }
}
