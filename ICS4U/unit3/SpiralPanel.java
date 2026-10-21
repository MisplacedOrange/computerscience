/*
Author: Roy Lu
Date: October 22nd, 2026
Description: Uses Java graphics and loops to draw square and circular spirals alongside a ring of overlapping circles.
*/

import java.awt.Graphics;
import javax.swing.JPanel;

public class SpiralPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawSquareSpiral(g);
        drawCircularSpiral(g);
        drawOvalPattern(g);
    }

    public void drawSquareSpiral(Graphics g) {
        int x = 120;
        int y = 180;
        int length = 10;

        for (int i = 0; i < 24; i++) {
            int newX = x;
            int newY = y;

            if (i % 4 == 0) {
                newY = y - length;
            } else if (i % 4 == 1) {
                newX = x - length;
            } else if (i % 4 == 2) {
                newY = y + length;
            } else {
                newX = x + length;
            }

            g.drawLine(x, y, newX, newY);

            x = newX;
            y = newY;

            if (i % 2 == 1) {
                length += 10;
            }
        }
    }

    public void drawCircularSpiral(Graphics g) {
        int centerX = 410;
        int centerY = 180;

        for (int i = 0; i < 16; i++) {
            int radius = 5 + i * 5;

            int x = centerX - radius;
            int y = centerY - radius;

            int startAngle = (i % 2 == 0) ? 0 : 180;

            g.drawArc(x, y, radius * 2, radius * 2, startAngle, 180);
        }
    }

    public void drawOvalPattern(Graphics g) {
        int centerX = 650;
        int centerY = 180;
        int radius = 35;
        int diameter = radius * 2;

        g.drawOval(centerX - radius, centerY - radius, diameter, diameter);

        for (int i = 0; i < 6; i++) {
            double angle = 2 * i * Math.PI / 6;

            int x = centerX + (int)(radius * Math.cos(angle));
            int y = centerY + (int)(radius * Math.sin(angle));

            g.drawOval(x - radius, y - radius, diameter, diameter);
        }
    }
}
