package com.nekose.sampleproject.controller;

import com.nekose.sampleproject.application.SampleApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/sample")
public class SampleProjectController {
  private final SampleApplication sampleApplication;

  @GetMapping()
  public String getSample() {
    return "dummy";
  }

  @PostMapping()
  public String getSample() {
    return "dummy";
  }
}
