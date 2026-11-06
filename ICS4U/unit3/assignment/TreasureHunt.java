/*
Authors: Dinesh Sinnathamby, Roy Lu
Date: November 3rd, 2026
Description: The TreasureHunt class file, containing all methods, variables, and logic for the game.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Manages the board, player rewards, mine relocation, and saved scores.
 */
public class TreasureHunt {

    private char[][] board;
    private boolean[][] checked;
    private int treasures;
    private int found;
    private int lives;
    private int powers;
    private int steps;
    private long lastShuffle;
    private Random random;

    /**
     * Creates a game with randomly placed hidden pieces.
     * @param boardSize number of rows and columns
     */
    public TreasureHunt(int boardSize) {
        this.board = new char[boardSize][boardSize];
        this.checked = new boolean[boardSize][boardSize];
        this.treasures = 0;
        this.found = 0;
        this.lives = 0;
        this.powers = 0;
        this.steps = 0;
        this.random = new Random();
        initializeBoard();
        this.lastShuffle = System.currentTimeMillis();
    }

    /**
     * Clears the board and randomly places the pieces for its difficulty.
     */
    private void initializeBoard() {
        // Clear each row and mark all of its tiles as unrevealed.
        for (int rowIndex = 0; rowIndex < this.board.length; rowIndex++) {
            Arrays.fill(this.board[rowIndex], ' ');
            Arrays.fill(this.checked[rowIndex], false);
        }

        int minimum = (this.board.length - 3) / 2;
        int mines = minimum + this.random.nextInt(2);
        this.treasures = minimum + this.random.nextInt(2);
        int specials = minimum + this.random.nextInt(2);

        placePieces('*', mines);
        placePieces('$', this.treasures);
        placePieces('T', specials);
    }

    /**
     * Places pieces in randomly selected empty cells.
     * @param piece symbol to place
     * @param amount number of pieces to place
     */
    private void placePieces(char piece, int amount) {
        int placed = 0;

        // Keep trying random positions until all pieces have been placed.
        while (placed < amount) {
            int row = this.random.nextInt(this.board.length);
            int column = this.random.nextInt(this.board.length);

            // Only place a piece if the chosen tile is empty.
            if (this.board[row][column] == ' ') {
                this.board[row][column] = piece;
                placed++;
            }
        }
    }

    /**
     * Displays the board with unrevealed pieces hidden.
     */
    public void displayBoard() {
        displayBoard(false, false);
    }

    /**
     * Displays the labelled ASCII board with the requested visibility.
     * @param revealAll whether to reveal every tile
     * @param showMines whether to show hidden mines
     */
    private void displayBoard(boolean revealAll, boolean showMines) {
        int size = this.board.length;

        // Print each row of the board with its row number.
        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            System.out.print("  ");
            // Print the top border for each cell in this row.
            for (int columnIndex = 0; columnIndex < size; columnIndex++) {
                System.out.print("+---");
            }
            System.out.println("+");

            System.out.printf("%2d", rowIndex + 1);

            // Choose and print the symbol for each cell in the row.
            for (int columnIndex = 0; columnIndex < size; columnIndex++) {
                char symbol = ' ';

                // Show the tile contents if it has been revealed or the game has ended.
                if (revealAll || this.checked[rowIndex][columnIndex]) {
                    // Mark an empty revealed tile with X; otherwise use its piece symbol.
                    symbol = this.board[rowIndex][columnIndex] == ' '
                            ? 'X' : this.board[rowIndex][columnIndex];
                } else if (showMines && this.board[rowIndex][columnIndex] == '*') {
                    // Show hidden mines while the Minesweeper power is active.
                    symbol = '*';
                }

                System.out.print("| " + symbol + " ");
            }

            System.out.println("|");
        }

        System.out.print("  ");
        // Print the bottom border across the board.
        for (int columnIndex = 0; columnIndex < size; columnIndex++) {
            System.out.print("+---");
        }
        System.out.println("+");

