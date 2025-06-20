package dev.tonimatas.myfriendlyrobot;

import com.github.kwhat.jnativehook.GlobalScreen;

import java.awt.*;
import java.awt.event.InputEvent;

public class RobotThread implements Runnable {
    private static boolean isPressedByRobot = false;

    @Override
    public void run() {
        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new GlobalKeyListener());

            Robot robot = new Robot();

            for (; ; ) {
                Point center = Screen.getCenterPixel();

                Color colorCenter = robot.getPixelColor(center.x, center.y);
                Color colorLeft = robot.getPixelColor(center.x - 38, center.y);

                String hexCenter = String.format("#%02x%02x%02x", colorCenter.getRed(), colorCenter.getGreen(), colorCenter.getBlue());
                String hexLeft = String.format("#%02x%02x%02x", colorLeft.getRed(), colorLeft.getGreen(), colorLeft.getBlue());

                String hexToCalculate = GlobalKeyListener.keyPressed ? hexLeft : hexCenter;

                if (GlobalKeyListener.keyPressed) {
                    invertedKeyLogic(robot, hexToCalculate);
                } else {
                    keyLogic(robot, hexToCalculate);
                }
            }
        } catch (Exception ignored) {

        }
    }

    private void keyLogic(Robot robot, String hex) {
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

    private void invertedKeyLogic(Robot robot, String hex) {
        if (hex.equalsIgnoreCase("#fe0000")) {
            if (isPressedByRobot) {
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                isPressedByRobot = false;
            }
        } else {
            if (hex.equalsIgnoreCase("#fefefe")) {
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                isPressedByRobot = true;
            }
        }
    }
}
