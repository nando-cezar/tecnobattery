package com.tecnobattery.tbsystem.dto.response;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tecnobattery.tbsystem.entities.OrderStatus;

@JsonInclude(Include.NON_NULL)
public class OrderResponse implements Serializable {

  /** 
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private ClientResponse client;
  private String description;
  private Double price;
  private OrderStatus status;
  private OffsetDateTime opening;
  private OffsetDateTime deadline;
  private List<ProductResponse> products = new ArrayList<>();
  private Set<UserResponse> users = new HashSet<>();

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ClientResponse getClient() {
    return this.client;
  }

  public void setClient(ClientResponse client) {
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

  public List<ProductResponse> getProducts() {
    return this.products;
  }

  public void setProducts(List<ProductResponse> products) {
    this.products = products;
  }

  public Set<UserResponse> getUsers() {
    return this.users;
  }

  public void setUsers(Set<UserResponse> users) {
    this.users = users;
  }

}
