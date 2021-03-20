package com.tecnobattery.tbsystem.controllers.management;

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.auth.model.User;
import com.tecnobattery.tbsystem.auth.service.UserService;
import com.tecnobattery.tbsystem.dto.request.CommentResquest;
import com.tecnobattery.tbsystem.dto.response.CommentResponse;
import com.tecnobattery.tbsystem.entities.Comment;
import com.tecnobattery.tbsystem.entities.Order;
import com.tecnobattery.tbsystem.services.CommentService;
import com.tecnobattery.tbsystem.services.OrderService;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping(value = "/management/orders/{orderId}/{userId}/comments")
public class CommentManagementController {

  @Autowired
  private CommentService commentService;

  @Autowired
  private OrderService orderService;

  @Autowired
  private UserService userService;

  @Autowired
  private ToolModelMapper toolModelMapper;

  @PostMapping
  @PreAuthorize("hasAuthority('global:write')")
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
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<List<CommentResponse>> findAll() {
    return ResponseEntity.ok().body(commentService.findAll());
  }

  @GetMapping("/{commentId}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<CommentResponse> findById(@PathVariable Long commentId) {
    return ResponseEntity.ok(commentService.findById(commentId));
  }

  @PutMapping("/{commentId}")
  @PreAuthorize("hasAuthority('global:write')")
  public ResponseEntity<CommentResponse> update(@Valid @PathVariable Long commentId,
      @RequestBody CommentResquest commentInput) {

    if (!commentService.existsById(commentId)) {
      return ResponseEntity.notFound().build();
    }

    Comment comment = new Comment();
    comment = toolModelMapper.toModel(commentInput, Comment.class);
    comment.setId(commentId);

    return ResponseEntity.ok(commentService.save(comment));
  }

  @DeleteMapping("/{commentId}")
  @PreAuthorize("hasAuthority('global:write')")
  public ResponseEntity<Void> deleteById(@PathVariable Long commentId) {
    if (!commentService.existsById(commentId)) {
      return ResponseEntity.notFound().build();
    }
    commentService.deleteById(commentId);
    return ResponseEntity.noContent().build();
  }
}
