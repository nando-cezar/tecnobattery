package com.tecnobattery.tbsystem.twilio.initializer;

import com.tecnobattery.tbsystem.twilio.model.TwilioConfiguration;
import com.twilio.Twilio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {

  private static final Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);

  private final TwilioConfiguration twilioConfiguration;

  @Autowired
  public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
    this.twilioConfiguration = twilioConfiguration;
    Twilio.init(this.twilioConfiguration.getAccountSid(), this.twilioConfiguration.getAuthToken());
    LOGGER.info("Twilio initialized ... with account sid {} ", this.twilioConfiguration.getAccountSid());
  }

}
