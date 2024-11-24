package com.example.mediator;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatController {
    @FXML
    private TextArea messageArea;
    @FXML
    private TextField messageField;
    @FXML
    private ComboBox<String> recipientField;

    private ChatClient client;

    public void setClient(ChatClient client) {
        this.client = client;
    }

    public void setRecipients(String[] recipients) {
        recipientField.getItems().addAll(recipients);
    }

    @FXML
    protected void onSendButtonClick() {
        String message = messageField.getText();
        String recipient = recipientField.getValue();
        client.sendMessage(message, recipient);
        messageArea.appendText("You: " + message + "\n");
        messageField.clear();
        recipientField.setValue(null);
    }

    public void displayMessage(String message) {
        messageArea.appendText(message + "\n");
    }
}