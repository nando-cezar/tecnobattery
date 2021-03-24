package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.ProductResponse;
import com.tecnobattery.tbsystem.entities.Product;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ProductRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final ToolModelMapper toolModelMapper;

  public ProductResponse save(Product product, boolean identifier) {

    if (!identifier) {

      Product productExists = productRepository.findByName(product.getName());

      if (productExists != null && !productExists.equals(product)) {
        throw new BusinessException("Já existe um produto cadastrado com este nome.");
      }
    }
    return toolModelMapper.toModel(productRepository.save(product), ProductResponse.class);
  }

  public List<ProductResponse> findAll() {
    return toolModelMapper.toCollection(productRepository.findAll(), ProductResponse.class);
  }

  public ProductResponse findById(Long productId) {
    Optional<Product> product = productRepository.findById(productId);
    if (product.isPresent()) {
      return toolModelMapper.toModel(product.get(), ProductResponse.class);
    }
    return toolModelMapper.toModel(product.orElseThrow(() -> new BusinessException("Product: não encontrada.")),
        ProductResponse.class);
  }

  public boolean existsById(Long productId) {
    return productRepository.existsById(productId);
  }

  public void deleteById(Long productId) {
    productRepository.deleteById(productId);
  }

}
