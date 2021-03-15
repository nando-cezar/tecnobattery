package com.tecnobattery.tbsystem.twilio.server.sms.listener;

import com.tecnobattery.tbsystem.twilio.server.sms.model.SmsRequest;

public interface SmsSender {
  void sendSms(SmsRequest smsRequest);
}
