/*
Author: Roy Lu
Date: October 19, 2026
Description: Adds fill control and bound calculations for ovals and rectangles.
*/

import java.awt.Color;

public abstract class MyBoundedShape extends MyShape {

    private boolean filled;

    public MyBoundedShape() {
        super();
        this.filled = false;
    }

    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color);
        this.filled = filled;
    }

    public boolean getFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public int getUpperLeftX() {
        return Math.min(getX1(), getX2());
    }

    public int getUpperLeftY() {
        return Math.min(getY1(), getY2());
    }

    public int getWidth() {
        return Math.abs(getX2() - getX1());
    }

    public int getHeight() {
        return Math.abs(getY2() - getY1());
    }
}
