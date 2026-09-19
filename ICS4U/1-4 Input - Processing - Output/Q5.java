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

        System.out.println("Sum, Average, Product:");
        System.out.println(a+b+c);
        System.out.printf("%d\n", (a+b+c)/3);
        System.out.println(a*b*c);
    }
}
