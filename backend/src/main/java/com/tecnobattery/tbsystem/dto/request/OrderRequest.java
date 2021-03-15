package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrderRequest implements Serializable {

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
  @NotNull(message = "Produto é obrigatório.")
  private List<ProductRequest> products = new ArrayList<>();
  @NotNull(message = "Usuário é obrigatório.")
  private Set<UserRequest> users = new HashSet<>();

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

  public List<ProductRequest> getProducts() {
    return this.products;
  }

  public void setProducts(List<ProductRequest> products) {
    this.products = products;
  }

  public Set<UserRequest> getUsers() {
    return this.users;
  }

  public void setUsers(Set<UserRequest> users) {
    this.users = users;
  }

}
