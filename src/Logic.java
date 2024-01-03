
public class Logic {

    private final String[][] boardState;
    public Logic(String[][] boardState) {
        this.boardState = boardState;
    }

    // TODO: maybe clean up win state
    public boolean isWinner(String player) {
        return boardState[0][0].equals(player) && boardState[0][1].equals(player) && boardState[0][2].equals(player) ||
                boardState[1][0].equals(player) && boardState[1][1].equals(player) && boardState[1][2].equals(player) ||
                boardState[2][0].equals(player) && boardState[2][1].equals(player) && boardState[2][2].equals(player) ||
                boardState[0][0].equals(player) && boardState[1][0].equals(player) && boardState[2][0].equals(player) ||
                boardState[0][1].equals(player) && boardState[1][1].equals(player) && boardState[2][1].equals(player) ||
                boardState[0][2].equals(player) && boardState[1][2].equals(player) && boardState[2][2].equals(player) ||
                boardState[0][0].equals(player) && boardState[1][1].equals(player) && boardState[2][2].equals(player) ||
                boardState[0][2].equals(player) && boardState[1][1].equals(player) && boardState[2][0].equals(player);
    }

    public String setWinner() {
        String winner = "";
        if (isWinner("X") && isWinner("O")) {
            winner = "XO";
        } else if (isWinner("X")) {
            winner = "X";
        } else if (isWinner("O")) {
            winner = "O";
        }
        return winner;
    }

    public boolean isGameInProgress() {
        boolean isThereEmptyCells = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardState[i][j].equals("_")) {
                    isThereEmptyCells = true;
                    break;
                }
            }
        }
        return isThereEmptyCells && setWinner().isEmpty();
    }

    public boolean isDraw() {
        return !isGameInProgress() && !isWinner("X") && !isWinner("O");
    }


    public String showCurrentState() {
        if (isGameInProgress()) {
            return "Game not finished";
        } else if (isDraw()) {
            return "Draw";
        } else {
            return setWinner() + " wins";
        }
    }
}
