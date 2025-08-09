import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private final Board board;
    private final Queue<Player> players;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = new LinkedList<>(players);
    }

    public void startPlay() {
        System.out.println("Game has started!!");

        while (true) {
            Player player = players.poll();
            board.printBoard();

            player.makeMove(board);

            if (board.checkWin(player.getSymbol())) {
                board.printBoard();
                System.out.println(player.getName() + " has won the game!!");
                break;
            }

            if (board.isFull()) {
                board.printBoard();
                System.out.println("The match is a draw!");
                break;
            }

            players.offer(player);
        }
    }
}
