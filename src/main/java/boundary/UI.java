package boundary;

import java.util.List;
import java.util.Scanner;

import control.GameController;
import entity.board.Cell;
import entity.board.ChessBoard;
import entity.enums.Faction;
import entity.enums.Result;
import entity.move.Castling;
import entity.move.Move;
import entity.pieces.Bishop;
import entity.pieces.King;
import entity.pieces.Knight;
import entity.pieces.Pawn;
import entity.pieces.Piece;
import entity.pieces.Queen;
import entity.pieces.Rook;

public class UI {
    // attributes
    private GameController gameController;
    private Scanner sc = new Scanner(System.in);

    // constructor
    public UI(GameController gc) {
        gameController = gc;
    }

    // methods
    public String pieceToSymbol(Piece piece) {
        if (piece == null)
            return ".";

        if (piece instanceof King) {
            if (piece.getSide() == Faction.WHITE)
                return "\u2654"; // White King
            else
                return "\u265A"; // Black King
        }

        if (piece instanceof Queen) {
            if (piece.getSide() == Faction.WHITE)
                return "\u2655"; // White Queen
            else
                return "\u265B"; // Black Queen
        }

        if (piece instanceof Rook) {
            if (piece.getSide() == Faction.WHITE)
                return "\u2656"; // White Rook
            else
                return "\u265C"; // Black Rook
        }

        if (piece instanceof Bishop) {
            if (piece.getSide() == Faction.WHITE)
                return "\u2657"; // White Bishop
            else
                return "\u265D"; // Black Bishop
        }

        if (piece instanceof Knight) {
            if (piece.getSide() == Faction.WHITE)
                return "\u2658"; // White Knight
            else
                return "\u265E"; // Black Knight
        }

        if (piece instanceof Pawn) {
            if (piece.getSide() == Faction.WHITE)
                return "\u2659"; // White Pawn
            else
                return "\u265F"; // Black Pawn
        }

        return "?";
    }

    public void display(ChessBoard board) {
        Cell[][] b = board.getBoard();
        for (int i = 7; i >= 0; i--) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 8; j++) {
                Piece piece = b[j][i].getContain();
                String symbol = pieceToSymbol(piece);
                System.out.print(symbol + " ");
            }
            System.out.println();
        }

        System.out.println("  a b c d e f g h");
    }

    private boolean matchesPieceLetter(Piece piece, Character c) {
        if (c == null)
            return piece instanceof Pawn;
        if (c == 'N')
            return piece instanceof Knight;
        if (c == 'B')
            return piece instanceof Bishop;
        if (c == 'R')
            return piece instanceof Rook;
        if (c == 'Q')
            return piece instanceof Queen;
        if (c == 'K')
            return piece instanceof King;
        return false;
    }

    public Move askMove() {
        System.out.println("Enter the start position of the piece (Eg: Ra1): ");
        String startPos = sc.next();

        // castling check
        if (startPos.equals("O-O")) {
            Cell[][] board = gameController.getGameState().getChessBoard().getBoard();
            if (gameController.getGameState().getTurn() == Faction.WHITE) {
                return new Castling(4, 0, 6, 0, board[4][0].getContain(), 5, 0, board[7][0].getContain());
            } else {
                return new Castling(4, 7, 6, 7, board[4][7].getContain(), 5, 7, board[7][7].getContain());
            }
        }

        else if (startPos.equals("O-O-O")) {
            Cell[][] board = gameController.getGameState().getChessBoard().getBoard();
            if (gameController.getGameState().getTurn() == Faction.WHITE) {
                return new Castling(4, 0, 2, 0, board[4][0].getContain(), 3, 0, board[0][0].getContain());
            } else {
                return new Castling(4, 7, 2, 7, board[4][7].getContain(), 3, 7, board[0][7].getContain());
            }
        }

        System.out.println("Enter the end position of the piece (Eg: a5 (Rook moves from a1 to a5)): ");
        String endPos = sc.next();

        Cell[][] board = gameController.getGameState().getChessBoard().getBoard();

        int startX, startY, endX, endY;
        List<Move> moveHistory = gameController.getGameState().getMoveHistory();
        Character pieceLetter = null;

        if (startPos.length() == 2) {
            startX = startPos.charAt(0) - 'a';
            startY = startPos.charAt(1) - '1';
        } else if (startPos.length() == 3) {
            pieceLetter = startPos.charAt(0);
            startX = startPos.charAt(1) - 'a';
            startY = startPos.charAt(2) - '1';
        } else {
            invalidMessage();
            return null;
        }

        if (endPos.length() == 2) {
            endX = endPos.charAt(0) - 'a';
            endY = endPos.charAt(1) - '1';
        } else {
            invalidMessage();
            return null;
        }

        // validate out of bound
        if (startX >= 8 || startX < 0 || startY >= 8 || startY < 0 || endX >= 8 || endX < 0 || endY >= 8 || endY < 0) {
            invalidMessage();
            return null;
        }

        Piece piece = board[startX][startY].getContain();

        if (piece == null
                || piece.getSide() != gameController.getGameState().getTurn()
                || !matchesPieceLetter(piece, pieceLetter)) {
            invalidMessage();
            return null;
        }

        List<Move> moves = piece.move(board, startX, startY, moveHistory);
        for (Move move : moves) {
            if (move.getEndXPos() == endX
                    && move.getEndYPos() == endY
                    && gameController.getLegalMove().isLegal(move)) {
                return move;
            }
        }

        invalidMessage();
        return null;
    }

    public void displayTurn() {
        Faction turn = gameController.getGameState().getTurn();
        if (turn == Faction.WHITE)
            System.out.println("This is white turn.");
        else
            System.out.println("This is black turn.");
    }

    private void invalidMessage() {
        System.out.println("Your move is invalid!");

    }

    public void conclude(Result r) {
        if (r == Result.BLACK_WIN) {
            System.out.println("Game ends! Black Victory");
        } else if (r == Result.WHITE_WIN) {
            System.out.println("Game ends! White Victory");
        } else if (r == Result.DRAW) {
            System.out.println("Game ends! Draw");
        }

    }
}
