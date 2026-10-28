/*
Author: Roy Lu
Date: October 28th, 2026
Description: Fills an integer array and supports both iterative and recursive linear searches.
*/

import java.util.Arrays;
import java.util.Random;

public class LinearArray {
    private int[] data;

    public LinearArray(int size) {
        data = new int[size];
        Random generator = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = 10 + generator.nextInt(90);
        }
    }

    public int linearSearch(int searchKey) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == searchKey) {
                return i;
            }
        }

        return -1;
    }

    public int recursiveLinearSearch(int searchKey, int index) {
        if (index >= data.length) {
            return -1;
        }

        if (data[index] == searchKey) {
            return index;
        }

        return recursiveLinearSearch(searchKey, index + 1);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
