package com.tecnobattery.tbsystem.controllers.management.message;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.services.message.SmsService;
import com.tecnobattery.tbsystem.twilio.server.sms.model.SmsRequest;
import com.tecnobattery.tbsystem.twilio.server.sms.model.SmsResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/management/api/v1/messages")
public class SmsController {

  private final SmsService smsService;

  @Autowired
  public SmsController(SmsService smsService) {
    this.smsService = smsService;
  }

  @PostMapping
  @PreAuthorize("hasAuthority('global:write')")
  public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
    smsService.sendSms(smsRequest);
  }

  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public List<SmsResponse> recordSms() {
    return smsService.recordSms();
  }
}
