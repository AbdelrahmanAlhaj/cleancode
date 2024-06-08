package com.solid.code.dip.follow;

class SMSService implements MessagingService {
    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("Sending SMS message");
    }
}
