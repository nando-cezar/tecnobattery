package com.tecnobattery.tbsystem.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class CommentDTO implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private OrderServiceDTO orderService;
  private UserDTO user;
  private String description;
  private OffsetDateTime moment;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OrderServiceDTO getOrderService() {
    return this.orderService;
  }

  public void setOrderService(OrderServiceDTO orderService) {
    this.orderService = orderService;
  }

  public UserDTO getUser() {
    return this.user;
  }

  public void setUser(UserDTO user) {
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

}
