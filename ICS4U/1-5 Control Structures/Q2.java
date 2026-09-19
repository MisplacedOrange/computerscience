/*
Author: Roy Lu
Date: September 16th, 2026
Description: shortcircuit boolean eval with and and or operator
*/

public class Q2 {
    public static void main(String[] args) {
        
        // short circuit boolean evaluation happens when the program determines the final result of a Boolean expression without evaluating the rest of it.
        int x = 67;

            if (x < 0 && x / 0 > 2) {
                System.out.println("Hello");
            } 
            
        int y = 5;

        if (y > 0 || y / 0 > 2) {
            System.out.println("Hello");
        }
    }
}
