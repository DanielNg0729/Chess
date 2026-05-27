package src.main.java.entity.move;

import src.main.java.entity.pieces.Piece;

public class Castling extends SpecialMove {
    // attributes
    private Piece secondPiece;
    private int secondPieceEndXPos;
    private int secondPieceEndYPos;

    // constructor
    public Castling(int startXPos, int startYPos, int endXPos, int endYPos, Piece piece, int secondXPos, int secondYPos,
            Piece secondPiece) {
        super(startXPos, startYPos, endXPos, endYPos, piece);
        secondPieceEndXPos = secondXPos;
        secondPieceEndYPos = secondYPos;
        this.secondPiece = secondPiece;
    }

    // methods
    public Piece getSecondPiece() {
        return secondPiece;
    }

    public int getSecondPieceEndXPos() {
        return secondPieceEndXPos;
    }

    public int getSecondPieceEndYPos() {
        return secondPieceEndYPos;
    }
}
