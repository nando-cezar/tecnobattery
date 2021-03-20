package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRequest implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  @NotBlank(message = "Senha se encontra em branco ou inválido.")
  @Size(max = 20, message = "Senha deve possuir no máximo 14 caracteres.")
  private String password;
  @NotBlank(message = "Username se encontra em branco ou inválido.")
  @Size(max = 20, message = "Username deve possuir no máximo 20 caracteres.")
  private String username;
  @NotBlank(message = "E-mail se encontra em branco ou inválido.")
  @Email(message = "E-mail inválido.")
  private String email;
  @NotBlank(message = "Telefone se encontra em branco ou inválido.")
  @Size(max = 14, message = "Telefone deve possuir no máximo 14 caracteres.")
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
    return String.valueOf(getId());
  }

}
