/*
Author: Roy Lu
Date: October 14, 2026
Description: Stores rectangle dimensions and calculates its area and perimeter.
*/

public class Rectangle extends Shape2D {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        if (!Double.isFinite(length) || !Double.isFinite(width)
                || length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive, finite numbers.");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}
