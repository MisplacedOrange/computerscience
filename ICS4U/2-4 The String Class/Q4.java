/*
Author: Roy Lu
Date: September 29th, 2026
Description: Basic examples of string processing methods.
*/

public class Q4 {
    public static void main(String[] args) {
        String sample = "Hello 12";

        System.out.println("Only letters: " + isOnlyLetters("Hello"));
        System.out.println("Character count: " + countChars('l', sample));
        System.out.println("Reversed: " + reverseString("Hello"));
        System.out.println("Palindrome: " + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("Sum: " + addEmUp("2.3 14.77 2.71"));
        System.out.println("Unique letters: " + uniqueLetters("abcaBc"));
        System.out.println("First HTML tag: " + findFirstHTMLTag("Hello <b>world</b>"));
        System.out.println("After removing substring: " + removeSubstring("Hello world", " world"));
    }

    public static boolean isOnlyLetters(String text) {
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (!Character.isLetter(letter)) {
                return false;
            }
        }
        return !text.isEmpty();
    }

    public static int countChars(char target, String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }

    public static String reverseString(String text) {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        return reversed;
    }

    public static boolean isPalindrome(String text) {
        String cleanText = "";
        for (int i = 0; i < text.length(); i++) {
            char letter = Character.toLowerCase(text.charAt(i));
            if (Character.isLetterOrDigit(letter)) {
                cleanText += letter;
            }
        }
        return cleanText.equals(reverseString(cleanText));
    }

    public static double addEmUp(String text) {
        double sum = 0;
        String[] numbers = text.trim().split("\\s+");
        for (String number : numbers) {
            if (!number.isEmpty()) {
                sum += Double.parseDouble(number);
            }
        }
        return sum;
    }

    public static int uniqueLetters(String text) {
        String foundLetters = "";
        for (int i = 0; i < text.length(); i++) {
            char letter = Character.toLowerCase(text.charAt(i));
            if (Character.isLetter(letter) && foundLetters.indexOf(letter) == -1) {
                foundLetters += letter;
            }
        }
        return foundLetters.length();
    }

    public static String findFirstHTMLTag(String text) {
        int start = text.indexOf('<');
        int end = text.indexOf('>', start);
        if (start == -1 || end == -1) {
            return "";
        }
        return text.substring(start, end + 1);
    }

    public static String removeSubstring(String text, String part) {
        int start = text.indexOf(part);
        if (start == -1) {
            return text;
        }
        return text.substring(0, start) + text.substring(start + part.length());
    }
}