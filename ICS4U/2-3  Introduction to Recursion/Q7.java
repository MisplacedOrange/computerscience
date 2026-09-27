/*
Author: Roy Lu
Date: September 27th, 2026
Description: Short program demonstrating the Fibonacci sequence using a for loop.
*/

public class Q7 {
    public static void main(String[] args) {

        int terms = 10;
        int firstTerm = 0;
        int secondTerm = 1;

        for (int i = 0; i < terms; i++) {
            System.out.println(firstTerm + " ");
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }
}
