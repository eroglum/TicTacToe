package Board;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private Scanner scanner;

    public TicTacToe(char playerOneMarker, char playerTwoMarker) {
        board = new Board();
        player1 = new Player(playerOneMarker);
        player2 = new Player(playerTwoMarker);
        currentPlayer = player1; // Spieler 1 beginnt
        scanner = new Scanner(System.in);
    }

    public void start() {
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
        scanner.close();
    }


        private boolean makeMove(Player player) {
            int x, y;
            do {
                System.out.println("Current Player: " + player.getMarker());
                board.print();
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

    public boolean hasWinner() {
        // Implementierung der Siegesbedingungen hier
        return false;
    }
}


class Player {
    private char marker;

    public Player(char marker) {
        this.marker = marker;
    }

    public char getMarker() {
        return marker;
    }
}

class Board {
    private char[][] cells = new char[3][3];

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
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = '-';
            }
        }
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

