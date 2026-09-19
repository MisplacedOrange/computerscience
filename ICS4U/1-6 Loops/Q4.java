/*
Author: Roy Lu
Date: September 18th, 2026
Description: Counts the divisors of each number until the user enters zero.
*/

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }

            int divisors = 0;

            for (int divisor = 1; divisor <= number; divisor++) {
                if (number % divisor == 0) {
                    divisors++;
                }
            }

            System.out.println(divisors);
        }

    }
}
