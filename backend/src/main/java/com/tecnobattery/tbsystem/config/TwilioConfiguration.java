package com.tecnobattery.tbsystem.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfiguration {

  private String accountSid;
  private String authToken;
  private String trialNumber;

  public TwilioConfiguration() {
  }

  public TwilioConfiguration(String accountSid, String authToken, String trialNumber) {
    this.accountSid = accountSid;
    this.authToken = authToken;
    this.trialNumber = trialNumber;
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

  public String getTrialNumber() {
    return this.trialNumber;
  }

  public void setTrialNumber(String trialNumber) {
    this.trialNumber = trialNumber;
  }

}
