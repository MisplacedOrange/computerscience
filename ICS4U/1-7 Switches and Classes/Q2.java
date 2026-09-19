/*
Author: Roy Lu
Date: September 18th, 2026
Description: Demonstrates for, while, and do-while loops with patterns.
*/

public class Q2 {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println("*".repeat(i));
        }

        System.out.println();

        int i = 10;
        while (i > 0) {
            System.out.println("*".repeat(i));
            i--;
        }

        System.out.println();

        int f = 0;
        for (int j = 10; j > 0; j--) {
            System.out.println(" ".repeat(f) + "*".repeat(j));
            f++;
        }

        int a = 10, b = 0;
        do {
            System.out.println(" ".repeat(a) + "*".repeat(b));
            a--;
            b++;
        } while (a > 0);
    }
}
