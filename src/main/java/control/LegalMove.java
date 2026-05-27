package src.main.java.control;

import src.main.java.entity.board.Cell;
import src.main.java.entity.board.ChessBoard;
import src.main.java.entity.move.Move;
import src.main.java.entity.pieces.King;
import src.main.java.entity.pieces.Piece;

public class LegalMove {
    // attributes
    private ChessBoard chessBoard;

    // constructor
    public LegalMove(ChessBoard c) {
        chessBoard = c;
    }

    // methods
    public boolean isLegal(Move move) {
        int startX = move.getStartXPos();
        int startY = move.getStartYPos();
        int endX = move.getEndXPos();
        int endY = move.getEndYPos();
        Cell[][] board = chessBoard.getBoard();
        Piece movingPiece = board[startX][startY].getContain();
        Piece capturedPiece = board[endX][endY].getContain();
        boolean legal = true;

        // try to move
        board[endX][endY].setContain(movingPiece);
        board[startX][startY].setContain(null);

        // check if King in check, find all enemy pieces and see if they can capture the
        // King
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece tempPiece = board[i][j].getContain();
                if (tempPiece == null || tempPiece.getSide() == movingPiece.getSide()) {
                    continue;
                } else {
                    for (Move m : tempPiece.move(board, i, j)) {
                        if (board[m.getEndXPos()][m.getEndYPos()].getContain() instanceof King) {
                            legal = false;
                            break;
                        }
                    }
                }
            }
            if (!legal)
                break;
        }

        // undo move
        board[startX][startY].setContain(movingPiece);
        board[endX][endY].setContain(capturedPiece);

        return legal;
    }
}
