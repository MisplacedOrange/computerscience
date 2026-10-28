/*
Author: Roy Lu
Date: October 28th, 2026
Description: Recursively checks each array element until it finds the target or reaches the end.
*/

public class RecursiveLinearSearch {
    public static void main(String[] args) {

        int[] data = {5, 1, 3, 7, 8};
        int result = recursiveLinearSearch(data, 0, 7);
        System.out.println("Found at index " + result);
    }

    public static int recursiveLinearSearch(int[] data, int index, int target) {
        if (index >= data.length) return -1;

        return data[index] == target
                ? index
                : recursiveLinearSearch(data, index + 1, target);
    }

}
