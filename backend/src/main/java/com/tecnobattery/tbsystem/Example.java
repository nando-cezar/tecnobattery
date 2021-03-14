package com.tecnobattery.tbsystem;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Example {
  public static final String ACCOUNT_SID = "AC2570551bc1575e088620a99cf52f8b0a";
  public static final String AUTH_TOKEN = "80a880b78766ae4f314c189b474a8a16";
  public static final String MESSAGING_SERVICE_SID = "MGcf5fa2c12ca5bda7505ad895f18d3496";

  public static void main(String[] args) {
    whatsapp();
    message();
  }

  private static void whatsapp() {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(new PhoneNumber("whatsapp:+557192031814"),
        new PhoneNumber("whatsapp:+14155238886"), "Olá aqui é da GILPIZZA, peça já sua PIZZA... Tel.: 71 9 91913523")
        .create();
    System.out.println(message.getSid());
  }

  private static void message() {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(new PhoneNumber("+5571982571820"), MESSAGING_SERVICE_SID,
        "Olá aqui é da GILPIZZA, peça já sua PIZZA... Tel.: 71 9 91913523").create();
    System.out.println(message.getSid());
  }
}