/*
Author: Roy Lu
Date: October 22nd, 2026
Description: Opens a window showing the spiral and circle designs from SpiralPanel.
*/

import javax.swing.JFrame;

public class SpiralTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Spiral and Circle Patterns");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(820, 400);
        frame.add(new SpiralPanel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
