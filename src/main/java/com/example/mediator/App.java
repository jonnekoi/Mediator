package com.example.mediator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ChatMediator mediator = new ChatAppMediator();

        int amountOfViews = 3;
        String[] clientNames = new String[amountOfViews];

        for (int i = 0; i < amountOfViews; i++) {
            clientNames[i] = "K" + (i + 1);
        }

        for (int i = 1; i <= amountOfViews; i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("K" + i);
            Scene scene = new Scene(loader.load(), 400, 300);
            stage.setScene(scene);

            ChatController controller = loader.getController();
            ChatClient client = new ChatClient("K" + i, mediator, controller);
            controller.setClient(client);
            controller.setRecipients(clientNames);

            stage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}