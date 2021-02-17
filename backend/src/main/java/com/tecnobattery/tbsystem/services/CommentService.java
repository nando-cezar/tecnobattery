package com.tecnobattery.tbsystem.services;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.CommentDTO;
import com.tecnobattery.tbsystem.entities.Comment;
import com.tecnobattery.tbsystem.entities.Order;
import com.tecnobattery.tbsystem.entities.User;
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

  public CommentDTO save(Long orderId, Long userId, String title, String description) throws Exception {
    Order order = orderRepository.findById(orderId).orElseThrow(() -> new Exception("Order: not found"));
    User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User: not found"));
    Comment comment = new Comment();
    comment.setOrder(order);
    comment.setUser(user);
    comment.setTitle(title);
    comment.setDescription(description);
    comment.setMoment(OffsetDateTime.now());

    return toModel(commentRepository.save(comment));
  }

  @Transactional(readOnly = true)
  public List<CommentDTO> findAll() {
    List<Comment> comments = commentRepository.findAll();
    return toCollectionDTO(comments);
  }

  private CommentDTO toModel(Comment comment) {
    return mapper.map(comment, CommentDTO.class);
  }

  private List<CommentDTO> toCollectionDTO(List<Comment> comments) {
    return comments.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
