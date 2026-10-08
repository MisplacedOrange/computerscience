/*
Author: Roy Lu
Date: October 8th, 2026
Description: Represents an oval using two coordinate points and a filled setting.
*/

public class Oval {

    private static int numOvals = 0;

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private boolean filled;

    public Oval() {
        numOvals++;
    }

    public Oval(int x1, int y1, int x2, int y2, boolean filled) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setFilled(filled);
        numOvals++;
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

    public boolean getFilled() {
        return filled;
    }

    public static int getNumOvals() {
        return numOvals;
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

    public void setX1(int x1) {
        if (x1 < 0) {
            x1 = 0;
        }
        this.x1 = x1;
    }

    public void setY1(int y1) {
        if (y1 < 0) {
            y1 = 0;
        }
        this.y1 = y1;
    }

    public void setX2(int x2) {
        if (x2 < 0) {
            x2 = 0;
        }
        this.x2 = x2;
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

    public double calcArea() {
        return Math.PI * (getWidth() / 2.0) * (getHeight() / 2.0);
    }

    public boolean isCircle() {
        return getWidth() == getHeight();
    }

    public String toString() {
        return "Oval: x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", filled=" + filled;
    }
}
