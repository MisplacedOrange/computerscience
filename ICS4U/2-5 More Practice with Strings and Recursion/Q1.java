/*
Author: Roy Lu
Date: September 30th, 2026
Description: Demonstrates common Character class methods for checking and converting characters, and the == operator for comparing chars.
*/

public class Q1 {
    public static void main(String[] args) {
        char digit = '7';
        char letter = 'G';
        char lowercase = 'g';
        char punctuation = '!';

        System.out.println("isDigit('7'): " + Character.isDigit(digit));
        System.out.println("isLetter('G'): " + Character.isLetter(letter));
        System.out.println("isLetterOrDigit('!'): " + Character.isLetterOrDigit(punctuation));
        System.out.println("isLowerCase('g'): " + Character.isLowerCase(lowercase));
        System.out.println("isUpperCase('G'): " + Character.isUpperCase(letter));
        System.out.println("toUpperCase('g'): " + Character.toUpperCase(lowercase));
        System.out.println("toLowerCase('G'): " + Character.toLowerCase(letter));
        System.out.println("letter == 'G': " + (letter == 'G'));
    }
}
