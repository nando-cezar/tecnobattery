package com.tecnobattery.tbsystem.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tecnobattery.tbsystem.entities.TypeUser;

public class UserDTO implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private String username;
  private String email;
  private String phone;
  private String password;
  private TypeUser level;
  private Set<OrderDTO> orderServices = new HashSet<>();
  private List<CommentDTO> comments = new ArrayList<>();

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public TypeUser getLevel() {
    return this.level;
  }

  public void setLevel(TypeUser level) {
    this.level = level;
  }

  public Set<OrderDTO> getOrderServices() {
    return this.orderServices;
  }

  public void setOrderServices(Set<OrderDTO> orderServices) {
    this.orderServices = orderServices;
  }

  public List<CommentDTO> getComments() {
    return this.comments;
  }

  public void setComments(List<CommentDTO> comments) {
    this.comments = comments;
  }

}
