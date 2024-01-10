# Tic-Tac-Toe Java console game

This is a simple implementation of the classic game Tic-Tac-Toe in Java. The program allows two players to play the game in a turn-based system on a 3x3 grid.
# Features

    Simple console-based user interface.
    Turn-based gameplay for two players.
    Basic win and draw detection.
    Replay functionality after each game.
    Automatic creation of a runnable JAR file after every pull request on the main branch.

# Automated JAR File Creation

After every pull request is merged into the main branch, an automated process is triggered to create a runnable JAR file of the game. This JAR file is then uploaded as an artifact and can be found in the associated GitHub Actions workflow run.
Accessing the JAR File

To download the latest JAR file:

    Go to the repository on GitHub.
    Click on the "Actions" tab.
    Find the latest successful workflow run on the main branch.
    Click on the run to view its details.
    Under "Artifacts," find the JAR file (usually named tictactoe.jar or similar) and download it.

Running the JAR File

Ensure you have Java installed and then run the JAR file using the following command:

bash

java -jar path/to/tictactoe.jar

How to Run from Source

To run this program from the source code, you will need Java installed on your machine. Follow these steps:

    Clone or download this repository to your local machine.
    Navigate to the directory containing the TicTacToe.java file.
    Compile the Java program using:

javac TicTacToe.java

Run the compiled program using:

    java TicTacToe

# How to Play

    The game starts by asking Player 1 and Player 2 to choose their markers (characters).
    Players take turns to enter the row and column numbers where they want to place their marker on the 3x3 grid.
    The grid coordinates start from 0 (top left) to 2 (bottom right) for both rows and columns.
    The game checks for a win or a draw after every move.
    If a player wins, the game announces the winner and ends.
    If the grid is full and no player has won, the game announces a draw.
    After each game, players are asked if they want to play again.

# Classes and Methods

    TicTacToe: Main class to run the game.
        start(): Starts the game loop.
        playGame(): Handles the gameplay for each game session.
        resetGame(): Resets the game for a new session.
    Player: Represents a player in the game.
        getMarker(): Returns the player's marker.
    Board: Represents the game board.
        print(): Prints the current state of the board.
        place(): Places a marker on the board.
        isFull(): Checks if the board is full.
        clear(): Clears the board for a new game.

# Dependencies

    Java Runtime Environment (JRE) or Java Development Kit (JDK) version 11 or higher.

# License

This project is open source and available under the MIT License.
