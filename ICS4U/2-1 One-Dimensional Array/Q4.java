/*
Author: Roy Lu
Date: September 22nd, 2026
Description: Finds the maximum number of divisors for integers from 1 to 10000
and displays all integers with that number of divisors.
*/

public class Q4 {
    public static void main(String[] args) {
        /*
        Purpose: Finds the largest divisor count among numbers from 1 to 10000
        and displays all numbers with that divisor count.
        Parameters: Command line arguments are passed in, but are not used.
        Return Value: None.
        */

        int[] divisorCounts = new int[10001];
        int maximumDivisors = 0;

        for (int number = 1; number <= 10000; number++) {
            int divisorCount = 0;

            for (int divisor = 1; divisor <= number; divisor++) {
                if (number % divisor == 0) {
                    divisorCount++;
                }
            }

            divisorCounts[number] = divisorCount;

            if (divisorCount > maximumDivisors) {
                maximumDivisors = divisorCount;
            }
        }

        System.out.println("Maximum number of divisors: " + maximumDivisors);
        System.out.println("Numbers with " + maximumDivisors + " divisors:");

        for (int number = 1; number <= 10000; number++) {
            if (divisorCounts[number] == maximumDivisors) {
                System.out.println(number);
            }
        }
    }
}