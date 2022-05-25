package com.nekose.sampleproject.controller.stub;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nekose.sampleproject.infrastructure.client.request.DummyApiRequest;
import com.nekose.sampleproject.infrastructure.client.response.DummyApiErrorResponse;
import com.nekose.sampleproject.infrastructure.client.response.DummyApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/stub/v1/dummyApi/{id}")
public class StubDummyApiController {
  public static final String ERROR_STUB_BEARER_TOKEN = "errorBearerToken";
  public static final String ERROR_STUB_TIMEOUT_PARAMETER = "timeoutParam";
  public static final String ERROR_STUB_INVALID_PARAMETER = "invalidParam";

  public static final String[] AUTH_ERROR = {"Authentication Error", "認証に失敗しました"};
  public static final String[] INVALID_PARAMETER_ERROR = {"Invalid parameter Error", "パラメータが不正です"};

  @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> get(@RequestHeader("Authorization") String bearerToken,
                                    @PathVariable("id") String id)
          throws JsonProcessingException, InterruptedException {
    return dummyApi(bearerToken, id, DummyApiResponse.builder().name("testName").value("testValue").build());
  }

  @PutMapping
  public ResponseEntity<String> store(@RequestHeader("Authorization") String bearerToken,
                                      @PathVariable("id") String id,
                                      @RequestBody DummyApiRequest request)
          throws JsonProcessingException, InterruptedException {
    return dummyApi(bearerToken, id, DummyApiResponse.builder().name(request.getName()).value(request.getValue()).build());
  }

  private ResponseEntity<String> dummyApi(String bearerToken,
                                          String id,
                                          DummyApiResponse normalResponse)
          throws JsonProcessingException, InterruptedException {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpStatus status = HttpStatus.OK;
    String responseBody;

    String[] auth = bearerToken.split(" ");

    if (!"Bearer".equals(auth[0]) || ERROR_STUB_BEARER_TOKEN.equals(auth[1])) {
      status = HttpStatus.FORBIDDEN;
      responseBody = errorResponse(AUTH_ERROR);
    } else if (ERROR_STUB_INVALID_PARAMETER.equals(id)) {
      status = HttpStatus.FORBIDDEN;
      responseBody = errorResponse(INVALID_PARAMETER_ERROR);
    } else if (ERROR_STUB_TIMEOUT_PARAMETER.equals(id)) {
      Thread.sleep(3000L);
      responseBody = new ObjectMapper().writeValueAsString(normalResponse);
    } else {
      responseBody = new ObjectMapper().writeValueAsString(normalResponse);
    }

    return ResponseEntity.status(status)
            .headers(headers)
            .body(responseBody);
  }

  private String errorResponse(String... message) throws JsonProcessingException {
    return new ObjectMapper().writeValueAsString(DummyApiErrorResponse.builder()
            .message(message[0])
            .detail(message[1])
            .build());
  }

  @DeleteMapping
  public ResponseEntity<String> delete(@PathVariable("id") String id) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}