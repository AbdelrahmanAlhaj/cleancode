package com.solid.code.dip.follow;

class MessageClient {
    private MessagingService messagingService;

    public MessageClient(MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    public void sendEmailToClient() {
        messagingService.sendMessage("receiptMessage", "message");
    }
}
