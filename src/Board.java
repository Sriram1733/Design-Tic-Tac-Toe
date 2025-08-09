import java.util.Arrays;

public class Board {

    private final int size;
    private final char[][] grid;

    public Board(int size) {
        this.size = size;
        grid = new char[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(grid[i], ' ');
        }
    }

    public boolean placeSymbol(int row, int col, char symbol) {
        if (row >= 0 && col >= 0 && row < size && col < size && grid[row][col] == ' ') {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    public void printBoard() {
        for(int i=0;i<size;i++) {
            System.out.println("-----------");
            for(int j=0;j<size;j++) {
                System.out.print(grid[i][j] == ' ' ? "." : grid[i][j]);
                if (j < size - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i == size - 1)  System.out.println("-----------");
        }
    }

    public boolean checkWin(char symbol) {
        int size = getSize();
        char[][] grid = getGrid();

        // check rows and columns
        for (int i = 0; i < size; i++) {
            boolean rowWin = true, colWin = true;
            for (int j = 0; j < size; j++) {
                if (grid[i][j] != symbol) rowWin = false;
                if (grid[j][i] != symbol) colWin = false;
            }
            if (rowWin || colWin) return true;
        }

        // check diagonals
        boolean mainDia = true, oppDia = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][i] != symbol) mainDia = false;
            if (grid[i][size - 1 - i] != symbol) oppDia = false;
        }
        return mainDia || oppDia;
    }

    public boolean isFull() {
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    public char[][] getGrid() {
        return grid;
    }
}
