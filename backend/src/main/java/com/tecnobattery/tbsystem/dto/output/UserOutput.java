package com.tecnobattery.tbsystem.dto.output;

import java.io.Serializable;

import com.tecnobattery.tbsystem.entities.TypeUser;

public class UserOutput implements Serializable {

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

}
