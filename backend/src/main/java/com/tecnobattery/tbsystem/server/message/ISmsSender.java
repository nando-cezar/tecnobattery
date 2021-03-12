package com.tecnobattery.tbsystem.server.message;

public interface ISmsSender {
  void sendSms(SmsRequest smsRequest);
}
