package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.input.ProductInput;
import com.tecnobattery.tbsystem.dto.input.UserInput;
import com.tecnobattery.tbsystem.dto.output.OrderOutput;
import com.tecnobattery.tbsystem.entities.Client;
import com.tecnobattery.tbsystem.entities.Order;
import com.tecnobattery.tbsystem.entities.Product;
import com.tecnobattery.tbsystem.entities.User;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ClientRepository;
import com.tecnobattery.tbsystem.repositories.OrderRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private ModelMapper mapper;

  public Order save(Order order) {
    return orderRepository.save(order);
  }

  public OrderOutput save(Long clientId, List<ProductInput> productsInput, Set<UserInput> usersInput, Order order) {
    Client clientRequest = clientRepository.findById(clientId)
        .orElseThrow(() -> new BusinessException("Client: not found"));

    order.setClient(clientRequest);
    order.setProducts(toCollectionProduct(productsInput));
    order.setUsers(toCollectionUser(usersInput));
    return toModelOrder(orderRepository.save(order));
  }

  @Transactional(readOnly = true)
  public List<OrderOutput> findAll() {
    List<Order> orders = orderRepository.findAll();
    return toCollectionOrder(orders);
  }

  @Transactional(readOnly = true)
  public OrderOutput findById(Long orderId) {
    Optional<Order> order = orderRepository.findById(orderId);
    if (order.isPresent()) {
      return toModelOrder(order.get());
    }
    return null;
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long orderId) {
    return orderRepository.existsById(orderId);
  }

  public void deleteById(Long orderId) {
    orderRepository.deleteById(orderId);
  }

  private OrderOutput toModelOrder(Order order) {
    return mapper.map(order, OrderOutput.class);
  }

  private List<OrderOutput> toCollectionOrder(List<Order> orderServices) {
    return orderServices.stream().map(x -> toModelOrder(x)).collect(Collectors.toList());
  }

  private User toModelUser(UserInput user) {
    return mapper.map(user, User.class);
  }

  private Set<User> toCollectionUser(Set<UserInput> users) {
    return users.stream().map(x -> toModelUser(x)).collect(Collectors.toSet());
  }

  private Product toModelProduct(ProductInput product) {
    return mapper.map(product, Product.class);
  }

  private List<Product> toCollectionProduct(List<ProductInput> products) {
    return products.stream().map(x -> toModelProduct(x)).collect(Collectors.toList());
  }

}
