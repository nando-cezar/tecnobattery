package com.tecnobattery.tbsystem.dto.input;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tecnobattery.tbsystem.entities.Product;
import com.tecnobattery.tbsystem.entities.User;

public class OrderInput {

  private Long clientId;
  private String description;
  private Double price;
  private List<Product> products = new ArrayList<>();
  private Set<User> users = new HashSet<>();

  public Long getClientId() {
    return this.clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
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

  public List<Product> getProducts() {
    return this.products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public Set<User> getUsers() {
    return this.users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

}
