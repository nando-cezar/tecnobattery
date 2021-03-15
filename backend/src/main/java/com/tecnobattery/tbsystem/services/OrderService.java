package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.OrderResponse;
import com.tecnobattery.tbsystem.entities.Order;
import com.tecnobattery.tbsystem.exception.BusinessException;
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
  private ToolModelMapper toolModelMapper;

  public OrderResponse save(Order order) {
    return toolModelMapper.toModel(orderRepository.save(order), OrderResponse.class);
  }

  @Transactional(readOnly = true)
  public List<OrderResponse> findAll() {
    List<Order> orders = orderRepository.findAll();
    return toolModelMapper.toCollection(orders, OrderResponse.class);
  }

  @Transactional(readOnly = true)
  public OrderResponse findById(Long orderId) {
    Optional<Order> order = orderRepository.findById(orderId);
    if (order.isPresent()) {
      return toolModelMapper.toModel(order.get(), OrderResponse.class);
    }
    return toolModelMapper.toModel(order.orElseThrow(() -> new BusinessException("Order: não encontrada.")),
        OrderResponse.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long orderId) {
    return orderRepository.existsById(orderId);
  }

  public void deleteById(Long orderId) {
    orderRepository.deleteById(orderId);
  }

}
