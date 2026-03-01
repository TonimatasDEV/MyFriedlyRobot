package dev.tonimatas.myfriendlyrobot;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        Thread thread = new Thread(new RobotThread());
        thread.start();
        JOptionPane.showConfirmDialog(null, "You want to close MyFriendlyRobot?", "MyFriendlyRobot", JOptionPane.DEFAULT_OPTION);
        thread.interrupt();
        System.exit(0);
    }
}
