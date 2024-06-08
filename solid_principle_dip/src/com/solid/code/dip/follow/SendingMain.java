package com.solid.code.dip.follow;

public class SendingMain {
    public static void main(String[] args) {

        MessagingService messagingService = new EmailService();
        MessageClient messageClient = new MessageClient(messagingService);
        messageClient.sendEmailToClient();




    }

}
