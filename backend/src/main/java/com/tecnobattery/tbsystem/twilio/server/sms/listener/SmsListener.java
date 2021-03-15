package com.tecnobattery.tbsystem.twilio.server.sms.listener;

import java.util.List;

import com.tecnobattery.tbsystem.twilio.server.sms.model.SmsRequest;
import com.tecnobattery.tbsystem.twilio.server.sms.model.SmsResponse;

public interface SmsListener {
  void sendSms(SmsRequest smsRequest);

  List<SmsResponse> recordSms();
}
