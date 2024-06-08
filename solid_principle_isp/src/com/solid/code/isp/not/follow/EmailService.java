package com.solid.code.isp.not.follow;

public class EmailService implements MessageService {

    @Override
    public void sendEmail() {
        System.out.println("send email");
    }

    @Override
    public void sendSMS() {
        throw new NotSupportedException();
    }

    @Override
    public void sendPushNotification() {
        throw new NotSupportedException();
    }
}
