/*
Author: Roy Lu
Date: September 30th, 2026
Description: Recursively counts how many times a character appears in a line.
*/

public class Q6 {
    public static void main(String[] args) {
        System.out.println(count("this is a test", 's'));
        System.out.println(count("this is a test", 'x'));
    }

    public static int count(String line, char c) {
        if (line.isEmpty()) {
            return 0;
        }
        return (line.charAt(0) == c ? 1 : 0)
                + count(line.substring(1), c);
    }
}
