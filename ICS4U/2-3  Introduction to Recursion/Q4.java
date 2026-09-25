/*
Author: Roy Lu
Date: September 25th, 2026
Description: Short program using recursion to find the sum of all numbers leading up to a specified integer.
*/

public class Q4 {
    public static void main(String[] args) {
        int answer = sum(5);
        System.out.println(answer);
    }

    // Precondition: n is not negative.
    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }
}
