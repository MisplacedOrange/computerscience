/*
Author: Roy Lu
Date: October 14, 2026
Description: Demonstrates polymorphism by measuring several shapes through Shape2D references.
*/

public class Shape2DTest {
    public static void main(String[] args) {
        Shape2D[] shapes = {
            new Rectangle(5, 3),
            new Triangle(3, 4, 5),
            new Square(4)
        };

        for (Shape2D shape : shapes) {
            System.out.println(shape.getClass().getSimpleName());
            System.out.printf("Area: %.2f%n", shape.area());
            System.out.printf("Perimeter: %.2f%n%n", shape.perimeter());
        }

        try {
            new Triangle(1, 2, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid triangle: " + e.getMessage());
        }
    }
}
