package entity.move;

import entity.pieces.Piece;

public class Promotion extends SpecialMove {
    // attributes
    private Piece promoteTo;

    // constructor
    public Promotion(int startXPos, int startYPos, int endXPos, int endYPos, Piece piece, Piece promoted) {
        super(startXPos, startYPos, endXPos, endYPos, piece);
        promoteTo = promoted;
    }

    // methods
    public Piece getPiecePromoted() {
        return promoteTo;
    }
}
