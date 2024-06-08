package com.solid.code.isp.follow;

public class Main {

    public static void main(String[] args) {
        MessageService messageService = new SMSService();
        messageService.send();
    }
}
