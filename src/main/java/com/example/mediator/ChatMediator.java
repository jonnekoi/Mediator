package com.example.mediator;

public interface ChatMediator {
    void registerClient(ChatClient client);
    void sendMessage(String message, ChatClient sender, String recipient);
    void broadcastMessage(String message, ChatClient sender);
}