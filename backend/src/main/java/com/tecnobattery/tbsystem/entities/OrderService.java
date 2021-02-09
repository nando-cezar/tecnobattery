package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order_service")
public class OrderService implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Client client;
  @ManyToOne
  private Product product;
  private String description;
  private Integer amount;
  private Double price;
  private OrderStatus status;
  private OffsetDateTime opening;
  private OffsetDateTime deadline;

  @ManyToMany
  @JoinTable(name = "tb_order_user", joinColumns = @JoinColumn(name = "orderService_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Set<User> users = new HashSet<>();

  @OneToMany(mappedBy = "orderService")
  private List<Comment> comments = new ArrayList<>();

  public OrderService() {
  }

  public OrderService(Long id, Client client, Product product, String description, Integer amount, Double price,
      OrderStatus status, OffsetDateTime opening, OffsetDateTime deadline, Set<User> users) {
    this.id = id;
    this.client = client;
    this.product = product;
    this.description = description;
    this.amount = amount;
    this.price = price;
    this.status = status;
    this.opening = opening;
    this.deadline = deadline;
    this.users = users;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Client getClient() {
    return this.client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Product getProduct() {
    return this.product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getAmount() {
    return this.amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
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

  public Set<User> getUsers() {
    return this.users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  public List<Comment> getComments() {
    return this.comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof OrderService)) {
      return false;
    }
    OrderService orderService = (OrderService) o;
    return Objects.equals(id, orderService.id) && Objects.equals(client, orderService.client)
        && Objects.equals(product, orderService.product) && Objects.equals(description, orderService.description)
        && Objects.equals(amount, orderService.amount) && Objects.equals(price, orderService.price)
        && Objects.equals(status, orderService.status) && Objects.equals(opening, orderService.opening)
        && Objects.equals(deadline, orderService.deadline) && Objects.equals(users, orderService.users)
        && Objects.equals(comments, orderService.comments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, client, product, description, amount, price, status, opening, deadline, users, comments);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", client='" + getClient() + "'" + ", product='" + getProduct() + "'"
        + ", description='" + getDescription() + "'" + ", amount='" + getAmount() + "'" + ", price='" + getPrice() + "'"
        + ", status='" + getStatus() + "'" + ", opening='" + getOpening() + "'" + ", deadline='" + getDeadline() + "'"
        + ", users='" + getUsers() + "'" + ", comments='" + getComments() + "'" + "}";
  }

}
