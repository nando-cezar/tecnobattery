package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

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
  private ToolModelMapper toolModelMapper;

  public Order save(Order order) {
    return orderRepository.save(order);
  }

  public OrderOutput save(Long clientId, List<ProductInput> productsInput, Set<UserInput> usersInput, Order order) {
    Client clientRequest = clientRepository.findById(clientId)
        .orElseThrow(() -> new BusinessException("Client: not found"));

    order.setClient(clientRequest);
    order.setProducts(toolModelMapper.toCollection(productsInput, Product.class));
    order.setUsers(toolModelMapper.toCollection(usersInput, User.class));
    return toolModelMapper.toModel(orderRepository.save(order), OrderOutput.class);
  }

  @Transactional(readOnly = true)
  public List<OrderOutput> findAll() {
    List<Order> orders = orderRepository.findAll();
    return toolModelMapper.toCollection(orders, OrderOutput.class);
  }

  @Transactional(readOnly = true)
  public OrderOutput findById(Long orderId) {
    Optional<Order> order = orderRepository.findById(orderId);
    if (order.isPresent()) {
      return toolModelMapper.toModel(order.get(), OrderOutput.class);
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

}
