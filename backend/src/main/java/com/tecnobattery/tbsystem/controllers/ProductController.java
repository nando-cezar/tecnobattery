package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.input.ProductInput;
import com.tecnobattery.tbsystem.dto.output.ProductOutput;
import com.tecnobattery.tbsystem.entities.Product;
import com.tecnobattery.tbsystem.services.ProductService;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

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

  @Autowired
  private ToolModelMapper toolModelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductOutput save(@Valid @RequestBody ProductInput productInput) {
    return productService.save(toolModelMapper.toModel(productInput, Product.class), false);
  }

  @GetMapping
  public ResponseEntity<List<ProductOutput>> findAll() {
    return ResponseEntity.ok().body(productService.findAll());
  }

  @GetMapping("/{productId}")
  public ResponseEntity<ProductOutput> findById(@PathVariable Long productId) {
    return ResponseEntity.ok(productService.findById(productId));
  }

  @PutMapping("/{productId}")
  public ResponseEntity<ProductOutput> update(@Valid @PathVariable Long productId,
      @RequestBody ProductInput productInput) {

    if (!productService.existsById(productId)) {
      return ResponseEntity.notFound().build();
    }

    Product product = new Product();
    product = toolModelMapper.toModel(productInput, Product.class);
    product.setId(productId);

    return ResponseEntity.ok(productService.save(product, true));
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
