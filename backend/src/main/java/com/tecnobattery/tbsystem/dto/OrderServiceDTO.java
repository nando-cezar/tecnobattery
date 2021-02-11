package com.tecnobattery.tbsystem.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.tecnobattery.tbsystem.entities.OrderService;
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

  public OrderServiceDTO() {
  }

  public OrderServiceDTO(Long id, ClientDTO client, String description, Double price, OrderStatus status,
      OffsetDateTime opening, OffsetDateTime deadline, List<ProductDTO> products, Set<UserDTO> users,
      List<CommentDTO> comments) {
    this.id = id;
    this.client = client;
    this.description = description;
    this.price = price;
    this.status = status;
    this.opening = opening;
    this.deadline = deadline;
    this.products = products;
    this.users = users;
    this.comments = comments;
  }

  public OrderServiceDTO(OrderService entity) {
    this.id = entity.getId();
    this.client = entity.getClient();
    this.description = entity.getDescription();
    this.price = entity.getPrice();
    this.status = entity.getStatus();
    this.opening = entity.getOpening();
    this.deadline = entity.getDeadline();
    this.products = entity.getProducts();
    this.users = entity.getUsers();
    this.comments = entity.getComments();
  }

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

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof OrderServiceDTO)) {
      return false;
    }
    OrderServiceDTO orderServiceDTO = (OrderServiceDTO) o;
    return Objects.equals(id, orderServiceDTO.id) && Objects.equals(client, orderServiceDTO.client)
        && Objects.equals(description, orderServiceDTO.description) && Objects.equals(price, orderServiceDTO.price)
        && Objects.equals(status, orderServiceDTO.status) && Objects.equals(opening, orderServiceDTO.opening)
        && Objects.equals(deadline, orderServiceDTO.deadline) && Objects.equals(products, orderServiceDTO.products)
        && Objects.equals(users, orderServiceDTO.users) && Objects.equals(comments, orderServiceDTO.comments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, client, description, price, status, opening, deadline, products, users, comments);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", client='" + getClient() + "'" + ", description='" + getDescription() + "'"
        + ", price='" + getPrice() + "'" + ", status='" + getStatus() + "'" + ", opening='" + getOpening() + "'"
        + ", deadline='" + getDeadline() + "'" + ", products='" + getProducts() + "'" + ", users='" + getUsers() + "'"
        + ", comments='" + getComments() + "'" + "}";
  }

}
