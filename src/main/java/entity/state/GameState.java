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
    private Result gameStatus;
    private ChessBoard chessBoard;

    // constructor
    public GameState(Faction t, List<Move> m, Result g, ChessBoard c) {
        turn = t;
        moveHistory = m;
        gameStatus = g;
        chessBoard = c;
    }

    // methods
    public Faction getTurn() {
        return turn;
    }

    public List<Move> getMoveHistory() {
        return moveHistory;
    }

    public Result getGameStatus() {
        return gameStatus;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard c) {
        chessBoard = c;
    }

    public void setTurn(Faction t) {
        turn = t;
    }

    public void setGameStatus(Result r) {
        gameStatus = r;
    }

    public void addMoveHistory(Move m) {
        moveHistory.add(m);
    }
}
