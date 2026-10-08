/*
Author: Roy Lu
Date: October 8th, 2026
Description: Represents a rectangle using two coordinate points and a filled setting.
*/

public class Rectangle {

    private static int numRectangles = 0;

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private boolean filled;

    public Rectangle() {
        numRectangles++;
    }

    public static int getNumRectangles() {
        return numRectangles;
    }

    public static void setNumRectangles(int numRectangles) {
        Rectangle.numRectangles = numRectangles;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getUpperLeftX() {
        return Math.min(x1, x2);
    }

    public int getUpperLeftY() {
        return Math.min(y1, y2);
    }

    public int getWidth() {
        return Math.abs(x1 - x2);
    }

    public int getHeight() {
        return Math.abs(y1 - y2);
    }

    public double calcArea() {
        return (double) getWidth() * getHeight();
    }

    public boolean getFilled() {
        return filled;
    }

    // Rectangles overlap when they share an area; touching edges do not count.
    public boolean isOverlapping(Rectangle other) {
        if (other == null) {
            return false;
        }

        return Math.max(Math.min(x1, x2), Math.min(other.x1, other.x2)) < Math.min(Math.max(x1, x2), Math.max(other.x1, other.x2)) && Math.max(Math.min(y1, y2), Math.min(other.y1, other.y2)) < Math.min(Math.max(y1, y2), Math.max(other.y1, other.y2));
    }

    public void setX1(int x1) {
        if (x1 < 0) {
            x1 = 0;
        }
        this.x1 = x1;
    }

    public void setX2(int x2) {
        if (x2 < 0) {
            x2 = 0;
        }
        this.x2 = x2;
    }

    public void setY1(int y1) {
        if (y1 < 0) {
            y1 = 0;
        }
        this.y1 = y1;
    }

    public void setY2(int y2) {
        if (y2 < 0) {
            y2 = 0;
        }
        this.y2 = y2;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String toString() {
        return "Rectangle: x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", filled=" + filled;
    }
}
