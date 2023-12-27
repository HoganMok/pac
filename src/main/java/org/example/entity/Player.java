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
    private int playerXCoordinate, playerYCoordinate;
    public enum movement {
        idle, left, right, up, down, dead
    }
    private InputManager inputManager;
    private ImageManager imageManager;
    private Map<movement, List<BufferedImage>>animation;
    private movement movementState;
    private int iterator = 0;
    private Game game;
    private int aniTick, aniIndex, aniSpeed = 10;
    public Player(ImageManager imageManagers, int xCoordinate, int yCoordinate, InputManager inputManagers, Game games){
        inputManager = inputManagers;
        imageManager = imageManagers;
        game = games;

        playerXCoordinate = xCoordinate;
        playerYCoordinate = yCoordinate;


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
    public void update(Double deltaTime) {
        super.update(deltaTime);
        for (Map.Entry<InputManager.direction, Boolean> entry : inputManager.getKeyStates().entrySet()) {
            if (entry.getValue()){
                switch (entry.getKey()) {
                    case Up -> {
                        playerYCoordinate-=10;
                        movementState = movement.up;
                    }
                    case Down -> {
                        playerYCoordinate+=10;
                        movementState = movement.down;
                    }
                    case Left -> {
                        playerXCoordinate-=10;
                        movementState = movement.left;
                    }
                    case Right -> {
                        playerXCoordinate+=10;
                        movementState = movement.right;
                    }
                }
            }
        }
    }
    private void updateTick(){
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= animation.get(movementState).size()) {
                aniIndex = 0;
            }
        }
    }
    @Override
    public void draw(Graphics g, Double deltaTime){
        Graphics2D g2 = (Graphics2D) g;
        updateTick();
        g2.drawImage(animation.get(movementState).get(aniIndex),playerXCoordinate,playerYCoordinate, game);
        iterator++;
    }
}
