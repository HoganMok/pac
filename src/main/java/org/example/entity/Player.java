package org.example.entity;

import org.example.Game;
import org.example.manager.ImageManager;
import org.example.manager.InputManager;
import org.example.sprite.AnimatedSprite;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Map;

public class Player extends Entity {
    private int playerXCoordinate, playerYCoordinate;
    public enum playerType {
        yellow
    }

    private AnimatedSprite animatedSprite;
    private InputManager inputManager;
    private ImageManager imageManager;
    private BufferedImage[] bufferedImages;
    private Game game;
    private Thread delayThread;
    public Player(ImageManager imageManagers, int xCoordinate, int yCoordinate, InputManager inputManagers, Game games){
        inputManager = inputManagers;
        imageManager = imageManagers;
        game = games;
        animatedSprite = new AnimatedSprite(AnimatedSprite.spriteType.player, imageManager, 3,
                "/Sprites/processed_image.png");
        bufferedImages = animatedSprite.getImagesList();
        playerXCoordinate = xCoordinate;
        playerYCoordinate = yCoordinate;
    }

    @Override
    public void update() {
        for (Map.Entry<InputManager.direction, Boolean> entry : inputManager.getKeyStates().entrySet()) {
            if (entry.getValue()){
                switch (entry.getKey()) {
                    case Up -> playerYCoordinate-=10;
                    case Down -> playerYCoordinate+=10;
                    case Left -> playerXCoordinate-=10;
                    case Right -> playerXCoordinate+=10;
                }
            }
        }
    }

    @Override
    public void draw(Graphics g, Game game, Long deltaTime){
        for (int i = 0; i < 3; i++){
            try {
                Thread.sleep(5);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(bufferedImages[i],playerXCoordinate,playerYCoordinate, game);
        }
    }
}
