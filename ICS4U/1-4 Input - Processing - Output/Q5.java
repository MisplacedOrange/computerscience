/*
Author: Roy Lu
Date: September 11th, 2026
Description: Using Scanner to produce Sum Average and Product.
*/

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        int sum = a + b + c;
        double average = sum / 3.0;
        int product = a * b * c;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Product: " + product);
    }
}
