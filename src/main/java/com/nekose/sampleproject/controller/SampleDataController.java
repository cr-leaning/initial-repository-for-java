package com.nekose.sampleproject.controller;

import com.nekose.sampleproject.application.SampleApplication;
import com.nekose.sampleproject.constant.ResultInfoConstants;
import com.nekose.sampleproject.controller.request.SampleRequest;
import com.nekose.sampleproject.controller.request.SearchSampleRequest;
import com.nekose.sampleproject.controller.response.Response;
import com.nekose.sampleproject.domain.model.entity.SampleData;
import com.nekose.sampleproject.domain.model.entity.SearchSampleData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/samples")
public class SampleDataController {
  private final SampleApplication sampleApplication;

  @GetMapping("/{id}")
  public ResponseEntity<Response<SampleData>> get(@Valid @NotNull @PathVariable("id") Long id) {
    return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Response.<SampleData>builder()
                    .resultInfo(ResultInfoConstants.RESULT_INFO_OK)
                    .data(sampleApplication.get(id))
                    .build());
  }

  @PostMapping("search")
  public ResponseEntity<Response<SearchSampleData>> searchSample(@Valid @NotNull @RequestBody SearchSampleRequest request) {
    return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Response.<SearchSampleData>builder()
                    .resultInfo(ResultInfoConstants.RESULT_INFO_OK)
                    .data(sampleApplication.search(request))
                    .build());
  }

  @PostMapping
  public ResponseEntity<Response<SampleData>> storeSample(@Valid @NotNull @RequestBody SampleRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Response.<SampleData>builder()
                    .resultInfo(ResultInfoConstants.RESULT_INFO_OK)
                    .data(sampleApplication.store(request))
                    .build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Response<SampleData>> updateSample(@Valid @NotNull @PathVariable("id") Long id,
                                                           @Valid @NotNull @RequestBody SampleRequest request) {
    return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Response.<SampleData>builder()
                    .resultInfo(ResultInfoConstants.RESULT_INFO_OK)
                    .data(sampleApplication.update(id, request))
                    .build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Response<String>> deleteSample(@Valid @NotNull @PathVariable("id") Long id) {
    sampleApplication.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Response.<String>builder()
                    .resultInfo(ResultInfoConstants.RESULT_INFO_OK)
                    .build());
  }

  @DeleteMapping("/physical-delete/{id}")
  public ResponseEntity<Response<String>> physicalDelete(@Valid @NotNull @PathVariable("id") Long id) {
    sampleApplication.physicalDelete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Response.<String>builder()
                    .resultInfo(ResultInfoConstants.RESULT_INFO_OK)
                    .build());
  }
}