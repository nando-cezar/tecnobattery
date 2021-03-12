package com.tecnobattery.tbsystem.server.message;

import javax.validation.constraints.NotBlank;

public class SmsRequest {

  @NotBlank
  private final String phoneNumber; // destination
  @NotBlank
  private final String message;

  public SmsRequest(String phoneNumber, String message) {
    this.phoneNumber = phoneNumber;
    this.message = message;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public String getMessage() {
    return this.message;
  }

  @Override
  public String toString() {
    return "{" + " phoneNumber='" + getPhoneNumber() + "'" + ", message='" + getMessage() + "'" + "}";
  }

}
