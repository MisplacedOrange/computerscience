/*
Author: Roy Lu
Date: October 9th, 2026
Description: Draws line patterns that resize with the window.
*/

import javax.swing.*;
import java.awt.*;

public class Q5 extends JPanel {
    private final boolean fourCorners;

    public Q5(boolean fourCorners) {
        this.fourCorners = fourCorners;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int steps = 15;

        for (int i = 0; i < steps; i++) {
            int x = (i + 1) * width / steps;
            int y = i * height / steps;

            g.drawLine(0, y, x, height);

            if (fourCorners) {
                g.drawLine(width, y, width - x, height);
                g.drawLine(0, height - y, x, 0);
                g.drawLine(width, height - y, width - x, 0);
            }
        }
    }

    public static void main(String[] args) {
        JFrame firstFrame = new JFrame("Design 1");
        firstFrame.add(new Q5(false));
        firstFrame.setSize(500, 500);
        firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        firstFrame.setVisible(true);

        JFrame secondFrame = new JFrame("Design 2");
        secondFrame.add(new Q5(true));
        secondFrame.setSize(500, 500);
        secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secondFrame.setLocation(550, 0);
        secondFrame.setVisible(true);
    }
}
