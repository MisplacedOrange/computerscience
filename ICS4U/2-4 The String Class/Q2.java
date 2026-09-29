/*
Author: Roy Lu
Date: September 29th, 2026
Description: Short program that returns all words inputted that do not contain digits.
*/

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String userLine = input.nextLine().trim();
        if (userLine.isEmpty()) {
            return;
        }
        String[] words = userLine.split("\\s+");

        for (String word : words) {
            boolean containsDigit = false;

            for (int i = 0; i < word.length(); i++) {
                if (Character.isDigit(word.charAt(i))) {
                    containsDigit = true;
                    break;
                }
            }

            if (!containsDigit) {
                System.out.println(word);
            }
        }
    }
}
