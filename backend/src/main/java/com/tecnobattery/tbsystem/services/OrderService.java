package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.output.OrderOutput;
import com.tecnobattery.tbsystem.entities.Client;
import com.tecnobattery.tbsystem.entities.Order;
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

  public OrderOutput save(Order order) {
    return toModel(orderRepository.save(order));
  }

  public OrderOutput save(Long clientId, Order order) {
    Client client = clientRepository.findById(clientId).orElseThrow(() -> new BusinessException("Client: not found"));
    order.setClient(client);
    return toModel(orderRepository.save(order));
  }

  @Transactional(readOnly = true)
  public List<OrderOutput> findAll() {
    List<Order> orders = orderRepository.findAll();
    return toCollectionDTO(orders);
  }

  @Transactional(readOnly = true)
  public OrderOutput findById(Long orderId) {
    Optional<Order> order = orderRepository.findById(orderId);
    if (order.isPresent()) {
      return toModel(order.get());
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

  private OrderOutput toModel(Order orderService) {
    return mapper.map(orderService, OrderOutput.class);
  }

  private List<OrderOutput> toCollectionDTO(List<Order> orderServices) {
    return orderServices.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }

}
