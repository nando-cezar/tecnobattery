package com.tecnobattery.tbsystem.controllers.basic;

import java.util.List;

import com.tecnobattery.tbsystem.dto.response.LoaderResponse;
import com.tecnobattery.tbsystem.services.LoaderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/loaders")
public class LoaderController {

  @Autowired
  private LoaderService loaderService;

  @GetMapping
  @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
  public ResponseEntity<List<LoaderResponse>> findAll() {
    return ResponseEntity.ok().body(loaderService.findAll());
  }

  @GetMapping("/{loaderId}")
  @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
  public ResponseEntity<LoaderResponse> findById(@PathVariable Long loaderId) {
    return ResponseEntity.ok(loaderService.findById(loaderId));
  }
}
