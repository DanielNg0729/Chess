package src.main.java.entity.move;

import src.main.java.entity.pieces.Piece;

public class NormalMove extends Move {
    // attributes
    private Piece capture;

    // constructor
    public NormalMove(int startXPos, int startYPos, int endXPos, int endYPos, Piece piece, Piece capture) {
        super(startXPos, startYPos, endXPos, endYPos, piece);
        this.capture = capture;
    }

    // methods
    public Piece getCapturePiece() {
        return capture;
    }
}
