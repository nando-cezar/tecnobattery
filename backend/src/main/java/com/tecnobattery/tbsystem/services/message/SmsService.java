package com.tecnobattery.tbsystem.services.message;

import com.tecnobattery.tbsystem.twilio.server.sms.listener.SmsSender;
import com.tecnobattery.tbsystem.twilio.server.sms.model.SmsRequest;
import com.tecnobattery.tbsystem.twilio.server.sms.service.TwilioSmsSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

  private final SmsSender smsSender;

  @Autowired
  public SmsService(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
    this.smsSender = twilioSmsSender;
  }

  public void sendSms(SmsRequest smsRequest) {
    smsSender.sendSms(smsRequest);
  }
}