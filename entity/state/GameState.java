package entity.state;

import entity.board.ChessBoard;
import entity.enums.Faction;
import entity.enums.Result;
import entity.move.Move;

public class GameState {
    private Faction turn;
    private Move[] moveHistory;
    private Result gameState;
    private ChessBoard chessBoard;
}
