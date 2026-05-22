package entity.move;

import entity.pieces.Piece;

public class NormalMove extends Move {
    // attributes
    private Piece capture;

    // constructor
    public NormalMove(int startXPos, int startYPos, int endXPos, int endYPos, Piece piece, Piece capture) {
        this.capture = capture;
        super(startXPos, startYPos, endXPos, endYPos, piece);
    }

    // methods
    public Piece getCapturePiece() {
        return capture;
    }
}
