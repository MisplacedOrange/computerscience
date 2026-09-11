/*
Author: Roy Lu
Date: September 11th, 2026
*/

public class Q7 {
    public static double degreesToRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    public static double radiansToDegrees(double radians) {
        return radians * 180 / Math.PI;
    }
    
    public static void main(String[] args) {
        System.out.println(degreesToRadians(90));
        System.out.println(radiansToDegrees(90));
    }
}
