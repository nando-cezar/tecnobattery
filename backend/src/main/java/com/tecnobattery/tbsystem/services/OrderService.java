package com.tecnobattery.tbsystem.services;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.CommentDTO;
import com.tecnobattery.tbsystem.dto.OrderDTO;
import com.tecnobattery.tbsystem.entities.Comment;
import com.tecnobattery.tbsystem.entities.Order;
import com.tecnobattery.tbsystem.entities.User;
import com.tecnobattery.tbsystem.repositories.CommentRepository;
import com.tecnobattery.tbsystem.repositories.OrderServiceRepository;
import com.tecnobattery.tbsystem.repositories.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

  @Autowired
  private OrderServiceRepository orderServiceRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private ModelMapper mapper;

  @Transactional(readOnly = true)
  public List<OrderDTO> findOrderAll() {
    List<Order> orderServices = orderServiceRepository.findAll();
    return toCollectionOrderDTO(orderServices);
  }

  @Transactional(readOnly = true)
  public OrderDTO findById(Long orderId) throws Exception {
    Order order = orderServiceRepository.findById(orderId).orElseThrow(() -> new Exception("Order: not found"));
    return toModelOrder(order);
  }

  public CommentDTO createComment(Long orderId, Long userId, String title, String description) throws Exception {
    Order order = orderServiceRepository.findById(orderId).orElseThrow(() -> new Exception("Order: not found"));
    User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User: not found"));
    Comment comment = new Comment();
    comment.setOrder(order);
    comment.setUser(user);
    comment.setMoment(OffsetDateTime.now());
    comment.setTitle(title);
    comment.setDescription(description);

    return toModelComment(comment);
  }

  @Transactional(readOnly = true)
  public List<CommentDTO> findCommentAll() {
    List<Comment> comments = commentRepository.findAll();
    return toCollectionCommentDTO(comments);
  }

  private OrderDTO toModelOrder(Order orderService) {
    return mapper.map(orderService, OrderDTO.class);
  }

  private List<OrderDTO> toCollectionOrderDTO(List<Order> orderServices) {
    return orderServices.stream().map(x -> toModelOrder(x)).collect(Collectors.toList());
  }

  private CommentDTO toModelComment(Comment comment) {
    return mapper.map(comment, CommentDTO.class);
  }

  private List<CommentDTO> toCollectionCommentDTO(List<Comment> comments) {
    return comments.stream().map(x -> toModelComment(x)).collect(Collectors.toList());
  }
}
