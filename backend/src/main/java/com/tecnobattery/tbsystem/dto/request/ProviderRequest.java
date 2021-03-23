package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tecnobattery.tbsystem.twilio.server.phone_number.listener.ValidPhoneNumber;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProviderRequest implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  @NotBlank(message = "CNPJ se encontra em branco ou inválido.")
  @CNPJ(message = "CNPJ inválido.")
  private String cnpj;
  @NotBlank(message = "Nome se encontra em branco ou inválido.")
  private String name;
  @NotBlank(message = "Nome Fantasia se encontra em branco ou inválido.")
  private String fantasyName;
  @NotNull(message = "Telefone se encontra em branco ou inválido.")
  @ValidPhoneNumber(message = "Telefone inválido.")
  private String phoneNumber;
  @NotBlank(message = "E-mail se encontra em branco ou inválido.")
  @Email(message = "E-mail inválido.")
  private String email;
  @Valid
  private AddressRequest address;

}
