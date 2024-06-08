package com.solid.code.dip.not.follow;

public class SMSService implements MessagingService {
    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("Sending SMSService message");
    }
}
