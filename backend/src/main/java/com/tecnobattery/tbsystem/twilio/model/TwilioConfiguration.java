package com.tecnobattery.tbsystem.twilio.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfiguration {

  private String accountSid;
  private String authToken;
  private String messagingServiceSid;
  private String fromPhoneNumber;

  public TwilioConfiguration() {
  }

  public TwilioConfiguration(String accountSid, String authToken, String messagingServiceSid, String fromPhoneNumber) {
    this.accountSid = accountSid;
    this.authToken = authToken;
    this.messagingServiceSid = messagingServiceSid;
    this.fromPhoneNumber = fromPhoneNumber;
  }

  public String getAccountSid() {
    return this.accountSid;
  }

  public void setAccountSid(String accountSid) {
    this.accountSid = accountSid;
  }

  public String getAuthToken() {
    return this.authToken;
  }

  public void setAuthToken(String authToken) {
    this.authToken = authToken;
  }

  public String getMessagingServiceSid() {
    return this.messagingServiceSid;
  }

  public void setMessagingServiceSid(String messagingServiceSid) {
    this.messagingServiceSid = messagingServiceSid;
  }

  public String getFromPhoneNumber() {
    return this.fromPhoneNumber;
  }

  public void setFromPhoneNumber(String fromPhoneNumber) {
    this.fromPhoneNumber = fromPhoneNumber;
  }

}
