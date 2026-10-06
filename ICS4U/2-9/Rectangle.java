/*
Author: Roy Lu
Date: October 6th, 2026
Description: Represents a rectangle.
*/

public class Rectangle {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private boolean filled;

    public Rectangle() {
        this(0, 0, 0, 0, false);
    }

    public Rectangle(int x1, int y1, int x2, int y2, boolean filled) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setFilled(filled);
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
        return "Rectangle: x1=" + x1 + ", y1=" + y1 + ", x2=" + x2
                + ", y2=" + y2 + ", filled=" + filled;
    }
}
