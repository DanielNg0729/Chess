package entity.pieces;

import entity.enums.Faction;
import entity.move.Move;

public abstract class Piece {
    // attributes
    private int value;
    private Faction side;

    // methods
    abstract Move[] move();
}
