package com.tecnobattery.tbsystem.dto.input;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tecnobattery.tbsystem.entities.Product;
import com.tecnobattery.tbsystem.entities.User;

public class OrderInput implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  @NotNull(message = "Cliente é obrigatório.")
  private Long clientId;
  @NotBlank(message = "Descrição se encontra em branco ou inválido.")
  @Size(max = 255, message = "Nome deve possuir no máximo 255 caracteres.")
  private String description;
  @NotNull(message = "Preço é obrigatório.")
  private Double price;
  @NotNull
  private List<Product> products = new ArrayList<>();
  @NotNull
  private Set<User> users = new HashSet<>();

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
