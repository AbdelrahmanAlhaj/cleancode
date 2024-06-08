package com.solid.code.isp.follow;

public class SMSService implements MessageService {
    @Override
    public void send() {
        System.out.println("Send SMS");
    }
}
