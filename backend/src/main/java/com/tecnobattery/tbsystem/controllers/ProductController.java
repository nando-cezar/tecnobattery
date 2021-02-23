package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.input.ProductInput;
import com.tecnobattery.tbsystem.dto.output.ProductOutput;
import com.tecnobattery.tbsystem.entities.Product;
import com.tecnobattery.tbsystem.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductOutput save(@Valid @RequestBody ProductInput productInput) {
    Product product = new Product();
    product.setName(productInput.getName());
    product.setPower(productInput.getPower());
    product.setCapacity(productInput.getCapacity());
    product.setVoltage(productInput.getVoltage());
    product.setPrice(productInput.getPrice());
    product.setDescription(productInput.getDescription());
    product.setImageUrl(productInput.getImageUrl());

    return productService.save(product);
  }

  @GetMapping
  public ResponseEntity<List<ProductOutput>> findAll() {
    List<ProductOutput> list = productService.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/{productId}")
  public ResponseEntity<ProductOutput> findById(@PathVariable Long productId) {
    ProductOutput product = productService.findById(productId);
    if (product != null) {
      return ResponseEntity.ok(product);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{productId}")
  public ResponseEntity<ProductOutput> update(@Valid @PathVariable Long productId,
      @RequestBody ProductInput productInput) {

    if (!productService.existsById(productId)) {
      return ResponseEntity.notFound().build();
    }

    Product product = new Product();
    product.setId(productId);
    product.setName(productInput.getName());
    product.setPower(productInput.getPower());
    product.setCapacity(productInput.getCapacity());
    product.setVoltage(productInput.getVoltage());
    product.setPrice(productInput.getPrice());
    product.setDescription(productInput.getDescription());
    product.setImageUrl(productInput.getImageUrl());

    return ResponseEntity.ok(productService.save(product));
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<Void> deleteById(@PathVariable Long productId) {
    if (!productService.existsById(productId)) {
      return ResponseEntity.notFound().build();
    }
    productService.deleteById(productId);
    return ResponseEntity.noContent().build();
  }
}
