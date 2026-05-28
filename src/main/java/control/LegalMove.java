package control;

import entity.board.Cell;
import entity.board.ChessBoard;
import entity.move.Castling;
import entity.move.Move;
import entity.pieces.King;
import entity.pieces.Piece;

public class LegalMove {
    // attributes
    private ChessBoard chessBoard;

    // constructor
    public LegalMove(ChessBoard c) {
        chessBoard = c;
    }

    // methods
    private boolean kingSafe(Cell[][] board, Piece sameSidePiece) {
        // find king
        int kingX = -1, kingY = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].getContain() instanceof King
                        && board[i][j].getContain().getSide() == sameSidePiece.getSide()) {
                    kingX = i;
                    kingY = j;
                }
            }
        }

        // check if king in check
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece tempPiece = board[i][j].getContain();
                if (tempPiece == null || tempPiece.getSide() == sameSidePiece.getSide()) {
                    continue;
                }
                for (Move m : tempPiece.move(board, i, j)) {
                    if (m.getEndXPos() == kingX && m.getEndYPos() == kingY) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isLegal(Move move) {
        int startX = move.getStartXPos();
        int startY = move.getStartYPos();
        int endX = move.getEndXPos();
        int endY = move.getEndYPos();
        int direction = (endX > startX) ? 1 : -1; // castling short/long
        Cell[][] board = chessBoard.getBoard();
        Piece movingPiece = board[startX][startY].getContain();
        Piece capturedPiece = board[endX][endY].getContain();
        boolean legal = true;

        // castling check
        if (move instanceof Castling) {
            if (!kingSafe(board, movingPiece)) {
                return false;
            }

            // If King pass through check
            board[startX][startY].setContain(null);
            board[startX + direction][startY].setContain(movingPiece);

            if (!(kingSafe(board, movingPiece))) {
                legal = false;
            }

            // undo
            board[startX][startY].setContain(movingPiece);
            board[startX + direction][startY].setContain(null);

            if (!legal) {
                return false;
            }
        }
        // normal move
        // try to move
        board[endX][endY].setContain(movingPiece);
        board[startX][startY].setContain(null);

        // check if King in check
        if (!kingSafe(board, movingPiece)) {
            legal = false;
        }

        // undo move
        board[startX][startY].setContain(movingPiece);
        board[endX][endY].setContain(capturedPiece);

        return legal;
    }
}
