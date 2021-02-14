package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import com.tecnobattery.tbsystem.dto.CommentDTO;
import com.tecnobattery.tbsystem.dto.OrderDTO;
import com.tecnobattery.tbsystem.entities.Comment;
import com.tecnobattery.tbsystem.services.CommentService;
import com.tecnobattery.tbsystem.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders/{orderId}/{userId}/comments")
public class CommentController {

  @Autowired
  private CommentService commentService;

  @Autowired
  private OrderService orderService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CommentDTO save(@PathVariable Long orderId, @PathVariable Long userId, @RequestBody Comment comment)
      throws Exception {
    return commentService.save(orderId, userId, comment.getTitle(), comment.getDescription());
  }

  @GetMapping
  public List<CommentDTO> findAll(@PathVariable Long orderId) throws Exception {
    OrderDTO order = orderService.findById(orderId);
    return order.getComments();
  }

}
