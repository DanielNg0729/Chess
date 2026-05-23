package entity.pieces;

import java.util.ArrayList;
import java.util.List;

import entity.board.Cell;
import entity.enums.Faction;
import entity.move.Move;

public class Pawn extends Piece {
    // constructor
    public Pawn(Faction side) {
        super(1, side);
    }

    // methods
    @Override
    public List<Move> move(Cell[][] board, int curX, int curY) {
        List<Move> moves = new ArrayList<>();
        return moves;
    }
}
