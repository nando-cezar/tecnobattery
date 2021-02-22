package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.output.CommentOutput;
import com.tecnobattery.tbsystem.entities.Comment;
import com.tecnobattery.tbsystem.entities.Order;
import com.tecnobattery.tbsystem.entities.User;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.CommentRepository;
import com.tecnobattery.tbsystem.repositories.OrderRepository;
import com.tecnobattery.tbsystem.repositories.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private ModelMapper mapper;

  public CommentOutput save(Comment comment) {
    return toModel(commentRepository.save(comment));
  }

  public CommentOutput save(Long orderId, Long userId, Comment comment) {
    Order order = orderRepository.findById(orderId).orElseThrow(() -> new BusinessException("Order: não encontrada."));
    User user = userRepository.findById(userId).orElseThrow(() -> new BusinessException("Usuário: não encontrado."));
    comment.setOrder(order);
    comment.setUser(user);
    return toModel(commentRepository.save(comment));
  }

  @Transactional(readOnly = true)
  public List<CommentOutput> findAll() {
    List<Comment> comments = commentRepository.findAll();
    return toCollectionDTO(comments);
  }

  @Transactional(readOnly = true)
  public CommentOutput findById(Long commentId) {
    Optional<Comment> comment = commentRepository.findById(commentId);
    if (comment.isPresent()) {
      return toModel(comment.get());
    }
    return null;
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long commentId) {
    return commentRepository.existsById(commentId);
  }

  public void deleteById(Long commentId) {
    commentRepository.deleteById(commentId);
  }

  private CommentOutput toModel(Comment comment) {
    return mapper.map(comment, CommentOutput.class);
  }

  private List<CommentOutput> toCollectionDTO(List<Comment> comments) {
    return comments.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
