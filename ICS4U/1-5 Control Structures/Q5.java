/*
Author: Roy Lu
Date: September 16th, 2026
Description: small program to handle 1st and 2nd largest values given 10 inputs
*/


import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        int num1 = input.nextInt();

        System.out.print("Enter number 2: ");
        int num2 = input.nextInt();

        int largest;
        int secondLargest;

        if (num1 > num2) {
            largest = num1;
            secondLargest = num2;
        } else {
            largest = num2;
            secondLargest = num1;
        }

        int counter = 3;

        while (counter <= 10) {
            System.out.print("Enter number " + counter + ": ");
            int number = input.nextInt();

            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest) {
                secondLargest = number;
            }

            counter++;
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second largest: " + secondLargest);
    }
}