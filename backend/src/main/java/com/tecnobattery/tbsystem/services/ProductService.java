package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.ProductDTO;
import com.tecnobattery.tbsystem.entities.Product;
import com.tecnobattery.tbsystem.repositories.ProductRepository;

import org.hibernate.collection.spi.PersistentCollection;
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

  @Transactional(readOnly = true)
  public List<ProductDTO> findAll() {
    List<Product> products = productRepository.findAll();
    return toCollectionDTO(products);
  }

  private ProductDTO toModel(Product product) {
    mapper.getConfiguration().setPropertyCondition(context -> !(context.getSource() instanceof PersistentCollection));
    return mapper.map(product, ProductDTO.class);
  }

  private List<ProductDTO> toCollectionDTO(List<Product> products) {
    return products.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
