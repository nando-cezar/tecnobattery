package com.tecnobattery.tbsystem.twilio.server.sms.model;

import java.time.ZonedDateTime;

import com.twilio.type.PhoneNumber;

public class SmsResponse {

  private String accountSid;
  private String body;
  private String to;
  private PhoneNumber from;
  private ZonedDateTime dateCreated;
  private ZonedDateTime dateSent;
  private ZonedDateTime dateUpdated;

  public SmsResponse() {
  }

  public SmsResponse(String accountSid, String body, String to, PhoneNumber from, ZonedDateTime dateCreated,
      ZonedDateTime dateSent, ZonedDateTime dateUpdated) {
    this.accountSid = accountSid;
    this.body = body;
    this.to = to;
    this.from = from;
    this.dateCreated = dateCreated;
    this.dateSent = dateSent;
    this.dateUpdated = dateUpdated;
  }

  public String getAccountSid() {
    return this.accountSid;
  }

  public void setAccountSid(String accountSid) {
    this.accountSid = accountSid;
  }

  public String getBody() {
    return this.body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getTo() {
    return this.to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public PhoneNumber getFrom() {
    return this.from;
  }

  public void setFrom(PhoneNumber from) {
    this.from = from;
  }

  public ZonedDateTime getDateCreated() {
    return this.dateCreated;
  }

  public void setDateCreated(ZonedDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public ZonedDateTime getDateSent() {
    return this.dateSent;
  }

  public void setDateSent(ZonedDateTime dateSent) {
    this.dateSent = dateSent;
  }

  public ZonedDateTime getDateUpdated() {
    return this.dateUpdated;
  }

  public void setDateUpdated(ZonedDateTime dateUpdated) {
    this.dateUpdated = dateUpdated;
  }

}
