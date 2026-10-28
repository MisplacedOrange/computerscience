/*
Author: Roy Lu
Date: October 28th, 2026
Description: Lets the user search a generated integer array with recursive linear search.
*/

import java.util.Scanner;

public class LinearSearchTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinearArray searchArray = new LinearArray(10);
        System.out.println(searchArray);

        System.out.print("Please enter an integer value (-1 to quit): ");
        int searchInt = input.nextInt();

        while (searchInt != -1) {
            int position = searchArray.recursiveLinearSearch(searchInt, 0);

            if (position == -1) {
                System.out.println("The integer " + searchInt + " was not found.\n");
            } else {
                System.out.println("The integer " + searchInt + " was found in position " + position + ".\n");
            }

            System.out.print("Please enter an integer value (-1 to quit): ");
            searchInt = input.nextInt();
        }

        input.close();
    }
}
