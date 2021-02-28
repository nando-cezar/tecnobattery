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

    return orderService.save(orderInput.getClientId(), orderInput.getProducts(), orderInput.getUsers(), order);
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
  public ResponseEntity<Order> update(@Valid @PathVariable Long orderId, @RequestBody Order order) {

    if (!orderService.existsById(orderId)) {
      return ResponseEntity.notFound().build();
    }
 
    order.setId(orderId);
    order = orderService.save(order);

    return ResponseEntity.ok(order);
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
