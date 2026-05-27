package entity.move;

import entity.pieces.Piece;

public abstract class SpecialMove extends Move {
    // constructor
    public SpecialMove(int startXPos, int startYPos, int endXPos, int endYPos, Piece piece) {
        super(startXPos, startYPos, endXPos, endYPos, piece);
    }

}
