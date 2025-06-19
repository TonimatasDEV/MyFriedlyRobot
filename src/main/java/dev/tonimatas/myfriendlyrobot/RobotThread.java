package dev.tonimatas.myfriendlyrobot;

import java.awt.*;
import java.awt.event.InputEvent;

public class RobotThread implements Runnable {
    @Override
    public void run() {
        try {
            Robot robot = new Robot();

            boolean isPressedByRobot = false;
            for (;;) {
                Point center = Screen.getCenterPixel();
                Color color = robot.getPixelColor(center.x, center.y);

                String hex = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());

                if (hex.equalsIgnoreCase("#fe0000")) {
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    isPressedByRobot = true;
                } else {
                    if (isPressedByRobot) {
                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                        isPressedByRobot = false;
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }
}
