package com.tecnobattery.tbsystem.dto.input;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.tecnobattery.tbsystem.entities.TypeUser;

public class UserInput implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  @NotBlank(message = "Username se encontra em branco ou inválido.")
  @Size(max = 20, message = "Username deve possuir no máximo 20 caracteres.")
  private String username;
  @NotBlank(message = "E-mail se encontra em branco ou inválido.")
  @Email(message = "E-mail inválido.")
  private String email;
  @NotBlank(message = "Telefone se encontra em branco ou inválido.")
  @Size(max = 14, message = "Telefone deve possuir no máximo 14 caracteres.")
  private String phone;
  @NotBlank(message = "Senha se encontra em branco ou inválido.")
  @Size(max = 20, message = "Senha deve possuir no máximo 14 caracteres.")
  private String password;
  @Enumerated(EnumType.STRING)
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

  @Override
  public String toString() {
    return String.valueOf(getId());
  }

}
