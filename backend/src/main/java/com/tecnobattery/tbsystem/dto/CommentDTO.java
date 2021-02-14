package com.tecnobattery.tbsystem.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class CommentDTO implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private OrderDTO order;
  private UserDTO user;
  private String title;
  private String description;
  private OffsetDateTime moment;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OrderDTO getOrder() {
    return this.order;
  }

  public void setOrder(OrderDTO order) {
    this.order = order;
  }

  public UserDTO getUser() {
    return this.user;
  }

  public void setUser(UserDTO user) {
    this.user = user;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
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

}
