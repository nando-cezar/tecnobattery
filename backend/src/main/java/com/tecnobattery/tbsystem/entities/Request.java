package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_request")
public class Request implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDateTime moment;
  private Double total;
  private String description;
  @ManyToOne
  private Client client;
  @ManyToOne
  private User user;
  @ManyToMany
  @JoinTable(name = "tb_request_product", joinColumns = @JoinColumn(name = "request_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
  private Set<Product> products = new HashSet<>();

  public Request() {
  }

  public Request(Long id, LocalDateTime moment, Double total, String description, Client client, User user,
      Set<Product> products) {
    this.id = id;
    this.moment = moment;
    this.total = total;
    this.description = description;
    this.client = client;
    this.user = user;
    this.products = products;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getMoment() {
    return this.moment;
  }

  public void setMoment(LocalDateTime moment) {
    this.moment = moment;
  }

  public Double getTotal() {
    return this.total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Client getClient() {
    return this.client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Set<Product> getProducts() {
    return this.products;
  }

  public void setProducts(Set<Product> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Request)) {
      return false;
    }
    Request request = (Request) o;
    return Objects.equals(id, request.id) && Objects.equals(moment, request.moment)
        && Objects.equals(total, request.total) && Objects.equals(description, request.description)
        && Objects.equals(client, request.client) && Objects.equals(user, request.user)
        && Objects.equals(products, request.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, moment, total, description, client, user, products);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", moment='" + getMoment() + "'" + ", total='" + getTotal() + "'"
        + ", description='" + getDescription() + "'" + ", client='" + getClient() + "'" + ", user='" + getUser() + "'"
        + ", products='" + getProducts() + "'" + "}";
  }

}
