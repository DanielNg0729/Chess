package entity.board;

import entity.enums.BoardColor;
import entity.pieces.Piece;

public class Cell {
    // attributes
    private int xCoor;
    private int yCoor;
    private Piece contain;
    private BoardColor color;

    // method
    public Piece getContain() {
        return contain;
    }

    public int getXCoor() {
        return xCoor;
    }

    public int getYCoor() {
        return yCoor;
    }

    public BoardColor getColor() {
        return color;
    }

}
