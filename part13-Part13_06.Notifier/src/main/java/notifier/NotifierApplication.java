package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application {

    public static void main(String[] args) {
        launch(NotifierApplication.class);
        System.out.println("Hello world!");
    }

    @Override
    public void start(Stage window) throws Exception {
        TextField fieldComponent = new TextField();
        Button button = new Button("Update");
        Label textComponent = new Label();
        
        button.setOnAction((event) -> {
            textComponent.setText(fieldComponent.getText());
        });
        
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren().addAll(fieldComponent, button, textComponent);
        
        Scene viewport = new Scene(vbox);
        window.setScene(viewport);
        window.show();
    }
}
