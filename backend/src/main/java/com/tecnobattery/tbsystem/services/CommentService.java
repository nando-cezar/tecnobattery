package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.CommentResponse;
import com.tecnobattery.tbsystem.entities.Comment;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.CommentRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;
  private final ToolModelMapper toolModelMapper;

  public CommentResponse save(Comment comment) {
    return toolModelMapper.toModel(commentRepository.save(comment), CommentResponse.class);
  }

  public List<CommentResponse> findAll() {
    return toolModelMapper.toCollection(commentRepository.findAll(), CommentResponse.class);
  }

  public CommentResponse findById(Long commentId) {
    Optional<Comment> comment = commentRepository.findById(commentId);
    if (comment.isPresent()) {
      return toolModelMapper.toModel(comment.get(), CommentResponse.class);
    }
    return toolModelMapper.toModel(comment.orElseThrow(() -> new BusinessException("Comment: não encontrada.")),
        CommentResponse.class);
  }

  public boolean existsById(Long commentId) {
    return commentRepository.existsById(commentId);
  }

  public void deleteById(Long commentId) {
    commentRepository.deleteById(commentId);
  }
}
