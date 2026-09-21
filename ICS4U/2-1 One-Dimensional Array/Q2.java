/*
Author: Roy Lu
Date: September 21st, 2026
Description: Analyzing short test
*/

public class Q2 {
    public static void main(String[] args) {
        int[] scores = {87, 68, 94, 100, 83, 78, 85, 91, 76, 87};
        int total = 0;

        for (int score : scores) {
            total += score;
        }

        System.out.printf("Total of array elements: %d%n", total);
        /*
        The enhanced for loop reads each score but does not provide its index.
        Use a regular for loop when you need to change array elements by index.
        */

    }
}
