package src.main.java.control;

import src.main.java.entity.board.Cell;
import src.main.java.entity.board.ChessBoard;
import src.main.java.entity.enums.BoardColor;
import src.main.java.entity.enums.Faction;
import src.main.java.entity.pieces.Bishop;
import src.main.java.entity.pieces.King;
import src.main.java.entity.pieces.Knight;
import src.main.java.entity.pieces.Pawn;
import src.main.java.entity.pieces.Queen;
import src.main.java.entity.pieces.Rook;

public class BoardSetup {
    // methods
    public ChessBoard setUp() {
        ChessBoard chessBoard = new ChessBoard();
        Cell[][] board = chessBoard.getBoard();

        // set color
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                BoardColor c = BoardColor.WHITE;
                if ((i + j) % 2 == 0)
                    c = BoardColor.BLACK;
                board[i][j] = new Cell(i, j, c);
            }
        }

        // place pieces
        board[0][0].setContain(new Rook(Faction.WHITE));
        board[1][0].setContain(new Knight(Faction.WHITE));
        board[2][0].setContain(new Bishop(Faction.WHITE));
        board[3][0].setContain(new Queen(Faction.WHITE));
        board[4][0].setContain(new King(Faction.WHITE));
        board[5][0].setContain(new Bishop(Faction.WHITE));
        board[6][0].setContain(new Knight(Faction.WHITE));
        board[7][0].setContain(new Rook(Faction.WHITE));
        board[0][7].setContain(new Rook(Faction.BLACK));
        board[1][7].setContain(new Knight(Faction.BLACK));
        board[2][7].setContain(new Bishop(Faction.BLACK));
        board[3][7].setContain(new Queen(Faction.BLACK));
        board[4][7].setContain(new King(Faction.BLACK));
        board[5][7].setContain(new Bishop(Faction.BLACK));
        board[6][7].setContain(new Knight(Faction.BLACK));
        board[7][7].setContain(new Rook(Faction.BLACK));
        for (int m = 0; m < 8; m++) {
            board[m][1].setContain(new Pawn(Faction.WHITE));
        }
        for (int n = 0; n < 8; n++) {
            board[n][6].setContain(new Pawn(Faction.BLACK));
        }

        return chessBoard;

    }
}
