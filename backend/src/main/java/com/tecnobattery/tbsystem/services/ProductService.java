package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.ProductResponse;
import com.tecnobattery.tbsystem.entities.Product;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ProductRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ToolModelMapper toolModelMapper;

  public ProductResponse save(Product product, boolean identifier) {

    if (!identifier) {

      Product productExists = productRepository.findByName(product.getName());

      if (productExists != null && !productExists.equals(product)) {
        throw new BusinessException("Já existe um produto cadastrado com este nome.");
      }
    }
    return toolModelMapper.toModel(productRepository.save(product), ProductResponse.class);
  }

  @Transactional(readOnly = true)
  public List<ProductResponse> findAll() {
    List<Product> products = productRepository.findAll();
    return toolModelMapper.toCollection(products, ProductResponse.class);
  }

  @Transactional(readOnly = true)
  public ProductResponse findById(Long productId) {
    Optional<Product> product = productRepository.findById(productId);
    if (product.isPresent()) {
      return toolModelMapper.toModel(product.get(), ProductResponse.class);
    }
    return toolModelMapper.toModel(product.orElseThrow(() -> new BusinessException("Product: não encontrada.")),
        ProductResponse.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long productId) {
    return productRepository.existsById(productId);
  }

  public void deleteById(Long productId) {
    productRepository.deleteById(productId);
  }

}
