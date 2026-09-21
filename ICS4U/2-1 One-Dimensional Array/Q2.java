/*
Author: Roy Lu
Date: September 21st, 2026
Description: Analyzing short test
*/

public class Q2 {
    public static void main(String[] args) {
        int array[] = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 };
        int total = 0;

        for ( int number: array )
            total += number;

        System.out.printf( "Total of array elements: %d\n", total );
        /*
        This short program creates an array containing ten test scores and uses a for loop to go through each element.
        Each iteration, number is added to total and prints the total after every element is processed

        A disadvantage of writing a for loop like is this that you are unable to directly add 1 to each value in the array/
        to add 1 to every element a regular for loop must be used where index could be ++
        */

    }
}