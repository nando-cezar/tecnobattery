package com.tecnobattery.tbsystem.services.message;

import java.util.List;

import com.tecnobattery.tbsystem.twilio.server.sms.listener.SmsListener;
import com.tecnobattery.tbsystem.twilio.server.sms.model.SmsRequest;
import com.tecnobattery.tbsystem.twilio.server.sms.model.SmsResponse;
import com.tecnobattery.tbsystem.twilio.server.sms.service.TwilioSmsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

  private final SmsListener smsListener;

  @Autowired
  public SmsService(@Qualifier("twilio") TwilioSmsService twilioSmsService) {
    this.smsListener = twilioSmsService;
  }

  public void sendSms(SmsRequest smsRequest) {
    smsListener.sendSms(smsRequest);
  }

  public List<SmsResponse> recordSms() {
    return smsListener.recordSms();
  }
}