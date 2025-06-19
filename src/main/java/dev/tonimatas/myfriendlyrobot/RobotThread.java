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
                Point inferiorBorder = Screen.getInferiorBorderPixel();

                Color colorCenter = robot.getPixelColor(center.x, center.y);
                Color colorLeft = robot.getPixelColor(center.x - 38, center.y);
                Color colorInferiorBorder = robot.getPixelColor(inferiorBorder.x, inferiorBorder.y);

                String hexCenter = String.format("#%02x%02x%02x", colorCenter.getRed(), colorCenter.getGreen(), colorCenter.getBlue());
                String hexLeft = String.format("#%02x%02x%02x", colorLeft.getRed(), colorLeft.getGreen(), colorLeft.getBlue());

                if (inferiorColorChanged(colorInferiorBorder)) {
                    if (hexLeft.equalsIgnoreCase("#fe0000")) {
                        if (isPressedByRobot) {
                            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                            isPressedByRobot = false;
                        }
                    } else {
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        isPressedByRobot = true;
                    }
                } else {
                    if (hexCenter.equalsIgnoreCase("#fe0000")) {
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        isPressedByRobot = true;
                    } else {
                        if (isPressedByRobot) {
                            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                            isPressedByRobot = false;
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }

    private boolean inferiorColorChanged(Color color) {
        return color.getRed() >= 0 && color.getRed() <= 50
                && color.getGreen() >= 50 && color.getGreen() <= 150
                && color.getBlue() >= 0 && color.getBlue() <= 25;
    }
}
