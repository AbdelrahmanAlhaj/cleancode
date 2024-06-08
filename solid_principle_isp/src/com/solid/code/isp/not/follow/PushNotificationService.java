package com.solid.code.isp.not.follow;

public class PushNotificationService implements MessageService {
    @Override
    public void sendEmail() {
        throw new NotSupportedException();
    }

    @Override
    public void sendSMS() {
        throw new NotSupportedException();
    }

    @Override
    public void sendPushNotification() {
        System.out.println("send push notification");
    }
}
