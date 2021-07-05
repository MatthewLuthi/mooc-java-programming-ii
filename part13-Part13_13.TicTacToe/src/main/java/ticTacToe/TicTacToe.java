package ticTacToe;

/**
 * Game logic that is separate from the UI view and implementation.
 * @author Matt
 */
public class TicTacToe {
    
    private final String[][] gameBoard;
    private final String xPlayer, oPlayer;
    private boolean xPlayerTurn;
    
    public TicTacToe() {
        gameBoard = new String[3][3];
        xPlayer = "X";
        oPlayer = "O";
        xPlayerTurn = true;
    }
    
    public String getPlayerTurn() {
        return xPlayerTurn ? "X" : "O";
    }

    /**
     * Flip the turns so that it is the next player's turn.
     */
    public void turnChangeover() {
        xPlayerTurn = !xPlayerTurn;
    }

    public String updateGameMessage() {
        String turn = xPlayerTurn ? xPlayer : oPlayer;
        return "Turn: " + turn;
    }
    
    /**
     * Populate the gameBoard with the correct position that a player has picked.
     * Depending on who's turn it is will determine what value gets placed at the parameterized position.
     * @param y the row position (along y axis).
     * @param x the column position (along x axis).
     */
    public void place(int y, int x) {
        if (xPlayerTurn) {
            gameBoard[y][x] = "X";
        } else {
            gameBoard[y][x] = "O";
        }
    }

    /**
     * This method checks whether or not a player has played a winning move along the horizontal axis.
     * @return true if a player has reached three corresponding moves in a horizontal row.
     */
    private boolean threeInARow() {
        for (int y = 0; y < 3; y++) {
            int xPoints = 0, yPoints = 0;

            for (int x = 0; x < 3; x++) {
                if (gameBoard[x][y] != null) {
                    if (gameBoard[x][y].equals("X")) {
                        xPoints++;
                    } else {
                        yPoints++;
                    }
                }
            }

            if (xPoints == 3 || yPoints == 3) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks whether or not a player has reached three consecutive moves in vertical column.
     * @return true if a player has won the game by placing three moves in any of the vertical columns.
     */
    private boolean threeInAColumn() {
        for (int y = 0; y < 3; y++) {
            int xPoints = 0, yPoints = 0;
            for (int x = 0; x < 3; x++) {
                if (gameBoard[y][x] != null) {
                    if (gameBoard[y][x].equals("X")) {
                        xPoints++;
                    } else {
                        yPoints++;
                    }
                }
            }

            if (xPoints == 3 || yPoints == 3) {
                return true;
            }
        }

        return false;
    }
    
    /**
     * Checks if the game has been won by a player who has placed three moves in a diagonal orientation.
     * One possible combination is from the (top left to the bottom right) and from the (top right to the bottom left).
     * @return true if a player has reached a diagonal combination.
     */
    private boolean threeInADiagonal() {
        int xPoints = 0, yPoints = 0;
        for (int y = 0; y < 3; y++) {
            if (gameBoard[y][y] != null) {
                if (gameBoard[y][y].equals("X")) {
                    xPoints++;
                } else {
                    yPoints++;
                }
            }
        }

        if (xPoints == 3 || yPoints == 3) {
            return true;
        }

        xPoints = 0;
        yPoints = 0;
        for (int y = 0; y < 3; y++) {
            if (gameBoard[3 - y - 1][y] != null) {
                if (gameBoard[3 - y - 1][y].equals("X")) {
                    xPoints++;
                } else {
                    yPoints++;
                }
            }
        }

        if (xPoints == 3 || yPoints == 3) {
            return true;
        }

        return false;
    }

    public boolean winnerExists() {
        return threeInARow() || threeInAColumn() || threeInADiagonal();
    }
}
