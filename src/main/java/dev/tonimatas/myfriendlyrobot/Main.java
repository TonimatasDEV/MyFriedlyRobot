package dev.tonimatas.myfriendlyrobot;

import java.awt.*;
import java.awt.event.InputEvent;

public class Main {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            boolean isPressedByRobot = false;
            while (true) {
                Color color = robot.getPixelColor(960, 539);

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