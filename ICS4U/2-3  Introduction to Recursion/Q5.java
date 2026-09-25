/*
Author: Roy Lu
Date: September 25th, 2026
Description: Short program introducing a power method using recursion.
*/

public class Q5 {
    public static void main(String[] args) {

        int result = power(2, 4);
        System.out.println(result);
    }

    public static int power(int base, int exponent) {
        if (exponent == 1) {
            return base;
        } else {
            return base * power(base, exponent - 1);
        }
    }
}
