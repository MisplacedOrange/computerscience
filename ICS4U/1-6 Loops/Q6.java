/*
Author: Roy Lu
Date: September 18th, 2026
Description: Multiplies the odd numbers up to each input until zero is entered.
*/

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }

            long product = 1;

            for (int i = 1; i <= number; i += 2) {
                product *= i;
            }

            System.out.println(product);
        }

    }
}
