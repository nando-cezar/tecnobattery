package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.output.ProductOutput;
import com.tecnobattery.tbsystem.entities.Product;
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

  public ProductOutput save(String name, Integer power, Integer capacity, Integer voltage, Double price,
      String description, String imageUrl) {
    Product product = new Product();
    product.setName(name);
    product.setPower(power);
    product.setCapacity(capacity);
    product.setVoltage(voltage);
    product.setPrice(price);
    product.setDescription(description);
    product.setImageUrl(imageUrl);

    return toModel(productRepository.save(product));
  }

  @Transactional(readOnly = true)
  public List<ProductOutput> findAll() {
    List<Product> products = productRepository.findAll();
    return toCollectionDTO(products);
  }

  private ProductOutput toModel(Product product) {
    return mapper.map(product, ProductOutput.class);
  }

  private List<ProductOutput> toCollectionDTO(List<Product> products) {
    return products.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
