package dev.tonimatas.myfriendlyrobot;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListener implements NativeKeyListener {
    public static boolean keyPressed = false;

    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        if (!keyPressed) {
            keyPressed = e.getKeyCode() == NativeKeyEvent.VC_6;
        } else {
            keyPressed = !(e.getKeyCode() == NativeKeyEvent.VC_1 ||
                    e.getKeyCode() == NativeKeyEvent.VC_2 ||
                    e.getKeyCode() == NativeKeyEvent.VC_3 ||
                    e.getKeyCode() == NativeKeyEvent.VC_4 ||
                    e.getKeyCode() == NativeKeyEvent.VC_5);
        }
    }
}
