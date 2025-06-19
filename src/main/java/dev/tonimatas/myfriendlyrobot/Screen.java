package dev.tonimatas.myfriendlyrobot;

import java.awt.*;

public class Screen {
    private static Dimension getScreenDimension() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static Point getCenterPixel() {
        Dimension screenDimension = getScreenDimension();

        int centerX = screenDimension.width / 2;
        int centerY = screenDimension.height / 2;

        return new Point(centerX, centerY);
    }
}
