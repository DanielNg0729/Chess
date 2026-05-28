import boundary.UI;
import control.BoardSetup;
import control.GameController;
import entity.enums.Result;
import entity.move.Move;

public class App {
    public static void main(String[] args) {
        // 1. Create GameController
        // 2. Start game with BoardSetup
        // 3. Create UI with the controller
        // 4. Game loop:
        // - display board
        // - display turn
        // - ask for move (retry if null)
        // - execute move
        // - check game status
        // - if not ongoing → conclude and break

        GameController gc = new GameController();
        gc.startGame(new BoardSetup());
        UI ui = new UI(gc);

        while (gc.getGameState().getGameStatus() == Result.ONGOING) {
            ui.display(gc.getGameState().getChessBoard());
            ui.displayTurn();
            Move move = ui.askMove();
            while (move == null)
                move = ui.askMove();

            gc.executes(move);
            gc.checkGameStatus();
        }

        ui.display(gc.getGameState().getChessBoard());
        ui.conclude(gc.getGameState().getGameStatus());

    }
}
