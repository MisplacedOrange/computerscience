/*
Author: Roy Lu
Date: October 19, 2026
Description: Stores and paints an array of shapes while tracking each shape type.
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

    private MyShape[] shapes;
    private int lineCount;
    private int rectangleCount;
    private int ovalCount;

    public DrawPanel(int numberOfShapes) {
        setPreferredSize(new Dimension(400, 400));
        shapes = new MyShape[numberOfShapes];

        Random random = new Random();

        for (int i = 0; i < shapes.length; i++) {
            int x1 = random.nextInt(400);
            int y1 = random.nextInt(400);
            int x2 = random.nextInt(400);
            int y2 = random.nextInt(400);
            Color color = new Color(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256)
            );
            boolean filled = random.nextBoolean();

            int shapeType = random.nextInt(3);
            if (shapeType == 0) {
                shapes[i] = new MyLine(x1, y1, x2, y2, color);
                lineCount++;
            } else if (shapeType == 1) {
                shapes[i] = new MyRectangle(x1, y1, x2, y2, color, filled);
                rectangleCount++;
            } else {
                shapes[i] = new MyOval(x1, y1, x2, y2, color, filled);
                ovalCount++;
            }
        }
    }

    public DrawPanel() {
        setPreferredSize(new Dimension(400, 400));
        shapes = new MyShape[] {
            new MyRectangle(230, 95, 260, 175, Color.RED, true),
            new MyRectangle(100, 170, 300, 330, new Color(230, 165, 85), true),
            new MyLine(85, 175, 200, 70, Color.DARK_GRAY),
            new MyLine(200, 70, 315, 175, Color.DARK_GRAY),
            new MyLine(85, 175, 315, 175, Color.DARK_GRAY),
            new MyRectangle(170, 245, 230, 330, new Color(120, 70, 35), true),
            new MyOval(216, 282, 224, 290, new Color(235, 190, 60), true),
            new MyOval(125, 205, 165, 245, Color.BLUE, true),
            new MyOval(235, 205, 275, 245, Color.BLUE, true),
            new MyOval(315, 55, 365, 105, Color.YELLOW, true)
        };

        lineCount = 3;
        rectangleCount = 3;
        ovalCount = 4;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MyShape shape : shapes) {
            shape.draw(g);
        }
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getRectangleCount() {
        return rectangleCount;
    }

    public int getOvalCount() {
        return ovalCount;
    }
}
