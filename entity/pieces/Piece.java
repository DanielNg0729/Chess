package entity.pieces;

import java.util.List;

import entity.board.Cell;
import entity.enums.Faction;
import entity.move.Move;

public abstract class Piece {
    // attributes
    private int value;
    private Faction side;

    // constructor
    public Piece(int value, Faction side) {
        this.value = value;
        this.side = side;
    }

    // methods
    public abstract List<Move> move(Cell[][] board, int curX, int curY);

    public Faction getSide() {
        return side;
    }

    public int getValue() {
        return value;
    }
}
