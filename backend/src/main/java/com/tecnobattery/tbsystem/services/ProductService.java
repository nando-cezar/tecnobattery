package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.output.ProductOutput;
import com.tecnobattery.tbsystem.entities.Product;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ProductRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ModelMapper mapper;

  public ProductOutput save(Product product) {

    Product productExists = productRepository.findByName(product.getName());

    if (productExists != null && !productExists.equals(product)) {
      throw new BusinessException("Já existe um produto cadastrado com este nome.");
    }
    return toModel(productRepository.save(product));
  }

  @Transactional(readOnly = true)
  public List<ProductOutput> findAll() {
    List<Product> products = productRepository.findAll();
    return toCollectionDTO(products);
  }

  @Transactional(readOnly = true)
  public ProductOutput findById(Long productId) {
    Optional<Product> product = productRepository.findById(productId);
    if (product.isPresent()) {
      return toModel(product.get());
    }
    return null;
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long productId) {
    return productRepository.existsById(productId);
  }

  public void deleteById(Long productId) {
    productRepository.deleteById(productId);
  }

  private ProductOutput toModel(Product product) {
    return mapper.map(product, ProductOutput.class);
  }

  private List<ProductOutput> toCollectionDTO(List<Product> products) {
    return products.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
