/*
Author: Roy Lu
Date: September 18th, 2026
Description: Finds the number from 1 to 10000 with the most divisors.
*/

public class Q2 {
    public static void main(String[] args) {

        int maxDivisors = 1;
        int numWithMax = 1;

        for (int n = 2; n <= 10000; n++) {

            int divisors = 0;

            for (int divisor = 1; divisor <= n; divisor++) {
                if (n % divisor == 0) {
                    divisors++;
                }
            }

            if (divisors > maxDivisors) {
                maxDivisors = divisors;
                numWithMax = n;
            }
        }

        System.out.println("The number " + numWithMax + " has " + maxDivisors + " divisors.");
    }
}
