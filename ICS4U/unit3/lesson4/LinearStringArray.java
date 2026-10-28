/*
Author: Roy Lu
Date: October 28th, 2026
Description: Searches an array of names and returns the matching index, if present.
*/

public class LinearStringArray {
    private String[] data;

    public LinearStringArray(String[] names) {
        data = names;
    }

    public int linearSearch(String searchKey) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(searchKey)) {
                return i;
            }
        }

        return -1;
    }
}
