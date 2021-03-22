package com.tecnobattery.tbsystem.dto.response;

import java.io.Serializable;

import com.tecnobattery.tbsystem.auth.enumerated.ApplicationUserRole;

public class UserResponse implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private ApplicationUserRole role;
  private String password;
  private String username;
  private String email;
  private String phoneNumber;
  private boolean isAccountNonExpired;
  private boolean isAccountNonLocked;
  private boolean isCredentialsNonExpired;
  private boolean isEnabled;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ApplicationUserRole getRole() {
    return this.role;
  }

  public void setRole(ApplicationUserRole role) {
    this.role = role;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public boolean isIsAccountNonExpired() {
    return this.isAccountNonExpired;
  }

  public boolean getIsAccountNonExpired() {
    return this.isAccountNonExpired;
  }

  public void setIsAccountNonExpired(boolean isAccountNonExpired) {
    this.isAccountNonExpired = isAccountNonExpired;
  }

  public boolean isIsAccountNonLocked() {
    return this.isAccountNonLocked;
  }

  public boolean getIsAccountNonLocked() {
    return this.isAccountNonLocked;
  }

  public void setIsAccountNonLocked(boolean isAccountNonLocked) {
    this.isAccountNonLocked = isAccountNonLocked;
  }

  public boolean isIsCredentialsNonExpired() {
    return this.isCredentialsNonExpired;
  }

  public boolean getIsCredentialsNonExpired() {
    return this.isCredentialsNonExpired;
  }

  public void setIsCredentialsNonExpired(boolean isCredentialsNonExpired) {
    this.isCredentialsNonExpired = isCredentialsNonExpired;
  }

  public boolean isIsEnabled() {
    return this.isEnabled;
  }

  public boolean getIsEnabled() {
    return this.isEnabled;
  }

  public void setIsEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", role='" + getRole() + "'" + ", password='" + getPassword() + "'"
        + ", username='" + getUsername() + "'" + ", email='" + getEmail() + "'" + ", phoneNumber='" + getPhoneNumber()
        + "'" + ", isAccountNonExpired='" + isIsAccountNonExpired() + "'" + ", isAccountNonLocked='"
        + isIsAccountNonLocked() + "'" + ", isCredentialsNonExpired='" + isIsCredentialsNonExpired() + "'"
        + ", isEnabled='" + isIsEnabled() + "'" + "}";
  }

}
