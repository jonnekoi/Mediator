package com.example.mediator;

public interface Chat {
    void receiveMessage(String message, String sender);
    void sendMessage(String message, String recipient);
    String getUsername();
}