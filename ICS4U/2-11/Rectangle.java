/*
Author: Roy Lu
Date: October 9th, 2026
Description: Represents a rectangle and provides its area and overlap calculations.
*/

public class Rectangle extends FillableShape {

    private static int numRectangles = 0;

    public Rectangle() {
        super();
        numRectangles++;
    }

    public Rectangle(int x1, int y1, int x2, int y2, boolean filled) {
        super(x1, y1, x2, y2, filled);
        numRectangles++;
    }

    public static int getNumRectangles() {
        return numRectangles;
    }

    public static void setNumRectangles(int numRectangles) {
        Rectangle.numRectangles = numRectangles;
    }

    public double calcArea() {
        return (double) getWidth() * getHeight();
    }

    public boolean isOverlapping(Rectangle other) {
        if (other == null) {
            return false;
        }

        return Math.max(getUpperLeftX(), other.getUpperLeftX())
                < Math.min(getUpperLeftX() + getWidth(), other.getUpperLeftX() + other.getWidth())
            && Math.max(getUpperLeftY(), other.getUpperLeftY())
                < Math.min(getUpperLeftY() + getHeight(), other.getUpperLeftY() + other.getHeight());
    }

    @Override
    public String toString() {
        return "Rectangle: x1=" + getX1()
                + ", y1=" + getY1()
                + ", x2=" + getX2()
                + ", y2=" + getY2()
                + ", filled=" + getFilled();
    }
}
