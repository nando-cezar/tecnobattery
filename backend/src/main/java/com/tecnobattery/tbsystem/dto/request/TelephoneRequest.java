package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.tecnobattery.tbsystem.twilio.server.phone_number.listener.ValidPhoneNumber;

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
public class TelephoneRequest implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private final Long id;
  @NotBlank(message = "Telefone se encontra em branco ou inválido.")
  @ValidPhoneNumber(message = "Telefone inválido.")
  private final String number;

}
