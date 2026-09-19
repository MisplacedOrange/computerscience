/*
Author: Roy Lu
Date: September 16th, 2026
Description: small program to evaluate smallest prime after an input
*/


import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number > 2: ");
        int number = input.nextInt();

        int candidate = number + 1;

        while (true) {
            boolean prime = true;
            int divisor = 2;

            while (divisor * divisor <= candidate) {
                if (candidate % divisor == 0) {
                    prime = false;
                    break;
                }

                divisor++;
            }

            if (prime) {
                break;
            }

            candidate++;
        }

        System.out.println("The smallest prime number greater than "
                + number + " is " + candidate);
    }
}