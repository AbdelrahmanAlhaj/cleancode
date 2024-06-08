package com.solid.code.dip.not.follow;

class MessageClient {
    private EmailService emailService;
    private SMSService smsService;

    public MessageClient() {
        this.emailService = new EmailService();
        this.smsService = new SMSService();
    }

    public void sendEmailToClient() {
        String receiptMessage = "receiptMessage";
        emailService.sendMessage(receiptMessage, "Email message");
    }

    public void sendSMSToClient() {
        smsService.sendMessage("", "SMS message");
    }
}
