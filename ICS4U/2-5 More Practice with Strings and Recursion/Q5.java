/*
Author: Roy Lu
Date: September 30th, 2026
Description: Recursively removes all spaces from a line of text.
*/


public class Q5 {
    public static void main(String[] args) {
        System.out.println(compact("this is a test"));
    }

    public static String compact(String line) {
        if (line.isEmpty()) {
            return "";
        }
        char first = line.charAt(0);
        String rest = compact(line.substring(1));
        if (first == ' ') {
            return rest;
        }
        return first + rest;
    }
}
