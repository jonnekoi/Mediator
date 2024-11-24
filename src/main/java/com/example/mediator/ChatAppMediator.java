package com.example.mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatAppMediator implements ChatMediator {
    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String message, ChatClient sender, String recipient) {
        ChatClient client = clients.get(recipient);
        if (client != null) {
            client.receiveMessage(message, sender.getUsername());
        }
    }

    @Override
    public void broadcastMessage(String message, ChatClient sender) {
        for (ChatClient client : clients.values()) {
            if (!client.getUsername().equals(sender.getUsername())) {
                client.receiveMessage(message, sender.getUsername());
            }
        }
    }
}