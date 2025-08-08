import java.util.Scanner;

public class HumanPlayer extends Player{
    private final Scanner sc = new Scanner(System.in);

    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public void makeMove(Board board) {
        boolean validMove = false;
        while (!validMove) {
            try {
                System.out.print(name + " (" + symbol + ") - Enter row and col (0-based): ");
                String[] input = sc.nextLine().trim().split(" ");
                int row = Integer.parseInt(input[0]);
                int col = Integer.parseInt(input[1]);
                validMove = board.placeSymbol(row, col, symbol);
                if (!validMove) {
                    System.out.println("Invalid move! Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Try again.");
            }
        }
    }
}
