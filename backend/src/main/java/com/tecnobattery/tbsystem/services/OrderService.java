package com.tecnobattery.tbsystem.services;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.OrderDTO;
import com.tecnobattery.tbsystem.entities.Client;
import com.tecnobattery.tbsystem.entities.Order;
import com.tecnobattery.tbsystem.entities.OrderStatus;
import com.tecnobattery.tbsystem.entities.Product;
import com.tecnobattery.tbsystem.entities.User;
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

  public OrderDTO save(Long clientId, String description, Double price, List<Product> products, Set<User> users)
      throws Exception {
    Client client = clientRepository.findById(clientId).orElseThrow(() -> new Exception("Client: not found"));
    Order order = new Order();
    order.setClient(client);
    order.setDescription(description);
    order.setPrice(price);
    order.setStatus(OrderStatus.PENDENTE);
    order.setOpening(OffsetDateTime.now());
    order.setDeadline(null);
    order.setProducts(products);
    order.setUsers(users);

    return toModel(orderRepository.save(order));
  }

  @Transactional(readOnly = true)
  public List<OrderDTO> findAll() {
    List<Order> orderServices = orderRepository.findAll();
    return toCollectionDTO(orderServices);
  }

  @Transactional(readOnly = true)
  public OrderDTO findById(Long orderId) throws Exception {
    Order order = orderRepository.findById(orderId).orElseThrow(() -> new Exception("Order: not found"));
    return toModel(order);
  }

  private OrderDTO toModel(Order orderService) {
    return mapper.map(orderService, OrderDTO.class);
  }

  private List<OrderDTO> toCollectionDTO(List<Order> orderServices) {
    return orderServices.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }

}
