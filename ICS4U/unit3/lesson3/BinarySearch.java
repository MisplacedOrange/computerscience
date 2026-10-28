/*
Author: Roy Lu
Date: October 28th, 2026
Description: Builds a sorted integer array and provides recursive and iterative binary search methods.
*/

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    private int[] data;

    public BinarySearch(int size) {
        data = new int[size];
        Random generator = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = 10 + generator.nextInt(90);
        }
        Arrays.sort(data);
    }

    public int recursiveBinarySearch( int searchKey ) {
        return recursiveBinarySearch(searchKey, 0, data.length - 1);
    }

    private int recursiveBinarySearch( int searchKey, int low, int high ) {

        if (low > high) {
            return -1;
        }
        int middle = low + (high - low) / 2;

        System.out.print( searchProgress( low, middle, high ) );

        if (searchKey == data[middle]) {
            return middle;
        }

        if (searchKey < data[middle]) {
            return recursiveBinarySearch( searchKey, low, middle - 1 );
        }
        return recursiveBinarySearch( searchKey, middle + 1, high );
    }

    public int binarySearch( int searchKey ) {
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            System.out.print( searchProgress( low, middle, high ) );

            if (searchKey == data[middle]) {
                return middle;
            }
            else if (searchKey < data[middle]) {
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }

        return -1;
    }

    private String searchProgress(int low, int middle, int high) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < low; i++) result.append(' ');

        for (int i = low; i <= high; i++) result.append(data[i]).append(' ');

        result.append('\n');
        for (int i = 0; i < middle; i++) result.append(' ');

        return result.append("*\n").toString();
    }

    @Override
    public String toString() {
        if (data.length == 0) return "[]";
        return searchProgress(0, (data.length - 1) / 2, data.length - 1);
    }
}
