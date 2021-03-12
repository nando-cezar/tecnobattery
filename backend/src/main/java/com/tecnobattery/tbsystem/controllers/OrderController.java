package com.tecnobattery.tbsystem.controllers;

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.output.OrderOutput;
import com.tecnobattery.tbsystem.entities.Client;
import com.tecnobattery.tbsystem.entities.Order;
import com.tecnobattery.tbsystem.entities.OrderStatus;
import com.tecnobattery.tbsystem.entities.Product;
import com.tecnobattery.tbsystem.entities.User;
import com.tecnobattery.tbsystem.dto.input.OrderInput;
import com.tecnobattery.tbsystem.services.ClientService;
import com.tecnobattery.tbsystem.services.OrderService;
import com.tecnobattery.tbsystem.services.ProductService;
import com.tecnobattery.tbsystem.services.UserService;
import com.tecnobattery.tbsystem.tools.ToolConvertIdObject;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @Autowired
  private ClientService clientService;

  @Autowired
  private ProductService productService;

  @Autowired
  private UserService userService;

  @Autowired
  private ToolModelMapper toolModelMapper;

  @Autowired
  private ToolConvertIdObject toolConvertIdObject;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public OrderOutput save(@Valid @RequestBody OrderInput orderInput) {

    Order order = toolModelMapper.toModel(orderInput, Order.class);
    order.setClient(toolModelMapper.toModel(clientService.findById(orderInput.getClientId()), Client.class));
    order.setStatus(OrderStatus.PENDENTE);
    order.setOpening(OffsetDateTime.now());
    order.setProducts(toolConvertIdObject.getObjectId(orderInput.getProducts(), productService, Product.class));
    order.setUsers(toolConvertIdObject.getObjectId(orderInput.getUsers(), userService, User.class));

    return orderService.save(order);
  }

  @GetMapping
  public ResponseEntity<List<OrderOutput>> findAll() {
    return ResponseEntity.ok().body(orderService.findAll());
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<OrderOutput> findById(@PathVariable Long orderId) {
    return ResponseEntity.ok(orderService.findById(orderId));
  }

  @PutMapping("/{orderId}")
  public ResponseEntity<OrderOutput> update(@Valid @PathVariable Long orderId, @RequestBody OrderInput orderInput) {

    if (!orderService.existsById(orderId)) {
      return ResponseEntity.notFound().build();
    }

    Order order = toolModelMapper.toModel(orderService.findById(orderId), Order.class);
    order.setClient(toolModelMapper.toModel(clientService.findById(orderInput.getClientId()), Client.class));
    order.setDescription(orderInput.getDescription());
    order.setPrice(orderInput.getPrice());
    order.setProducts(toolModelMapper.toCollection(orderInput.getProducts(), Product.class));
    order.setUsers(toolModelMapper.toCollection(orderInput.getUsers(), User.class));
    order.setId(orderId);

    return ResponseEntity.ok(orderService.save(order));
  }

  @PutMapping("finish/{orderId}")
  public ResponseEntity<OrderOutput> finish(@Valid @PathVariable Long orderId) {

    if (!orderService.existsById(orderId)) {
      return ResponseEntity.notFound().build();
    }

    Order order = toolModelMapper.toModel(orderService.findById(orderId), Order.class);

    if (order.getDeadline() == null) {

      order.setStatus(OrderStatus.ENTREGUE);
      order.setDeadline(OffsetDateTime.now());
      order.setId(orderId);
      return ResponseEntity.ok(orderService.save(order));
    }
    return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("/{orderId}")
  public ResponseEntity<Void> deleteById(@PathVariable Long orderId) {
    if (!orderService.existsById(orderId)) {
      return ResponseEntity.notFound().build();
    }
    orderService.deleteById(orderId);
    return ResponseEntity.noContent().build();
  }

}
