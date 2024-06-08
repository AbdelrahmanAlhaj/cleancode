package com.solid.code.dip.follow;

class EmailService implements MessagingService {
    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("Sending Email Message");
    }
}
