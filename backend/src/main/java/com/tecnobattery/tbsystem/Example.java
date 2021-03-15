package com.tecnobattery.tbsystem;

import java.net.URI;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Example {
  public static final String ACCOUNT_SID = "ACd87f64c2c3acfcde3d2dc77eab1e5d8f";
  public static final String AUTH_TOKEN = "11718d1d5c8ab5c3c98ad271cabf6cee";
  public static final String MESSAGING_SERVICE_SID = "MG2f457c174ef0d78c9e0e5eefee953a4e";

  public static void main(String[] args) {
    whatsapp();
    message();
    recordMessages();
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
    Message message = Message
        .creator(new PhoneNumber("+5571992031814"), MESSAGING_SERVICE_SID,
            "Olá aqui é da GILPIZZA, peça já sua PIZZA... Tel.: 71 9 91913523")
        .setStatusCallback(URI.create("https://en3g69i6qieb0tc.m.pipedream.net")).create();
    System.out.println(message.getSid());
  }

  private static void recordMessages() {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    ResourceSet<Message> messages = Message.reader().limit(20).read();

    for (Message record : messages) {
      System.out.println(record.getBody());
    }
  }
}