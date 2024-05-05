package org.example.manager;

import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class InputManager implements KeyListener{
    public enum direction {
        Left, Right, Up, Down, End
    }
    private final Map<direction, Boolean> keyStates;
    private boolean isPressed;
    public InputManager(){
       keyStates = new HashMap<>();
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        isPressed = true;
        direction Direction = getDirection(e);
        keyStates.put(Direction, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        isPressed = false;
        direction Direction = getDirection(e);
        keyStates.put(Direction, false);
    }

    private direction getDirection(KeyEvent e){
        return switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> direction.Up;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> direction.Left;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> direction.Down;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> direction.Right;
            case KeyEvent.VK_ESCAPE -> direction.End;
            default -> null;
        };
    }
    public Map<direction, Boolean> getKeyStates() {return keyStates;}
    public boolean getIsPressed(){return isPressed;}
}
