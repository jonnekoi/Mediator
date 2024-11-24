package com.example.mediator;

public class ChatClient implements Chat {
    private String username;
    private ChatMediator mediator;
    private ChatController controller;

    public ChatClient(String username, ChatMediator mediator, ChatController controller) {
        this.username = username;
        this.mediator = mediator;
        this.controller = controller;
        mediator.registerClient(this);
    }

    @Override
    public void receiveMessage(String message, String sender) {
        controller.displayMessage(sender + ": " + message);
    }

    @Override
    public void sendMessage(String message, String recipient) {
        if (recipient == null || recipient.isEmpty()) {
            mediator.broadcastMessage(message, this);
        } else {
            mediator.sendMessage(message, this, recipient);
        }
    }

    @Override
    public String getUsername() {
        return username;
    }
}