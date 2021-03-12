package com.tecnobattery.tbsystem.controllers.servermessage;

import com.tecnobattery.tbsystem.server.message.SmsRequest;
import com.tecnobattery.tbsystem.services.servermessage.SmsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/message")
public class SmsController {

  @Autowired
  private SmsService smsService;

  @PostMapping
  public void sendSms(@RequestBody SmsRequest smsRequest) {
    smsService.sendSms(smsRequest);
  }
}
