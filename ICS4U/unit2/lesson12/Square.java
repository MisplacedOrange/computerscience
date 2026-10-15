/*
Author: Roy Lu
Date: October 14, 2026
Description: Reuses Rectangle calculations with equal side lengths for a square.
*/

public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    @Override
    public double area() {
        return super.area();
    }

    @Override
    public double perimeter() {
        return super.perimeter();
    }
}
