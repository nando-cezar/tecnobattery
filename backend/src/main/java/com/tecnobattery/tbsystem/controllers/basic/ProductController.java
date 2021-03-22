package com.tecnobattery.tbsystem.controllers.basic;

import java.util.List;

import com.tecnobattery.tbsystem.dto.response.ProductResponse;
import com.tecnobattery.tbsystem.services.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/products")
@AllArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping
  @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
  public ResponseEntity<List<ProductResponse>> findAll() {
    return ResponseEntity.ok().body(productService.findAll());
  }

  @GetMapping("/{productId}")
  @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
  public ResponseEntity<ProductResponse> findById(@PathVariable Long productId) {
    return ResponseEntity.ok(productService.findById(productId));
  }
}
