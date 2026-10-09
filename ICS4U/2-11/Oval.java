/*
Author: Roy Lu
Date: October 9th, 2026
Description: Represents an oval and calculates its area and whether it forms a circle.
*/

public class Oval extends FillableShape {

    private static int numOvals = 0;

    public Oval() {
        super();
        numOvals++;
    }

    public Oval(int x1, int y1, int x2, int y2, boolean filled) {
        super(x1, y1, x2, y2, filled);
        numOvals++;
    }

    public static int getNumOvals() {
        return numOvals;
    }

    public double calcArea() {
        return Math.PI * getWidth() * getHeight() / 4.0;
    }

    public boolean isCircle() {
        return getWidth() == getHeight();
    }

    @Override
    public String toString() {
        return "Oval: x1=" + getX1()
                + ", y1=" + getY1()
                + ", x2=" + getX2()
                + ", y2=" + getY2()
                + ", filled=" + getFilled();
    }
}
