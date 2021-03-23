package com.tecnobattery.tbsystem.controllers.management;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.request.ProductRequest;
import com.tecnobattery.tbsystem.dto.response.ProductResponse;
import com.tecnobattery.tbsystem.entities.Product;
import com.tecnobattery.tbsystem.services.ProductService;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/management/api/v1/products")
@AllArgsConstructor
public class ProductManagementController {

  private final ProductService productService;
  private final ToolModelMapper toolModelMapper;

  @PostMapping
  @PreAuthorize("hasAuthority('global:write')")
  @ResponseStatus(HttpStatus.CREATED)
  public ProductResponse save(@Valid @RequestBody ProductRequest productInput) {
    return productService.save(toolModelMapper.toModel(productInput, Product.class), false);
  }

  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<List<ProductResponse>> findAll() {
    return ResponseEntity.ok().body(productService.findAll());
  }

  @GetMapping("/{productId}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<ProductResponse> findById(@PathVariable Long productId) {
    return ResponseEntity.ok(productService.findById(productId));
  }

  @PutMapping("/{productId}")
  @PreAuthorize("hasAuthority('global:write')")
  public ResponseEntity<ProductResponse> update(@PathVariable Long productId,
      @Valid @RequestBody ProductRequest productInput) {

    if (!productService.existsById(productId)) {
      return ResponseEntity.notFound().build();
    }

    Product product = new Product();
    product = toolModelMapper.toModel(productInput, Product.class);
    product.setId(productId);

    return ResponseEntity.ok(productService.save(product, true));
  }

  @DeleteMapping("/{productId}")
  @PreAuthorize("hasAuthority('global:write')")
  public ResponseEntity<Void> deleteById(@PathVariable Long productId) {
    if (!productService.existsById(productId)) {
      return ResponseEntity.notFound().build();
    }
    productService.deleteById(productId);
    return ResponseEntity.noContent().build();
  }
}
