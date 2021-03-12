package com.tecnobattery.tbsystem.services.servermessage;

import com.tecnobattery.tbsystem.server.message.ISmsSender;
import com.tecnobattery.tbsystem.server.message.SmsRequest;
import com.tecnobattery.tbsystem.server.message.TwilioSmsSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

  private final ISmsSender smsSender;

  @Autowired
  public SmsService(@Qualifier("twilio") TwilioSmsSender smsSender) {
    this.smsSender = smsSender;
  }

  public void sendSms(SmsRequest smsRequest) {
    smsSender.sendSms(smsRequest);
  }

}
