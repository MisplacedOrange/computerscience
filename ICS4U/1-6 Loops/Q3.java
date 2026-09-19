/*
Author: Roy Lu
Date: September 18th, 2026
Description: Calculates factorials until the user enters zero.
*/

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }

            long result = 1;

            for (int i = 1; i <= number; i++) {
                result *= i;
            }

            System.out.println(result);
        }

    }
}
