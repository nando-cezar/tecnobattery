package com.tecnobattery.tbsystem.twilio.server.phone_number.config;

import com.tecnobattery.tbsystem.twilio.server.phone_number.listener.ValidPhoneNumber;
import com.twilio.exception.ApiException;
import com.twilio.rest.lookups.v1.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    value = value.replaceAll("[\\s()-]", "");

    if ("".equals(value)) {
      return false;
    }

    try {
      PhoneNumber.fetcher(new com.twilio.type.PhoneNumber(value)).fetch();
      return true;

    } catch (ApiException e) {
      if (e.getStatusCode() == 404) {
        return false;
      }
      throw e;
    }
  }
}
