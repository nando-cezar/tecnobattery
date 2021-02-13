package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.OrderDTO;
import com.tecnobattery.tbsystem.entities.Order;
import com.tecnobattery.tbsystem.repositories.OrderServiceRepository;

import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

  @Autowired
  private OrderServiceRepository orderServiceRepository;

  @Autowired
  private ModelMapper mapper;

  @Transactional(readOnly = true)
  public List<OrderDTO> findAll() {
    List<Order> orderServices = orderServiceRepository.findAll();
    return toCollectionDTO(orderServices);
  }

  private OrderDTO toModel(Order orderService) {
    mapper.getConfiguration().setPropertyCondition(context -> !(context.getSource() instanceof PersistentCollection));
    return mapper.map(orderService, OrderDTO.class);
  }

  private List<OrderDTO> toCollectionDTO(List<Order> orderServices) {
    return orderServices.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
