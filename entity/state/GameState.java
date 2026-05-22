package entity.state;

import java.util.List;

import entity.board.ChessBoard;
import entity.enums.Faction;
import entity.enums.Result;
import entity.move.Move;

public class GameState {
    // attributes
    private Faction turn;
    private List<Move> moveHistory;
    private Result gameState;
    private ChessBoard chessBoard;

    // methods
    public Faction getTurn() {
        return turn;
    }

    public List<Move> getMoveHistory() {
        return moveHistory;
    }

    public Result getGameState() {
        return gameState;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }
}
