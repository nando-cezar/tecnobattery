package com.tecnobattery.tbsystem.dto.output;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tecnobattery.tbsystem.entities.OrderStatus;

public class OrderOutput implements Serializable {

  /** 
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private ClientOutput client;
  private String description;
  private Double price;
  private OrderStatus status;
  private OffsetDateTime opening;
  private OffsetDateTime deadline;
  private List<ProductOutput> products = new ArrayList<>();
  private Set<UserOutput> users = new HashSet<>();

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ClientOutput getClient() {
    return this.client;
  }

  public void setClient(ClientOutput client) {
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

  public List<ProductOutput> getProducts() {
    return this.products;
  }

  public void setProducts(List<ProductOutput> products) {
    this.products = products;
  }

  public Set<UserOutput> getUsers() {
    return this.users;
  }

  public void setUsers(Set<UserOutput> users) {
    this.users = users;
  }

}
