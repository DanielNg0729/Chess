package entity.board;

public class ChessBoard {
    // attributes
    private Cell[][] chessBoard = new Cell[8][8];

    // methods
    public Cell[][] getBoard() {
        return chessBoard;
    }
}
