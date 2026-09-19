/*
Author: Roy Lu
Date: September 16th, 2026
Description: small program to handle largest value inputted given 10 values
*/


import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int counter = 1;
        int number;
        int largest;

        System.out.print("Enter number 1: ");
        largest = input.nextInt();

        counter++;

        while (counter <= 10) {
            System.out.print("Enter number " + counter + ": ");
            number = input.nextInt();

            if (number > largest) {
                largest = number;
            }

            counter++;
        }

        System.out.println("The largest number is " + largest);
    }
}