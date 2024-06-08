package com.solid.code.dip.not.follow;

public class SendingMain {
    public static void main(String[] args) {
        MessageClient client = new MessageClient();
        client.sendSMSToClient();

    }
}
