package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.OrderResponse;
import com.tecnobattery.tbsystem.entities.Order;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.OrderRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final ToolModelMapper toolModelMapper;

  public OrderResponse save(Order order) {
    return toolModelMapper.toModel(orderRepository.save(order), OrderResponse.class);
  }

  public List<OrderResponse> findAll() {
    return toolModelMapper.toCollection(orderRepository.findOrdersWithProducts(), OrderResponse.class);
  }

  public OrderResponse findById(Long orderId) {
    Optional<Order> order = orderRepository.findById(orderId);
    if (order.isPresent()) {
      return toolModelMapper.toModel(order.get(), OrderResponse.class);
    }
    return toolModelMapper.toModel(order.orElseThrow(() -> new BusinessException("Order: não encontrada.")),
        OrderResponse.class);
  }

  public boolean existsById(Long orderId) {
    return orderRepository.existsById(orderId);
  }

  public void deleteById(Long orderId) {
    orderRepository.deleteById(orderId);
  }

}
