package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
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
  private final Long id;
  @NotBlank(message = "Senha se encontra em branco ou inválido.")
  @Size(max = 20, message = "Senha deve possuir no máximo 20 caracteres.")
  private final String password;
  @NotBlank(message = "Username se encontra em branco ou inválido.")
  @Size(max = 20, message = "Username deve possuir no máximo 20 caracteres.")
  private final String username;
  @Valid
  private final Set<TelephoneRequest> telephones = new HashSet<>();
  @Valid
  private final Set<EmailRequest> emails = new HashSet<>();
  private final boolean isAccountNonExpired;
  private final boolean isAccountNonLocked;
  private final boolean isCredentialsNonExpired;
  private final boolean isEnabled;

  @Override
  public String toString() {
    return String.valueOf(getId());
  }

}
