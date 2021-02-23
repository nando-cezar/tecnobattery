package com.tecnobattery.tbsystem.controllers;

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.output.OrderOutput;
import com.tecnobattery.tbsystem.entities.Order;
import com.tecnobattery.tbsystem.entities.OrderStatus;
import com.tecnobattery.tbsystem.dto.input.OrderInput;
import com.tecnobattery.tbsystem.services.OrderService;

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

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public OrderOutput save(@Valid @RequestBody OrderInput orderInput) {
    Order order = new Order();
    order.setDescription(orderInput.getDescription());
    order.setPrice(orderInput.getPrice());
    order.setStatus(OrderStatus.PENDENTE);
    order.setOpening(OffsetDateTime.now());
    order.setDeadline(null);
    order.setProducts(orderInput.getProducts());
    order.setUsers(orderInput.getUsers());

    return orderService.save(orderInput.getClientId(), order);
  }

  @GetMapping
  public ResponseEntity<List<OrderOutput>> findAll() {
    List<OrderOutput> list = orderService.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<OrderOutput> findById(@PathVariable Long orderId) {
    OrderOutput order = orderService.findById(orderId);
    if (order != null) {
      return ResponseEntity.ok(order);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{orderId}")
  public ResponseEntity<OrderOutput> update(@Valid @PathVariable Long orderId, @RequestBody OrderInput orderInput) {

    if (!orderService.existsById(orderId)) {
      return ResponseEntity.notFound().build();
    }

    Order order = new Order();
    order.setId(orderId);
    order.setDescription(orderInput.getDescription());
    order.setPrice(orderInput.getPrice());
    order.setProducts(orderInput.getProducts());
    order.setUsers(orderInput.getUsers());

    return ResponseEntity.ok(orderService.save(order));
  }

  @PutMapping("/finish/{orderId}")
  public ResponseEntity<OrderOutput> finish(@Valid @PathVariable Long orderId, @RequestBody OrderInput orderInput) {

    if (!orderService.existsById(orderId)) {
      return ResponseEntity.notFound().build();
    }

    Order order = new Order();
    order.setId(orderId);
    order.setStatus(OrderStatus.ENTREGUE);
    order.setDeadline(OffsetDateTime.now());

    return ResponseEntity.ok(orderService.save(order));
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
