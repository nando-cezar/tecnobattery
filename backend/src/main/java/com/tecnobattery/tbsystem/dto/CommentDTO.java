package com.tecnobattery.tbsystem.dto;

import java.time.OffsetDateTime;
import java.util.Objects;

public class CommentDTO {

  private Long id;
  private OrderServiceDTO orderService;
  private UserDTO user;
  private String description;
  private OffsetDateTime moment;

  public CommentDTO() {
  }

  public CommentDTO(Long id, OrderServiceDTO orderService, UserDTO user, String description, OffsetDateTime moment) {
    this.id = id;
    this.orderService = orderService;
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

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof CommentDTO)) {
      return false;
    }
    CommentDTO commentDTO = (CommentDTO) o;
    return Objects.equals(id, commentDTO.id) && Objects.equals(orderService, commentDTO.orderService)
        && Objects.equals(user, commentDTO.user) && Objects.equals(description, commentDTO.description)
        && Objects.equals(moment, commentDTO.moment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, orderService, user, description, moment);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", orderService='" + getOrderService() + "'" + ", user='" + getUser() + "'"
        + ", description='" + getDescription() + "'" + ", moment='" + getMoment() + "'" + "}";
  }

}
