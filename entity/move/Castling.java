//UNFINISHED  
package entity.move;

import entity.pieces.Piece;

public class Castling /* extends SpecialMove */ {
    private Piece secondPiece;
    private int secondPieceEndXPos;
    private int secondPieceEndyPos;

    public Piece getSecondPiece() {
        return secondPiece;
    }

    public int getSecondPieceEndXPos() {
        return secondPieceEndXPos;
    }

    public int getSecondPieceEndYPos() {
        return secondPieceEndyPos;
    }
}
