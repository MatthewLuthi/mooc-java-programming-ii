package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        // 1. Creating the view for asking their name
        
        // 1.1 Creating the componenets to be used
        Label instructionText = new Label("Enter your name and start.");
        TextField nameField = new TextField();
        Button btnStart = new Button("Start");
        
        // 1.2 Creating the layout and adding components to it
        GridPane namePromptLayout = new GridPane();
        namePromptLayout.add(instructionText, 0, 0);
        namePromptLayout.add(nameField, 0, 1);
        namePromptLayout.add(btnStart, 0, 2);
        
        // 1.3 Styling the layout
        namePromptLayout.setPrefSize(300, 180);
        namePromptLayout.setAlignment(Pos.CENTER);
        namePromptLayout.setVgap(10);
        namePromptLayout.setHgap(10);
        namePromptLayout.setPadding(new Insets(20, 20, 20, 20));
        
        
        
        // 2. Creating the view for showing the welcome message
        Label welcomeText = new Label("Welcome!");
        
        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(welcomeText);
        welcomeLayout.setAlignment(Pos.CENTER);
        
        Scene namePromptView = new Scene(namePromptLayout);
        Scene welcomeView = new Scene(welcomeLayout);
        
        btnStart.setOnAction((event) -> {
            welcomeText.setText("Welcome " + nameField.getText().trim() + "!");
            window.setScene(welcomeView);
        });
        
        window.setScene(namePromptView);
        window.show();
    }
}
