package src.main.java.entity.pieces;

import java.util.ArrayList;
import java.util.List;

import src.main.java.entity.board.Cell;
import src.main.java.entity.enums.Faction;
import src.main.java.entity.move.Move;
import src.main.java.entity.move.NormalMove;

public class Knight extends Piece {
    // constructor
    public Knight(Faction side) {
        super(3, side);
    }

    // methods
    @Override
    public List<Move> move(Cell[][] board, int curX, int curY) {
        List<Move> moves = new ArrayList<>();
        int[][] direction = { { 2, 1 }, { 2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { -2, 1 }, { -2, -1 } };
        for (int[] dir : direction) {
            // not legal
            if (curX + dir[0] >= 8 || curX + dir[0] < 0 || curY + dir[1] >= 8 || curY + dir[1] < 0) {
                continue;
            }

            // check if have another piece same color
            else if ((board[curX + dir[0]][curY + dir[1]].getContain() == null)) {
                moves.add(new NormalMove(curX, curY, curX + dir[0], curY + dir[1], this, null));
            }

            else if (board[curX + dir[0]][curY + dir[1]].getContain().getSide() == this.getSide()) {
                continue;
            }

            else if (board[curX + dir[0]][curY + dir[1]].getContain().getSide() != this.getSide()) {
                moves.add(
                        new NormalMove(curX, curY, curX + dir[0], curY + dir[1], this,
                                board[curX + dir[0]][curY + dir[1]].getContain()));
            }
        }
        return moves;
    }
}