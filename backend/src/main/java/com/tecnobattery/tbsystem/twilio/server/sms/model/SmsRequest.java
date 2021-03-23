package com.tecnobattery.tbsystem.twilio.server.sms.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.tecnobattery.tbsystem.twilio.server.phone_number.listener.ValidPhoneNumber;

public class SmsRequest {

  @NotBlank(message = "Número de telefone se encontra em branco ou inválido.")
  @Size(max = 14, message = "Número de telefone deve possuir no máximo 14 caracteres.")
  @ValidPhoneNumber(message = "Telefone inválido.")
  private final String toPhoneNumber;
  @NotBlank(message = "Corpo da mensagem se encontra em branco ou inválido.")
  @Size(max = 255, message = "Número de telefone deve possuir no máximo 255 caracteres.")
  private final String bodyMessage;

  public SmsRequest(String toPhoneNumber, String bodyMessage) {
    this.toPhoneNumber = toPhoneNumber;
    this.bodyMessage = bodyMessage;
  }

  public String getToPhoneNumber() {
    return this.toPhoneNumber;
  }

  public String getBodyMessage() {
    return this.bodyMessage;
  }

  @Override
  public String toString() {
    return "{" + " toPhoneNumber='" + getToPhoneNumber() + "'" + ", bodyMessage='" + getBodyMessage() + "'" + "}";
  }

}
