package com.solid.code.isp.not.follow;

public class SMSService implements MessageService {
    @Override
    public void sendEmail() {
        throw new NotSupportedException();
    }

    @Override
    public void sendSMS() {
        System.out.println("send SMS");
    }

    @Override
    public void sendPushNotification() {
        throw new NotSupportedException();
    }
}
