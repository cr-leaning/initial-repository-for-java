package com.nekose.sampleproject.controller;

import com.nekose.sampleproject.application.ExampleApplication;
import com.nekose.sampleproject.constant.SampleProjectConstants;
import com.nekose.sampleproject.controller.request.ExampleRequest;
import com.nekose.sampleproject.controller.response.Response;
import com.nekose.sampleproject.domain.model.entity.ExampleData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/examples")
public class ExampleDateController {
  private final ExampleApplication exampleApplication;

  @GetMapping("/{key}")
  public ResponseEntity<Response<ExampleData>> get(@Valid @NotNull @PathVariable("key") String key) {
    return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Response.<ExampleData>builder()
                    .resultInfo(SampleProjectConstants.RESULT_INFO_OK)
                    .data(exampleApplication.get(key))
                    .build());
  }

  @PutMapping
  public ResponseEntity<Response<ExampleData>> store(@Valid @NotNull @RequestBody ExampleRequest request) {
    return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Response.<ExampleData>builder()
                    .resultInfo(SampleProjectConstants.RESULT_INFO_OK)
                    .data(exampleApplication.store(request))
                    .build());
  }

  @DeleteMapping("/{key}")
  public ResponseEntity<Response<String>> delete(@Valid @NotNull @PathVariable("key") String key) {
    exampleApplication.delete(key);
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Response.<String>builder()
                    .resultInfo(SampleProjectConstants.RESULT_INFO_OK)
                    .build());
  }
}