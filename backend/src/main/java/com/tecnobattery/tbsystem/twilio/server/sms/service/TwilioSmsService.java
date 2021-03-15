package com.tecnobattery.tbsystem.twilio.server.sms.service;

import java.util.ArrayList;
import java.util.List;

import com.tecnobattery.tbsystem.tools.ToolModelMapper;
import com.tecnobattery.tbsystem.twilio.model.TwilioConfiguration;
import com.tecnobattery.tbsystem.twilio.server.sms.listener.SmsListener;
import com.tecnobattery.tbsystem.twilio.server.sms.model.SmsRequest;
import com.tecnobattery.tbsystem.twilio.server.sms.model.SmsResponse;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsService implements SmsListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsService.class);

  @Autowired
  ToolModelMapper toolModelMapper;

  private final TwilioConfiguration twilioConfiguration;

  @Autowired
  public TwilioSmsService(TwilioConfiguration twilioConfiguration) {
    this.twilioConfiguration = twilioConfiguration;
  }

  @Override
  public void sendSms(SmsRequest smsRequest) {

    if (isPhoneNumberValid(smsRequest.getToPhoneNumber())) {
      PhoneNumber to = new PhoneNumber(smsRequest.getToPhoneNumber());
      PhoneNumber from = new PhoneNumber(twilioConfiguration.getPhoneNumber());
      String message = smsRequest.getBodyMessage();
      MessageCreator creator = Message.creator(to, from, message);
      creator.create();
      LOGGER.info("Send sms {}" + smsRequest);
    } else {
      throw new IllegalArgumentException("Phone number [" + smsRequest.getToPhoneNumber() + "] is not a valid number!");
    }
  }

  @Override
  public List<SmsResponse> recordSms() {
    ResourceSet<Message> messages = Message.reader().limit(20).read();
    List<SmsResponse> records = new ArrayList<>();
    for (Message record : messages) {
      records.add(toolModelMapper.toModel(record, SmsResponse.class));
    }
    return records;
  }

  private boolean isPhoneNumberValid(String phoneNumber) {
    // rotine validate
    return true;
  }
}
