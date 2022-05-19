module com.example.etcboum73120107 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;


    opens org.calma.etcboum73120107 to javafx.fxml;
    opens org.calma.etcboum73120107.controllers to javafx.fxml;
    exports org.calma.etcboum73120107;
    exports org.calma.etcboum73120107.controllers;
}