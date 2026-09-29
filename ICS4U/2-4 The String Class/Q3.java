/*
Author: Roy Lu
Date: September 29th, 2026
Description: Short program that capitalizes the first letter of all words inputted by the user.
*/

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String userLine = input.nextLine().trim();
        if (userLine.isEmpty()) {
            return;
        }
        String[] words = userLine.split("\\s+");

        for (String word : words) {
            System.out.println(word.substring(0, 1).toUpperCase() + word.substring(1));
        }
    }
}
