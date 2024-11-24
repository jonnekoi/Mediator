module com.example.mediator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mediator to javafx.fxml;
    exports com.example.mediator;
}