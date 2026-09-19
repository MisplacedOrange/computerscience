/*
Author: Roy Lu
Date: September 18th, 2026
Description: Reverses each input number without using a String.
*/

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }

            int reversed = 0;

            while (number > 0) {
                reversed = reversed * 10 + number % 10;
                number /= 10;
            }

            System.out.println(reversed);
        }

    }
}