        System.out.print("   ");
        // Print the column numbers below the board.
        for (int columnIndex = 1; columnIndex <= size; columnIndex++) {
            System.out.printf("%-4d", columnIndex);
        }
        System.out.println();
    }

    /**
     * Checks that a tile is in bounds and has not been revealed.
     * @param row selected row number
     * @param column selected column number
     * @return whether the selected tile can be chosen
     */
    private boolean moveIsValid(int row, int column) {
        // Reject row numbers outside the board.
        if (row < 1 || row > this.board.length) {
            return false;
        } else if (column < 1 || column > this.board.length) {
            // Reject column numbers outside the board.
            return false;
        } else {
            // Accept the tile only if it has not been revealed.
            return !this.checked[row - 1][column - 1];
        }
    }

    /**
     * Prompts until the player enters valid coordinates.
     * @param input source of player input
     * @return the selected row and column
     */
    private int[] getMove(Scanner input) {
        // Keep asking until the player enters an available tile.
        while (true) {
            System.out.print("Enter row and column: ");
            String line = input.nextLine().trim();
            String[] parts = line.split("\\s+");

            // Ask again if the input does not contain exactly two coordinates.
            if (parts.length != 2) {
                System.out.println("Enter two numbers separated by a space.");
                continue;
            }

            // Try converting both coordinates to integers.
            try {
                int row = Integer.parseInt(parts[0]);
                int column = Integer.parseInt(parts[1]);

                // Return the coordinates only if the tile is available.
                if (moveIsValid(row, column)) {
                    return new int[]{row, column};
                }

                System.out.println("Invalid or already revealed tile.");
            } catch (NumberFormatException exception) {
                // Ask again if either coordinate is not a valid integer.
                System.out.println("Please enter valid numbers.");
            }
        }
    }

    /**
     * Reveals a valid tile, counts the step, and applies its effect.
     * @param row selected row number
     * @param column selected column number
     * @param input source of player input
     * @return whether the player survives the move
     */
    private boolean revealTile(int row, int column, Scanner input) {
        row--;
        column--;

        this.checked[row][column] = true;
        this.steps++;

        char piece = this.board[row][column];

        // Count the treasure when a treasure tile is revealed.
        if (piece == '$') {
            this.found++;
            System.out.println("Treasure found!");
            System.out.println("Treasures: " + this.found + "/" + this.treasures);
        } else if (piece == '*') {
            // Handle the mine according to the number of extra lives available.
            // Spend an extra life to survive the mine.
            if (this.lives > 0) {
                this.lives--;
                System.out.println("You hit a mine!");
                System.out.println("Extra life used. Lives left: " + this.lives);
            } else {
                // End the game if the player has no extra lives.
                System.out.println("You hit a mine!");
                return false;
            }
        } else if (piece == 'T') {
            // Award a random treat when a special tile is revealed.
            handleTrickOrTreat();
        } else {
            // Tell the player when the selected tile is empty.
            System.out.println("Empty tile.");
        }

        return true;
    }

    /**
     * Randomly awards an extra life or a saved Minesweeper power.
     */
    private void handleTrickOrTreat() {
        // Randomly give the player an extra life.
        if (this.random.nextBoolean()) {
            this.lives++;
            System.out.println("Treat! You earned an extra life.");
        } else {
            // Give a Minesweeper power for the other random outcome.
            this.powers++;
            System.out.println("Treat! You earned a Minesweeper power.");
        }
    }

    /**
     * Offers to use one saved power, accepting only Y or N.
     * @param input source of player input
     * @return whether mines should be shown for this turn
     */
    private boolean useMinesweeperPower(Scanner input) {
        // Skip the prompt if the player has no saved powers.
        if (this.powers == 0) {
            return false;
        }

        System.out.println("You have " + this.powers + " Minesweeper power(s).");
        System.out.print("Use one now? (Y/N): ");

        String answer = input.nextLine().trim().toUpperCase();

        // Keep asking until the player enters Y or N.
        while (!answer.equals("Y") && !answer.equals("N")) {
            System.out.print("Invalid choice. Enter Y or N: ");
            answer = input.nextLine().trim().toUpperCase();
        }

        // Spend one power if the player chooses to reveal the mines.
        if (answer.equals("Y")) {
            this.powers--;
            System.out.println("Mine locations revealed for this turn!");
            return true;
        }

        System.out.println("Power saved for later.");
        return false;
    }

    /**
     * Randomly relocates hidden mines without changing revealed tiles or other pieces.
     */
    private void relocateMines() {
        int mines = 0;

        // Search each row for hidden mines.
        for (int rowIndex = 0; rowIndex < this.board.length; rowIndex++) {
            // Check each tile in the current row.
            for (int columnIndex = 0; columnIndex < this.board.length; columnIndex++) {
                // Remove and count only mines that have not been revealed.
                if (this.board[rowIndex][columnIndex] == '*'
                        && !this.checked[rowIndex][columnIndex]) {
                    this.board[rowIndex][columnIndex] = ' ';
                    mines++;
                }
            }
        }

        ArrayList<int[]> available = new ArrayList<>();

        // Search each row for possible new mine positions.
        for (int rowIndex = 0; rowIndex < this.board.length; rowIndex++) {
            // Check each tile for an available position.
            for (int columnIndex = 0; columnIndex < this.board.length; columnIndex++) {
                // Keep only empty tiles that have not been revealed.
                if (!this.checked[rowIndex][columnIndex]
                        && this.board[rowIndex][columnIndex] == ' ') {
                    available.add(new int[]{rowIndex, columnIndex});
                }
            }
        }

        Collections.shuffle(available, this.random);

        // Place the mines at the shuffled available positions.
        for (int rowIndex = 0; rowIndex < Math.min(mines, available.size()); rowIndex++) {
            int[] position = available.get(rowIndex);
            this.board[position[0]][position[1]] = '*';
        }

        this.lastShuffle = System.currentTimeMillis();
        System.out.println("Hidden mines have been relocated!");
    }

    /**
     * Checks whether all treasures have been found.
     * @return whether all treasures have been found
     */
    private boolean checkWin() {
        return this.found == this.treasures;
    }

    /**
     * Checks whether there are any unrevealed tiles remaining.
     * @return whether no unrevealed tiles remain
     */
    private boolean checkDraw() {
        // Search each row for remaining moves.
        for (int rowIndex = 0; rowIndex < this.board.length; rowIndex++) {
            // Check each tile in the row.
            for (int columnIndex = 0; columnIndex < this.board.length; columnIndex++) {
                // There is still a move available if any tile is unrevealed.
                if (!this.checked[rowIndex][columnIndex]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Displays the final board with every piece revealed.
     */
    private void revealAll() {
        displayBoard(true, false);
    }

    /**
     * Loads each player's best score, ignoring malformed records.
     * @return each player and their best saved score
     */
    private HashMap<String, Integer> loadScores() {
        HashMap<String, Integer> scores = new HashMap<>();

        // Open the score file and close it automatically after reading.
        try (Scanner file = new Scanner(new File("Winners.txt"))) {
            // Read each saved score until the file ends.
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] parts = line.split(",");

                // Process only records containing a name and a score.
                if (parts.length == 2) {
                    // Try converting the stored step count to an integer.
                    try {
                        String name = parts[0].trim();
                        int score = Integer.parseInt(parts[1].trim());

                        // Keep the player's best score when their name is not empty.
                        if (!name.isEmpty()) {
                            scores.merge(name, score, Math::min);
                        }
                    } catch (NumberFormatException exception) {
                        // Skip records whose score is not a valid integer.
                        continue;
                    }
                }
            }
        } catch (FileNotFoundException exception) {
            // Start with no scores if the file does not exist.
            return scores;
        }

        return scores;
    }

    /**
     * Saves a winning step count, keeping each player's best score.
     * @param name winner name
     */
    private void saveScore(String name) {
        HashMap<String, Integer> scores = loadScores();
        scores.merge(name, this.steps, Math::min);

        // Open the score file for writing and close it automatically afterward.
        try (PrintWriter writer = new PrintWriter("Winners.txt")) {
            // Write each player's name and best step count.
            for (String player : scores.keySet()) {
                writer.println(player + "," + scores.get(player));
            }

            System.out.println("Score saved!");
        } catch (FileNotFoundException exception) {
            // Tell the player if the score file cannot be written.
            System.out.println("Unable to save score.");
        }
    }

    /**
     * Displays previous winners from fewest steps to most steps.
     */
    private void displayScores() {
        HashMap<String, Integer> scores = loadScores();

        System.out.println("\n--- Previous Winners ---");

        // Show a message if there are no saved winners.
        if (scores.isEmpty()) {
            System.out.println("No winners recorded yet.");
            return;
        }

        ArrayList<String> names = new ArrayList<>(scores.keySet());

        names.sort(Comparator.comparingInt(scores::get));

        // Print each winner in order of their best step count.
        for (String name : names) {
            System.out.println(name + ": " + scores.get(name)
                    + " steps");
        }
    }

    /**
     * Runs a game, reveals its final board, and saves a winning score.
     * @param input source of player input
     */
    public void startGame(Scanner input) {
        displayScores();

        boolean alive = true;

        // Continue taking turns while the player is alive and moves remain.
        while (alive && !checkWin() && !checkDraw()) {
            // Move hidden mines if at least one minute has passed.
            if (System.currentTimeMillis() - this.lastShuffle
                    >= 60000) {
                relocateMines();
            }

            boolean showMines = false;

            // Remind the player about saved powers before their move.
            if (this.powers > 0) {
                showMines = useMinesweeperPower(input);
            }

            System.out.println("\nTreasures: " + this.found
                    + "/" + this.treasures);
            System.out.println("Extra lives: " + this.lives);
            System.out.println("Steps: " + this.steps);

            displayBoard(false, showMines);

            int[] move = getMove(input);

            // Request a new move if the mines changed while coordinates were being entered.
            while (System.currentTimeMillis() - this.lastShuffle >= 60000) {
                relocateMines();
                System.out.println("The mines moved. Choose again using the updated board.");
                displayBoard(false, showMines);
                move = getMove(input);
            }

            alive = revealTile(move[0], move[1], input);
        }

        System.out.println("\n--- Final Board ---");
        revealAll();

        // Show the winning message and save the player's score.
        if (checkWin()) {
            System.out.println("Congratulations! You won!");
            System.out.println("Final score: " + this.steps + " steps");

            System.out.print("Enter your name: ");
            String name = input.nextLine().trim()
                    .replace(",", "");

            // Use a default name if the player leaves the name blank.
            if (name.isEmpty()) {
                name = "Anonymous";
            }

            saveScore(name);
        } else if (!alive) {
            // Show the loss message if a mine ended the game.
            System.out.println("Game Over! You lost.");
            System.out.println("Steps taken: " + this.steps);
        } else {
            // Show a draw message if there are no moves left.
            System.out.println("Stalemate! No moves remaining.");
            System.out.println("Steps taken: " + this.steps);
        }
    }
}
