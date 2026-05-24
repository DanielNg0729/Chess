package entity.board;

import entity.enums.BoardColor;
import entity.pieces.Piece;

public class Cell {
    // attributes
    private int xCoor;
    private int yCoor;
    private Piece contain;
    private BoardColor color;

    // constructor
    public Cell(int x, int y, Piece p, BoardColor c) {
        xCoor = x;
        yCoor = y;
        contain = p;
        color = c;
    }

    public Cell(int x, int y, BoardColor c) {
        this(x, y, null, c);
    }

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

    public void setContain(Piece piece) {
        contain = piece;
    }

    public void setColor(BoardColor c) {
        color = c;
    }

}