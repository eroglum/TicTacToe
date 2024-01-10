import static org.junit.jupiter.api.Assertions.*;

public class Test {

    @org.junit.jupiter.api.Test
    public void testIsCellEmptyPositive() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0, 0), "Die Zelle sollte zu Beginn leer sein");
    }

    @org.junit.jupiter.api.Test
    public void testIsCellEmptyNegative() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0), "Die Zelle sollte nicht leer sein, nachdem ein Marker platziert wurde");
    }

    @org.junit.jupiter.api.Test
    public void testPlacePositive() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertEquals('X', board.getCell(0, 0), "Der Marker X sollte in der Zelle platziert worden sein");
    }

    @org.junit.jupiter.api.Test
    public void testPlaceNegative() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 0, 'O');
        assertEquals('X', board.getCell(0, 0), "Der Marker sollte nicht überschrieben werden, wenn die Zelle bereits besetzt ist");
    }

    @org.junit.jupiter.api.Test
    public void testIsFullPositive() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull(), "Das Brett sollte als voll erkannt werden");
    }

    @org.junit.jupiter.api.Test
    public void testIsFullNegative() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertFalse(board.isFull(), "Das Brett sollte nicht als voll erkannt werden, wenn noch leere Zellen vorhanden sind");
    }

    @org.junit.jupiter.api.Test
    public void testClear() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0), "Alle Zellen sollten leer sein nach dem Aufruf von clear");
    }

    @org.junit.jupiter.api.Test
    public void testSwitchCurrentPlayer() {
        TicTacToe game = new TicTacToe('X', 'O');
        Player currentPlayer = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        assertNotSame(currentPlayer, game.getCurrentPlayer(), "Der aktuelle Spieler sollte nach dem Aufruf von switchCurrentPlayer wechseln");
    }


}
