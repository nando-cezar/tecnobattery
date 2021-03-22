package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tecnobattery.tbsystem.auth.model.User;
import com.tecnobattery.tbsystem.entities.enumerated.OrderStatus;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Client client;
  private String description;
  private Double price;
  @Enumerated(EnumType.STRING)
  private OrderStatus status;
  private OffsetDateTime opening;
  private OffsetDateTime deadline;

  @ManyToMany
  @JoinTable(name = "tb_order_product", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Product> products = new ArrayList<>();

  @ManyToMany
  @JoinTable(name = "tb_order_user", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Set<User> users = new HashSet<>();

  public Order(Client client, String description, Double price, OrderStatus status, OffsetDateTime opening,
      OffsetDateTime deadline, List<Product> products, Set<User> users) {
    this.client = client;
    this.description = description;
    this.price = price;
    this.status = status;
    this.opening = opening;
    this.deadline = deadline;
    this.products = products;
    this.users = users;
  }

}
