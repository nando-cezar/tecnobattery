package com.tecnobattery.tbsystem.controllers.basic;

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.request.CommentResquest;
import com.tecnobattery.tbsystem.dto.response.CommentResponse;
import com.tecnobattery.tbsystem.entities.Comment;
import com.tecnobattery.tbsystem.entities.Order;
import com.tecnobattery.tbsystem.entities.User;
import com.tecnobattery.tbsystem.services.CommentService;
import com.tecnobattery.tbsystem.services.OrderService;
import com.tecnobattery.tbsystem.services.UserService;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  @Autowired
  private UserService userService;

  @Autowired
  private ToolModelMapper toolModelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CommentResponse save(@Valid @PathVariable Long orderId, @PathVariable Long userId,
      @RequestBody CommentResquest commentInput) {

    Comment comment = toolModelMapper.toModel(commentInput, Comment.class);
    comment.setMoment(OffsetDateTime.now());
    comment.setOrder(toolModelMapper.toModel(orderService.findById(orderId), Order.class));
    comment.setUser(toolModelMapper.toModel(userService.findById(userId), User.class));
    return commentService.save(comment);
  }

  @GetMapping
  public ResponseEntity<List<CommentResponse>> findAll() {
    return ResponseEntity.ok().body(commentService.findAll());
  }

  @GetMapping("/{commentId}")
  public ResponseEntity<CommentResponse> findById(@PathVariable Long commentId) {
    return ResponseEntity.ok(commentService.findById(commentId));
  }
}
