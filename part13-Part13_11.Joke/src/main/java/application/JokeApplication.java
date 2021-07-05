package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        
        // 1. Create main layout
        BorderPane layout = new BorderPane();
        
        // 1.1 Create menu for main layout
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        
        // 1.2 Create buttons for menu
        Button btnJoke = new Button("Joke");
        Button btnAnswer = new Button("Answer");
        Button btnExplanation = new Button("Explanation");
        
        menu.getChildren().addAll(btnJoke, btnAnswer, btnExplanation);
        
        layout.setTop(menu);
        
        // 2. Add subview to add them to the menu buttons
        // 2.1 Create subview layout
        StackPane jokeLayout = createView("What do you call a bear with no teeth?");
        StackPane punchlineLayout = createView("A gummy bear.");
        StackPane explanationLayout = createView("A person with no teeth only has gums which is the joke.");
        
        btnJoke.setOnAction((event) -> layout.setCenter(jokeLayout));
        btnAnswer.setOnAction((event) -> layout.setCenter(punchlineLayout));
        btnExplanation.setOnAction((event) -> layout.setCenter(explanationLayout));
        
        // Set initial view
        layout.setCenter(jokeLayout);
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }
    
    private StackPane createView(String text) {
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);
        
        return layout;
    }
}
