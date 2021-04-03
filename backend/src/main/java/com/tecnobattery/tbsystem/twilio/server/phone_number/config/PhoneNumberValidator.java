package com.tecnobattery.tbsystem.twilio.server.phone_number.config;

import com.tecnobattery.tbsystem.twilio.server.phone_number.listener.ValidPhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    value = value.replaceAll("[\\s()-]", "");

    if ("".equals(value) && value.length() <= 15 && !value.contains("+")) {
      return false;
    }
    return true;
  }
}
