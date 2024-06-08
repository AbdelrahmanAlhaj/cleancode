package com.solid.code.isp.follow;

import com.solid.code.isp.not.follow.NotSupportedException;

public class PushNotificationService implements MessageService {

    @Override
    public void send() {
    System.out.println("Send push notification");
    }
}
