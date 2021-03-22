package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
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

  @Override
  public String toString() {
    return String.valueOf(getId());
  }

}
