package com.tecnobattery.tbsystem.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.tecnobattery.tbsystem.entities.TypeUser;

public class UserDTO {

  private Long id;
  private String username;
  private String email;
  private String phone;
  private String password;
  private TypeUser level;
  private Set<OrderServiceDTO> orderServices = new HashSet<>();
  private List<CommentDTO> comments = new ArrayList<>();

  public UserDTO() {
  }

  public UserDTO(Long id, String username, String email, String phone, String password, TypeUser level,
      Set<OrderServiceDTO> orderServices, List<CommentDTO> comments) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.phone = phone;
    this.password = password;
    this.level = level;
    this.orderServices = orderServices;
    this.comments = comments;
  }

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

  public Set<OrderServiceDTO> getOrderServices() {
    return this.orderServices;
  }

  public void setOrderServices(Set<OrderServiceDTO> orderServices) {
    this.orderServices = orderServices;
  }

  public List<CommentDTO> getComments() {
    return this.comments;
  }

  public void setComments(List<CommentDTO> comments) {
    this.comments = comments;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof UserDTO)) {
      return false;
    }
    UserDTO userDTO = (UserDTO) o;
    return Objects.equals(id, userDTO.id) && Objects.equals(username, userDTO.username)
        && Objects.equals(email, userDTO.email) && Objects.equals(phone, userDTO.phone)
        && Objects.equals(password, userDTO.password) && Objects.equals(level, userDTO.level)
        && Objects.equals(orderServices, userDTO.orderServices) && Objects.equals(comments, userDTO.comments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, email, phone, password, level, orderServices, comments);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", username='" + getUsername() + "'" + ", email='" + getEmail() + "'"
        + ", phone='" + getPhone() + "'" + ", password='" + getPassword() + "'" + ", level='" + getLevel() + "'"
        + ", orderServices='" + getOrderServices() + "'" + ", comments='" + getComments() + "'" + "}";
  }

}
