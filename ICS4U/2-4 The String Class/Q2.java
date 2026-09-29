/*
Author: Roy Lu
Date: September 29th, 2026
Description: Short program that returns all words inputted that do not contain digits.
*/

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String userLine = input.nextLine();
        String[] words = userLine.split("\\s+");

        for (String word : words) {
            if (word.chars().anyMatch(Character::isDigit)) {}
            else {
                System.out.println(word);
            }
        }
    }
}
