package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
        System.out.println("Hello world!");
    }

    @Override
    public void start(Stage window) throws Exception {
        TextArea textBox = new TextArea();
        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longestWord = new Label("The longest word is:");
        
        BorderPane layout = new BorderPane();
        layout.setCenter(textBox);

        HBox hbox = new HBox();
        hbox.setSpacing(20);
        hbox.getChildren().addAll(letters, words, longestWord);

        layout.setBottom(hbox);

        textBox.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int numberOfWords = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((w1, w2) -> w2.length() - w1.length())
                    .findFirst()
                    .get();
            

            // set vlaues of text elements
            letters.setText("Letters: " + String.valueOf(characters));
            words.setText("Words: " + String.valueOf(numberOfWords));
            longestWord.setText("The longest word is: " + longest);
        });

        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }
}
