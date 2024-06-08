package com.solid.code.isp.follow;

public class EmailService implements MessageService {

    @Override
    public void send() {
        System.out.println("Send Email");
    }
}
