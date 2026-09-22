/*
Author: Roy Lu
Date: September 22nd, 2026
Description: Prompts the user to enter ten unique numbers between 1 and 100,
then displays all ten numbers.
*/

import java.util.Scanner;

public class Q3{
    public static void main(String[] args) {
        /*
        Purpose: Collects ten unique numbers between 1 and 100 and displays them.
        Parameters: Command line arguments are passed in, but are not used.
        Return Value: None.
        */

        Scanner input = new Scanner(System.in);

        int[] numbers = new int[10];
        int count = 0;

        while (count < 10) {
            System.out.print("Enter a number between 1 and 100: ");
            int number = input.nextInt();

            if (number < 1 || number > 100) {
                System.out.println("Invalid number. Try again.");
                continue;
            }

            boolean duplicate = false;

            for (int i = 0; i < count; i++) {
                if (numbers[i] == number) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                System.out.println("That number has already been entered. Try again.");
            } else {
                numbers[count] = number;
                count++;
            }
        }

        System.out.println("\nYour ten unique numbers:");

        for (int number : numbers) {
            System.out.println(number);
        }

        input.close();
    }
}