package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_comment")
public class Comment implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Order order;
  @ManyToOne
  private User user;
  private String description;
  private OffsetDateTime moment;

  public Comment() {
  }

  public Comment(Long id, Order order, User user, String description, OffsetDateTime moment) {
    this.id = id;
    this.order = order;
    this.user = user;
    this.description = description;
    this.moment = moment;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Order getOrder() {
    return this.order;
  }

  public void setOrderService(Order order) {
    this.order = order;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OffsetDateTime getMoment() {
    return this.moment;
  }

  public void setMoment(OffsetDateTime moment) {
    this.moment = moment;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Comment)) {
      return false;
    }
    Comment comment = (Comment) o;
    return Objects.equals(id, comment.id) && Objects.equals(order, comment.order) && Objects.equals(user, comment.user)
        && Objects.equals(description, comment.description) && Objects.equals(moment, comment.moment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, order, user, description, moment);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", order='" + getOrder() + "'" + ", user='" + getUser() + "'"
        + ", description='" + getDescription() + "'" + ", moment='" + getMoment() + "'" + "}";
  }

}
