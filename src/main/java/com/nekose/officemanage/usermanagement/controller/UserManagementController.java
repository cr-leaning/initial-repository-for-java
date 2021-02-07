package com.nekose.officemanage.usermanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/users")
public class UserManagementController {

  @GetMapping()
  public String getUsers() {
    return "dummy";
  }
}
