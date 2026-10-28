/*
Author: Roy Lu
Date: October 28th, 2026
Description: Reads numbers from the user and reports whether iterative binary search finds them.
*/

import java.util.Scanner;
public class BinarySearchTest2 {
    public static void main(String[] args) {

        Scanner input = new Scanner( System.in );
        int searchInt;
        int position;

        BinarySearch searchArray = new BinarySearch( 15 );
        System.out.println( searchArray );

        System.out.print("Please enter an integer value (-1 to quit): " );
        searchInt = input.nextInt();
        System.out.println();

        while ( searchInt != -1 ) {

            position = searchArray.binarySearch( searchInt );

            if (position == -1) {
                System.out.println("The integer " + searchInt + " was not found.\n");
            } else {
                System.out.println("The integer " + searchInt + " was found in position " + position + ".\n");
            }
            System.out.print("Please enter an integer value (-1 to quit): " );
            searchInt = input.nextInt();
        }
    }
}
