package src.main.java.entity.pieces;

import java.util.ArrayList;
import java.util.List;

import src.main.java.entity.board.Cell;
import src.main.java.entity.enums.Faction;
import src.main.java.entity.move.Move;
import src.main.java.entity.move.NormalMove;

public class Queen extends Piece {
    // constructor
    public Queen(Faction side) {
        super(9, side);
    }

    @Override
    public List<Move> move(Cell[][] board, int curX, int curY) {
        List<Move> moves = new ArrayList<>();
        int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        for (int[] dir : direction) {
            int tempX = curX + dir[0];
            int tempY = curY + dir[1];

            while (tempX < 8 && tempX >= 0 && tempY < 8 && tempY >= 0) {
                // if no pieces
                if (board[tempX][tempY].getContain() == null) {
                    moves.add(new NormalMove(curX, curY, tempX, tempY, this, null));
                }

                // if have pieces
                else {
                    if (board[tempX][tempY].getContain().getSide() != this.getSide()) {
                        moves.add(new NormalMove(curX, curY, tempX, tempY, this, board[tempX][tempY].getContain()));
                    }
                    break;
                }
                tempX = tempX + dir[0];
                tempY = tempY + dir[1];
            }
        }
        return moves;
    }
}
