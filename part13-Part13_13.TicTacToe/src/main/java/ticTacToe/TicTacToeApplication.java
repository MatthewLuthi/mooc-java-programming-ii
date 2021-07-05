package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * TicTacToeApplication that handles the GUI start up and handles events that are triggered by player moves.
 * @author Matt
 */
public class TicTacToeApplication extends Application {

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        TicTacToe game = new TicTacToe();
        
        BorderPane layout = new BorderPane();

        Label gameMessage = new Label("Turn: X");
        Font monospaceFont = Font.font("monospace", 40);
        gameMessage.setFont(monospaceFont);

        layout.setTop(gameMessage);

        GridPane btnLayout = new GridPane();
        btnLayout.setHgap(10);
        btnLayout.setVgap(10);
        btnLayout.setPadding(new Insets(10, 10, 10, 10));

        for (int y = 0; y < 3; y++) {
            int immutableY = y;
            for (int x = 0; x < 3; x++) {
                int immutableX = x;
                Button btn = new Button(" ");
                btn.setFont(monospaceFont);

                btn.setOnAction((event) -> {
                    if (btn.getText().trim().isEmpty()) {
                        btn.setText(game.getPlayerTurn());
                        game.turnChangeover();
                        gameMessage.setText(game.updateGameMessage());
                        game.place(immutableY, immutableX);

                        if (game.winnerExists()) {
                            gameMessage.setText("The end!");
                            btnLayout.setDisable(true);
                        }
                    }
                });

                btnLayout.add(btn, y, x);
            }
        }

        layout.setCenter(btnLayout);

        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }
}
