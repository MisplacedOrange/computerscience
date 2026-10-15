/*
Author: Roy Lu
Date: October 14, 2026
Description: Validates three side lengths and measures a triangle with Heron's formula.
*/

public class Triangle extends Shape2D {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (!Double.isFinite(sideA) || !Double.isFinite(sideB) || !Double.isFinite(sideC)
                || sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive, finite numbers.");
        }
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("The sum of any two sides must be greater than the third side.");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double area() {
        double semiPerimeter = perimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - sideA)
                * (semiPerimeter - sideB) * (semiPerimeter - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }
}
