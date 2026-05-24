package control;

import entity.enums.Result;
import entity.move.Move;
import entity.state.GameState;

public class GameController {
    // attributes
    private GameState gameState;
    private LegalMove legalMove;

    // methods
    public void startGame(BoardSetup board) {

    }

    public boolean validate(Move move) {
        return false;

    }

    public GameState executes(Move move) {
        return gameState;

    }

    public Result checkGameStatus() {
        return null;

    }
}
