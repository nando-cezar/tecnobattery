package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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
  private final Long id;
  @NotBlank(message = "CNPJ se encontra em branco ou inválido.")
  @CNPJ(message = "CNPJ inválido.")
  private final String cnpj;
  @NotBlank(message = "Nome se encontra em branco ou inválido.")
  private final String name;
  @NotBlank(message = "Nome Fantasia se encontra em branco ou inválido.")
  private final String fantasyName;
  @Valid
  private final AddressRequest address;
  @Valid
  private final Set<TelephoneRequest> telephones = new HashSet<>();
  @Valid
  private final Set<EmailRequest> emails = new HashSet<>();

}
