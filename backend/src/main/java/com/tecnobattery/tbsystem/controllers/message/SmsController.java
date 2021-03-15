package com.tecnobattery.tbsystem.controllers.message;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.services.message.SmsService;
import com.tecnobattery.tbsystem.twilio.server.sms.model.SmsRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class SmsController {

  private final SmsService smsService;

  @Autowired
  public SmsController(SmsService smsService) {
    this.smsService = smsService;
  }

  @PostMapping
  public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
    smsService.sendSms(smsRequest);
  }
}
