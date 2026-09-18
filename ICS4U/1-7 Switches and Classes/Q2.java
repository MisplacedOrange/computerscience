/*
Author: Roy Lu
Date: September 18th, 2026
Description: Demonstrates for, while, and do-while loops with patterns.
*/

public class Q2 {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            printRow(0, i);
        }

        System.out.println();

        int i = 10;
        while (i > 0) {
            printRow(0, i);
            i--;
        }

        System.out.println();

        int spaces = 0;
        for (int stars = 10; stars > 0; stars--) {
            printRow(spaces, stars);
            spaces++;
        }

        spaces = 10;
        int stars = 0;
        do {
            printRow(spaces, stars);
            spaces--;
            stars++;
        } while (spaces > 0);
    }

    private static void printRow(int spaces, int stars) {
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < stars; i++) {
            System.out.print("*");
        }

        System.out.println();
    }
}
