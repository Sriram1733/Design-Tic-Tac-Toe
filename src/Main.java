import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Design a Tic Tac Toe");

        Board board = new Board(3);

        // List of Players
        List<Player> players = Arrays.asList(new HumanPlayer("Sriram", 'X'),
                new HumanPlayer("Saran", 'O'));

        Game game = new Game(board, players);
        game.startPlay();
    }
}