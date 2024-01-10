package Board;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;
    private final Scanner scanner;

    public TicTacToe(char playerOneMarker, char playerTwoMarker) {
        board = new Board();
        player1 = new Player(playerOneMarker);
        player2 = new Player(playerTwoMarker);
        currentPlayer = player1; // Spieler 1 beginnt
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean playAgain;
        do {
            playGame();
            playAgain = askToPlayAgain();
            if (playAgain) {
                resetGame();
            }
        } while (playAgain);
        scanner.close();
    }

    private boolean askToPlayAgain() {
        System.out.println("Möchten Sie ein neues Spiel starten? (ja/nein): ");
        String response = scanner.next().trim().toLowerCase();
        return response.equals("ja");
    }

    private void playGame() {
        boolean gameIsRunning = true;
        while (gameIsRunning) {
            board.print();
            boolean moveMade = makeMove(currentPlayer);
            if (moveMade) {
                if (hasWinner()) {
                    board.print();
                    System.out.println("Spieler " + currentPlayer.getMarker() + " gewinnt!");
                    gameIsRunning = false;
                } else if (board.isFull()) {
                    board.print();
                    System.out.println("Unentschieden!");
                    gameIsRunning = false;
                } else {
                    switchCurrentPlayer();
                }
            }
        }
    }

    private void resetGame() {
        board.clear();
        currentPlayer = player1; // Spieler 1 beginnt das neue Spiel
    }

    private boolean makeMove(Player player) {
        int x, y;
        do {
            System.out.println("Current Player: " + player.getMarker());

            System.out.println("row (0-2): ");
            x = scanner.nextInt();
            System.out.println("column (0-2): ");
            y = scanner.nextInt();
            if (!board.isCellEmpty(x, y)) {
                System.out.println("This square is already taken. Please choose another square.");
            }
        } while (!board.isCellEmpty(x, y));
        board.place(x, y, player.getMarker());

        return true;
    }



    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean hasWinner() {
        // The logic now uses the getCell method from Board to check for winning conditions.
        char mark = currentPlayer.getMarker();
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board.getCell(i, 0) == mark && board.getCell(i, 1) == mark && board.getCell(i, 2) == mark) ||
                    (board.getCell(0, i) == mark && board.getCell(1, i) == mark && board.getCell(2, i) == mark)) {
                return true;
            }
        }
        // Check diagonals
        return (board.getCell(0, 0) == mark && board.getCell(1, 1) == mark && board.getCell(2, 2) == mark) ||
                (board.getCell(0, 2) == mark && board.getCell(1, 1) == mark && board.getCell(2, 0) == mark);
    }
}




class Player {
    private final char marker;

    public Player(char marker) {
        this.marker = marker;
    }

    public char getMarker() {
        return marker;
    }
}

class Board {
    private final char[][] cells = new char[3][3];

    public Board() {
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == '-';
    }

    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
        }
    }

    public boolean isFull() {
        for (char[] row : cells) {
            for (char cell : row) {
                if (cell == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (char[] cell : cells) {
            Arrays.fill(cell, '-');
        }
    }

    // Method to get the value of a cell
    public char getCell(int x, int y) {
        return cells[x][y];
    }

    public void print() {
        System.out.println("__");
        for (char[] row : cells) {
            System.out.print("|");
            for (char cell : row) {
                System.out.print(cell != '-' ? cell : " ");
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("__");
    }


        public static void main(String[] args) {
            TicTacToe game = new TicTacToe('X', 'O');
            game.start();
        }

}

