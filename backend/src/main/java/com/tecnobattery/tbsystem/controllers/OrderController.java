package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import com.tecnobattery.tbsystem.dto.OrderDTO;
import com.tecnobattery.tbsystem.dto.input.OrderInput;
import com.tecnobattery.tbsystem.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
  public OrderDTO save(@RequestBody OrderInput order) throws Exception {
    return orderService.save(order.getClientId(), order.getDescription(), order.getPrice(), order.getProducts(),
        order.getUsers());
  }

  @GetMapping
  public ResponseEntity<List<OrderDTO>> findAll() {
    List<OrderDTO> list = orderService.findAll();
    return ResponseEntity.ok().body(list);
  }
}
