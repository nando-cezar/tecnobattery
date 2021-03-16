package com.tecnobattery.tbsystem.dto.response;

import java.io.Serializable;

import com.tecnobattery.tbsystem.security.enumerated.ApplicationUserRoles;

public class UserResponse implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private String username;
  private String email;
  private String phone;
  private String password;
  private ApplicationUserRoles roles;
  private boolean active;

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

  public ApplicationUserRoles getRoles() {
    return this.roles;
  }

  public void setRoles(ApplicationUserRoles roles) {
    this.roles = roles;
  }

  public boolean isActive() {
    return this.active;
  }

  public boolean getActive() {
    return this.active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", username='" + getUsername() + "'" + ", email='" + getEmail() + "'"
        + ", phone='" + getPhone() + "'" + ", password='" + getPassword() + "'" + ", roles='" + getRoles() + "'" + "}";
  }

}
