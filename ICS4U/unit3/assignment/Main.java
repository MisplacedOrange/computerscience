/*
Authors: Dinesh Sinnathamby, Roy Lu
Date: November 3rd, 2026
Description: The main file to run the Treasure Hunt game, utilising the Treasure Hunt class to handle the gameplay.
*/

import java.util.Scanner;

/**
 * Runs Treasure Quest and handles difficulty selection and replay choices.
 */
public class Main {
    /**
     * Runs games until the player chooses to quit.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean playing = true;

        // Keep starting new games until the player chooses to quit.
        while (playing) {
            int boardSize = chooseDifficulty(input);

            TreasureHunt game = new TreasureHunt(boardSize);
            game.startGame(input);

            System.out.print("\nDo you want to play again? (Y/N): ");
            String answer = input.nextLine().trim().toUpperCase();

            // Ask again until the replay choice is Y or N.
            while (!answer.equals("Y") && !answer.equals("N")) {
                System.out.print("Invalid choice. Enter Y or N: ");
                answer = input.nextLine().trim().toUpperCase();
            }

            // Stop the game loop when the player chooses N.
            if (answer.equals("N")) {
                playing = false;
            }
        }

        System.out.println("Thanks for playing Treasure Quest!");
        input.close();
    }

    /**
     * Prompts until the player selects a valid difficulty.
     * @param input source of player input
     * @return the selected board size
     */
    public static int chooseDifficulty(Scanner input) {
        // Keep asking until a valid difficulty is selected.
        while (true) {
            System.out.println("\nWhat difficulty do you want to play?");
            System.out.println("[1] Easy (5x5)");
            System.out.println("[2] Medium (7x7)");
            System.out.println("[3] Hard (9x9)");
            System.out.print("Enter your choice: ");

            String answer = input.nextLine().trim();

            // Use a 5 by 5 board for easy difficulty.
            if (answer.equals("1")) {
                return 5;
            } else if (answer.equals("2")) {
                // Use a 7 by 7 board for medium difficulty.
                return 7;
            } else if (answer.equals("3")) {
                // Use a 9 by 9 board for hard difficulty.
                return 9;
            } else {
                // Explain the error before asking for another difficulty.
                System.out.println("Invalid difficulty. Please try again.");
            }
        }
    }
}
