package entity.pieces;

import java.util.ArrayList;
import java.util.List;

import entity.board.Cell;
import entity.enums.Faction;
import entity.move.Move;

public class Rook extends Piece {
    // constructor
    public Rook(Faction side) {
        super(5, side);
    }

    @Override
    public List<Move> move(Cell[][] board, int curX, int curY) {
        List<Move> moves = new ArrayList<>();

        return moves;

    }

}
