/*
Author: Roy Lu
Date: September 16th, 2026
Description: small program to convert cents into small coins
*/



import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Enter amount in cents: ");
        int amount = input.nextInt();

        int quarters = amount / 25;
        int nickels = (amount % 25) / 5;
        int cents = amount % 5;

        System.out.print(amount + " cents requires ");
                
        if (quarters > 0) {
            System.out.print(quarters + " quarter(s)");
        }

        if (nickels > 0) {
            System.out.print(", " + nickels + " nickel(s)");
        }

        if (cents > 0) {
            System.out.print(", " + cents + " cent(s)");
        }
        System.out.print('.');
        
    }
}
