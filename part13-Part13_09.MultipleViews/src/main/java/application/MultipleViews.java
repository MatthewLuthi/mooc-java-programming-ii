package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        // 1st view--------------------------
        BorderPane layout = new BorderPane();
        Label firstText = new Label("First view!");
        Button btnToSecondView = new Button("To the second view!");
        layout.setTop(firstText);
        layout.setCenter(btnToSecondView);
        
        // 2nd view--------------------------
        VBox vbox = new VBox();
        Button btnToThirdView = new Button("To the third view!");
        Label secondText = new Label("Second view!");
        vbox.getChildren().addAll(btnToThirdView, secondText);
        
        // 3rd view--------------------------
        GridPane gridLayout = new GridPane();
        Label thirdText = new Label("Third view!");
        Button btnToFirstView = new Button("To the first view!");
        gridLayout.add(thirdText, 0, 0);
        gridLayout.add(btnToFirstView, 1, 1);
        
        
        Scene firstView = new Scene(layout);
        Scene secondView = new Scene(vbox);
        Scene thirdView = new Scene(gridLayout);
        
        btnToSecondView.setOnAction((event) -> {
            window.setScene(secondView);
        });
        
        btnToThirdView.setOnAction((event) -> {
            window.setScene(thirdView);
        });
        
        btnToFirstView.setOnAction((event) -> {
            window.setScene(firstView);
        });
        
        window.setScene(firstView);
        window.show();
    }
}
