package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.CommentResponse;
import com.tecnobattery.tbsystem.entities.Comment;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.CommentRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private ToolModelMapper toolModelMapper;

  public CommentResponse save(Comment comment) {
    return toolModelMapper.toModel(commentRepository.save(comment), CommentResponse.class);
  }

  @Transactional(readOnly = true)
  public List<CommentResponse> findAll() {
    List<Comment> comments = commentRepository.findAll();
    return toolModelMapper.toCollection(comments, CommentResponse.class);
  }

  @Transactional(readOnly = true)
  public CommentResponse findById(Long commentId) {
    Optional<Comment> comment = commentRepository.findById(commentId);
    if (comment.isPresent()) {
      return toolModelMapper.toModel(comment.get(), CommentResponse.class);
    }
    return toolModelMapper.toModel(comment.orElseThrow(() -> new BusinessException("Comment: não encontrada.")),
        CommentResponse.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long commentId) {
    return commentRepository.existsById(commentId);
  }

  public void deleteById(Long commentId) {
    commentRepository.deleteById(commentId);
  }
}
