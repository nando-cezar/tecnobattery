package com.tecnobattery.tbsystem.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.tecnobattery.tbsystem.entities.OrderStatus;

public class OrderServiceDTO implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private ClientDTO client;
  private String description;
  private Double price;
  private OrderStatus status;
  private OffsetDateTime opening;
  private OffsetDateTime deadline;
  private List<ProductDTO> products = new ArrayList<>();
  private Set<UserDTO> users = new HashSet<>();
  private List<CommentDTO> comments = new ArrayList<>();

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ClientDTO getClient() {
    return this.client;
  }

  public void setClient(ClientDTO client) {
    this.client = client;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public OrderStatus getStatus() {
    return this.status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public OffsetDateTime getOpening() {
    return this.opening;
  }

  public void setOpening(OffsetDateTime opening) {
    this.opening = opening;
  }

  public OffsetDateTime getDeadline() {
    return this.deadline;
  }

  public void setDeadline(OffsetDateTime deadline) {
    this.deadline = deadline;
  }

  public List<ProductDTO> getProducts() {
    return this.products;
  }

  public void setProducts(List<ProductDTO> products) {
    this.products = products;
  }

  public Set<UserDTO> getUsers() {
    return this.users;
  }

  public void setUsers(Set<UserDTO> users) {
    this.users = users;
  }

  public List<CommentDTO> getComments() {
    return this.comments;
  }

  public void setComments(List<CommentDTO> comments) {
    this.comments = comments;
  }

}
