package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SmileyApplication extends Application {

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Canvas paintingCanvas = new Canvas(400, 400);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        
        painter.setFill(Color.WHITE);
        painter.clearRect(0, 0, 640, 480);
       
        painter.setFill(Color.BLACK);
        painter.fillRect(100, 50, 50, 50);
        painter.fillRect(250, 50, 50, 50);
        
        painter.fillRect(100, 250, 200, 50);
        painter.fillRect(50, 200, 50, 50);
        painter.fillRect(300, 200, 50, 50);
 
        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);
        Scene view = new Scene(paintingLayout);
        
        window.setScene(view);
        window.show();
    }
}
