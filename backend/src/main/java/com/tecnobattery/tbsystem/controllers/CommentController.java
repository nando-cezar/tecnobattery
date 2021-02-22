package com.tecnobattery.tbsystem.controllers;

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.output.CommentOutput;
import com.tecnobattery.tbsystem.entities.Comment;
import com.tecnobattery.tbsystem.dto.input.CommentInput;
import com.tecnobattery.tbsystem.services.CommentService;

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
@RequestMapping(value = "/orders/{orderId}/{userId}/comments")
public class CommentController {

  @Autowired
  private CommentService commentService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CommentOutput save(@Valid @PathVariable Long orderId, @PathVariable Long userId,
      @RequestBody CommentInput commentInput) {
    Comment comment = new Comment();
    comment.setTitle(commentInput.getTitle());
    comment.setDescription(commentInput.getDescription());
    comment.setMoment(OffsetDateTime.now());
    return commentService.save(orderId, userId, comment);
  }

  @GetMapping
  public ResponseEntity<List<CommentOutput>> findAll() {
    List<CommentOutput> list = commentService.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/{commentId}")
  public ResponseEntity<CommentOutput> findById(@PathVariable Long commentId) {
    CommentOutput comment = commentService.findById(commentId);
    if (comment != null) {
      return ResponseEntity.ok(comment);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{commentId}")
  public ResponseEntity<CommentOutput> update(@Valid @PathVariable Long commentId,
      @RequestBody CommentInput commentInput) {

    if (!commentService.existsById(commentId)) {
      return ResponseEntity.notFound().build();
    }

    Comment comment = new Comment();
    comment.setTitle(commentInput.getTitle());
    comment.setDescription(commentInput.getDescription());
    comment.setMoment(OffsetDateTime.now());

    return ResponseEntity.ok(commentService.save(comment));
  }

  @DeleteMapping("/{commentId}")
  public ResponseEntity<Void> deleteById(@PathVariable Long commentId) {
    if (!commentService.existsById(commentId)) {
      return ResponseEntity.notFound().build();
    }
    commentService.deleteById(commentId);
    return ResponseEntity.noContent().build();
  }
}
