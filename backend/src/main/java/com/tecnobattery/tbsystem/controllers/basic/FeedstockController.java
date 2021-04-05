package com.tecnobattery.tbsystem.controllers.basic;

import java.util.List;

import com.tecnobattery.tbsystem.dto.response.FeedstockResponse;
import com.tecnobattery.tbsystem.services.FeedstockService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/feedstocks")
@AllArgsConstructor
public class FeedstockController {

  private final FeedstockService loaderService;

  @GetMapping
  @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
  public ResponseEntity<List<FeedstockResponse>> findAll() {
    return ResponseEntity.ok().body(loaderService.findAll());
  }

  @GetMapping("/{loaderId}")
  @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
  public ResponseEntity<FeedstockResponse> findById(@PathVariable Long loaderId) {
    return ResponseEntity.ok(loaderService.findById(loaderId));
  }
}
