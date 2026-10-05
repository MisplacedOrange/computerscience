/*
Author: Roy Lu
Date: October 5th, 2026
Description: Represents a rectangle.
*/

public class Q2 {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private boolean filled;

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

class RectangleTest {
    public static void main(String[] args) {
        Q2 rectangle = new Q2();
        rectangle.setX1(2);
        rectangle.setY1(3);
        rectangle.setX2(8);
        rectangle.setY2(9);
        rectangle.setFilled(true);

        System.out.println(rectangle);
        System.out.println("First corner: " + rectangle.getX1() + ", " + rectangle.getY1());
        System.out.println("Second corner: " + rectangle.getX2() + ", " + rectangle.getY2());
        System.out.println("Filled: " + rectangle.getFilled());

        rectangle.setX1(-2);
        rectangle.setY1(-3);
        rectangle.setX2(-8);
        rectangle.setY2(-9);
        rectangle.setFilled(false);
        System.out.println("After negative coordinates: " + rectangle);
    }
}
