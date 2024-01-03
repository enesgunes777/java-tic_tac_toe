
public class Logic {

    private final String[][] boardState;
    private static final int SIZE = 3;
    public Logic(String[][] boardState) {
        this.boardState = boardState;
    }

    public boolean isWinner(String player) {
        // Check all rows and columns
        for (int i = 0; i < SIZE; i++) {
            if (isWinningLine(player, i, 0, 0, 1) || isWinningLine(player, 0, i, 1, 0)) {
                return true;
            }
        }

        // Check both diagonals
        return isWinningLine(player, 0, 0, 1, 1) || isWinningLine(player, 0, SIZE - 1, 1, -1);
    }

    private boolean isWinningLine(String player, int startRow, int startCol, int rowStep, int colStep) {
        for (int i = 0; i < SIZE; i++) {
            if (!boardState[startRow + i * rowStep][startCol + i * colStep].equals(player)) {
                return false;
            }
        }
        return true;
    }

    public String getWinner() {
        if (isWinner("X")) {
            return "X";
        } else if (isWinner("O")) {
            return "O";
        }
        return ""; // Return empty string if there is no winner yet
    }

    public boolean isGameInProgress() {
        boolean isThereEmptyCells = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (boardState[i][j].isEmpty()) {
                    isThereEmptyCells = true;
                    break;
                }
            }
        }
        return isThereEmptyCells && getWinner().isEmpty();
    }

    public boolean isDraw() {
        return !isGameInProgress() && !isWinner("X") && !isWinner("O");
    }


    public String getCurrentBoardState() {
        if (isGameInProgress()) {
            return "Game not finished";
        } else if (isDraw()) {
            return "Draw";
        } else {
            return getWinner() + " wins";
        }
    }
}
