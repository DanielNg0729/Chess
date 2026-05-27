package src.main.java.entity.move;

import src.main.java.entity.pieces.Piece;

public class EnPassant extends SpecialMove {
    // attributes
    private Piece capture;

    // constructor
    public EnPassant(int startXPos, int startYPos, int endXPos, int endYPos, Piece piece, Piece capturePiece) {
        super(startXPos, startYPos, endXPos, endYPos, piece);
        capture = capturePiece;
    }

    // methods
    public Piece getCapturePiece() {
        return capture;
    }
}
