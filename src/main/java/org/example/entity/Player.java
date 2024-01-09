package org.example.entity;

import org.example.Game;
import org.example.manager.ImageManager;
import org.example.manager.InputManager;
import org.example.sprite.AnimatedSprite;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends Entity {
    private int PLAYER_X_COORDINATE, PLAYER_Y_COORDINATE;
    public enum movement {
        idle, left, right, up, down, dead
    }
    private InputManager inputManager;
    private ImageManager imageManager;
    private Map<movement, List<BufferedImage>>animation;
    private movement movementState;
    private Game game;
    private int ANI_TICK = 10;
    private int ANI_INDEX = 0;
    private final static int ANI_SPEED = 10;
    public Player(ImageManager imageManagers, int xCoordinate, int yCoordinate, InputManager inputManagers, Game games){
        inputManager = inputManagers;
        imageManager = imageManagers;
        game = games;

        PLAYER_X_COORDINATE = xCoordinate;
        PLAYER_Y_COORDINATE = yCoordinate;

        animation = new HashMap<>();

        animation.put(movement.idle,(new AnimatedSprite( imageManager, 1,
                "/Sprites/lil_pac.png", 1,1)).getImagesList());
        animation.put(movement.left,(new AnimatedSprite( imageManager, 3,
                "/Sprites/lil_pac.png", 1,1)).getImagesList());
        animation.put(movement.up,(new AnimatedSprite( imageManager, 3,
                "/Sprites/lil_pac.png", 1,18)).getImagesList());
        animation.put(movement.right,(new AnimatedSprite( imageManager, 3,
                "/Sprites/lil_pac.png", 1,35)).getImagesList());
        animation.put(movement.down,(new AnimatedSprite( imageManager, 3,
                "/Sprites/lil_pac.png", 1,52)).getImagesList());
        animation.put(movement.dead,(new AnimatedSprite( imageManager, 11,
                "/Sprites/dead_pac.png", 1,1)).getImagesList());
        movementState=movement.idle;
    }

    @Override
    public void update(double deltaTime) {
        for (Map.Entry<InputManager.direction, Boolean> entry : inputManager.getKeyStates().entrySet()) {
            if (entry.getValue()){
                switch (entry.getKey()) {
                    case Up -> {
                        PLAYER_Y_COORDINATE-=10;
                        movementState = movement.up;
                    }
                    case Down -> {
                        PLAYER_Y_COORDINATE+=10;
                        movementState = movement.down;
                    }
                    case Left -> {
                        PLAYER_X_COORDINATE-=10;
                        movementState = movement.left;
                    }
                    case Right -> {
                        PLAYER_X_COORDINATE+=10;
                        movementState = movement.right;
                    }
                }
            }
        }
    }
    private void updateTick(){
        ANI_TICK++;
        if (ANI_TICK >= ANI_SPEED) {
            ANI_TICK = 0;
            ANI_INDEX++;
            if (ANI_INDEX >= animation.get(movementState).size()) {
                ANI_INDEX = 0;
            }
        }
    }
    @Override
    public void draw(Graphics g, double deltaTime){
        Graphics2D g2 = (Graphics2D) g;
        updateTick();
        g2.drawImage(animation.get(movementState).get(ANI_INDEX),PLAYER_X_COORDINATE,PLAYER_Y_COORDINATE, game);
    }
}
