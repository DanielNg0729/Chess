package control;

import entity.enums.Faction;
import entity.enums.Result;
import entity.move.Move;
import entity.pieces.King;
import entity.pieces.Piece;
import entity.state.GameState;

import java.util.ArrayList;
import java.util.List;

import entity.board.Cell;
import entity.board.ChessBoard;

public class GameController {
    // attributes
    private GameState gameState;
    private LegalMove legalMove;

    // methods
    public void startGame(BoardSetup board) {
        // setup Board
        ChessBoard b = board.setUp();
        List<Move> move = new ArrayList<>();
        gameState = new GameState(Faction.WHITE, move, Result.ONGOING, b);
        legalMove = new LegalMove(b);
    }

    public boolean validate(Move move) {
        if (move.getPiece().getSide() != gameState.getTurn()) {
            return false;
        }
        return legalMove.isLegal(move);
    }

    public GameState executes(Move move) {
        // update chessBoard
        Cell[][] board = gameState.getChessBoard().getBoard();
        int startX = move.getStartXPos();
        int startY = move.getStartYPos();
        int endX = move.getEndXPos();
        int endY = move.getEndYPos();
        Piece movingPiece = board[startX][startY].getContain();

        board[startX][startY].setContain(null);
        board[endX][endY].setContain(movingPiece);

        // add to move History
        gameState.addMoveHistory(move);

        // change turn
        if (gameState.getTurn() == Faction.WHITE)
            gameState.setTurn(Faction.BLACK);
        else
            gameState.setTurn(Faction.WHITE);
        return gameState;

    }

    public Result checkGameStatus() {
        // if it is check and no moves --> checkmate
        // if it is not check and no moves --> draw
        // else: ongoing

        Cell[][] board = gameState.getChessBoard().getBoard();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // find same side pieces
                if (board[i][j].getContain() == null || board[i][j].getContain().getSide() != gameState.getTurn()) {
                    continue;
                } else {
                    List<Move> moves = board[i][j].getContain().move(board, i, j);
                    for (Move m : moves) {
                        // if legal moves exist --> game not end
                        if (legalMove.isLegal(m))
                            return Result.ONGOING;
                    }
                }

            }
        }

        // if no legal moves exist
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // find other side pieces
                if (board[i][j].getContain() == null || board[i][j].getContain().getSide() == gameState.getTurn()) {
                    continue;
                } else {
                    List<Move> moves = board[i][j].getContain().move(board, i, j);
                    for (Move m : moves) {
                        // find check
                        if (board[m.getEndXPos()][m.getEndYPos()].getContain() instanceof King
                                && board[m.getEndXPos()][m.getEndYPos()].getContain().getSide() == gameState
                                        .getTurn()) {
                            if (gameState.getTurn() == Faction.WHITE) {
                                gameState.setGameStatus(Result.BLACK_WIN);
                                return Result.BLACK_WIN;
                            } else {
                                gameState.setGameStatus(Result.WHITE_WIN);
                                return Result.WHITE_WIN;
                            }
                        }
                    }
                }
            }
        }
        gameState.setGameStatus(Result.DRAW);
        return Result.DRAW;

    }
}
