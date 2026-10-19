/*
Author: Roy Lu
Date: October 19, 2026
Description: Prompts for a drawing mode and opens the selected Swing window.
*/

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class DrawPanelTest {

    public static void main(String[] args) {
        String[] drawingModes = {"Random shapes", "House"};
        Object selectedMode = JOptionPane.showInputDialog(
            null,
            "Choose a drawing:",
            "Drawing with Polymorphism",
            JOptionPane.QUESTION_MESSAGE,
            null,
            drawingModes,
            drawingModes[0]
        );

        if (selectedMode == null) {
            return;
        }

        DrawPanel panel;
        if ("House".equals(selectedMode)) {
            panel = new DrawPanel();
        } else {
            panel = requestRandomDrawing();
            if (panel == null) {
                return;
            }
        }

        showWindow(panel);
    }

    private static DrawPanel requestRandomDrawing() {
        while (true) {
            String input = JOptionPane.showInputDialog(
                null,
                "How many shapes would you like to draw?"
            );

            if (input == null) {
                return null;
            }

            try {
                int numberOfShapes = Integer.parseInt(input.trim());
                if (numberOfShapes > 0) {
                    return new DrawPanel(numberOfShapes);
                }

                JOptionPane.showMessageDialog(
                    null,
                    "Please enter a positive integer."
                );
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                    null,
                    "Invalid input. Please enter an integer."
                );
            }
        }
    }

    private static void showWindow(DrawPanel panel) {
        JFrame frame = new JFrame("Drawing with Polymorphism");
        JLabel status = new JLabel(
            "Lines: " + panel.getLineCount()
            + " | Rectangles: " + panel.getRectangleCount()
            + " | Ovals: " + panel.getOvalCount(),
            SwingConstants.CENTER
        );

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(status, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
