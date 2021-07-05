package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Matt
 */
public class PracticeView {

    private Dictionary dictionary;
    private String word;
    private Statistics stats;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
        stats = new Statistics(dictionary);
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        // 1.0 Main practice view pane
        Label wordInstruction = new Label("Translate the word '" + this.word + "'");
        TextField translationField = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        
        Button addButton = new Button("Check");
        Label feedback = new Label("");

        layout.add(wordInstruction, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(addButton, 0, 2);
        layout.add(feedback, 0, 3);

        // 2.0 Statistics view pane
        HBox statsBox = new HBox();
        Label guesses = new Label("Guesses: " + stats.getGuesses());
        Label correctGuesses = new Label("Correct guesses: " + stats.getCorrectGuesses());
        Label words = new Label("Words: " + stats.getWordCount());
        statsBox.setPadding(new Insets(10, 10, 10, 10));
        statsBox.setSpacing(10);
        statsBox.getChildren().addAll(guesses, correctGuesses, words);

        layout.add(statsBox, 0, 4);

        addButton.setOnMouseClicked((event) -> {
            String translation = translationField.getText();
            if (dictionary.get(word).equals(translation)) {
                feedback.setText("Correct!");
                stats.incrementCorrectGuesses();
            } else {
                feedback.setText("Incorrect! The translation fo the word '" + word + "' is '" + dictionary.get(word) + "'.");
           }

            stats.incrementGuesses();
            guesses.setText("Guesses: " + stats.getGuesses());
            correctGuesses.setText("Correct guesses: " + stats.getCorrectGuesses());
            words.setText("Words: " + stats.getWordCount());

            this.word = this.dictionary.getRandomWord();
            wordInstruction.setText("Translate the word '" + this.word + "'");
            translationField.clear();
        });

        return layout;
    }
}
