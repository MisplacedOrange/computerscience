/*
Author: Roy Lu
Date: October 9th, 2026
Description: Stores shared coordinates and fill status for shapes, with helpers for their position and size.
*/

public class FillableShape {
    private int x1, y1, x2, y2;
    private boolean filled;

    public FillableShape() {
        this(0, 0, 0, 0, false);
    }

    public FillableShape(int x1, int y1, int x2, int y2, boolean filled) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.filled = filled;
    }

    public int getX1() { return x1; }
    public int getY1() { return y1; }
    public int getX2() { return x2; }
    public int getY2() { return y2; }
    public boolean getFilled() { return filled; }

    public int getUpperLeftX() {
        return Math.min(x1, x2);
    }

    public int getUpperLeftY() {
        return Math.min(y1, y2);
    }

    public int getWidth() {
        return Math.abs(x2 - x1);
    }

    public int getHeight() {
        return Math.abs(y2 - y1);
    }

    public void setX1(int x1) { this.x1 = x1; }
    public void setY1(int y1) { this.y1 = y1; }
    public void setX2(int x2) { this.x2 = x2; }
    public void setY2(int y2) { this.y2 = y2; }
    public void setFilled(boolean filled) { this.filled = filled; }
}
