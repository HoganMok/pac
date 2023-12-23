package org.example.entity;

import org.example.Game;
import org.example.manager.ImageManager;
import org.example.manager.InputManager;
import org.example.sprite.AnimatedSprite;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enemy extends Entity{
    public enum movement {
        left, right, up, down
    }
    private AnimatedSprite animatedSprite;
    private InputManager inputManager;
    private ImageManager imageManager;
    private List<BufferedImage> bufferedImages;
    private Map<movement, List<BufferedImage>> animation;
    private movement movementStates;
    private int enemyXCoordinate;
    private int enemyYCoordinate;
    private Game game;
    private int iterator = 0;
    public Enemy(ImageManager imageManagers, int xCoordinate, int yCoordinate, InputManager inputManagers, Game games) {
        inputManager = inputManagers;
        imageManager = imageManagers;
        game = games;
        animation = new HashMap<>();
        enemyXCoordinate = xCoordinate;
        enemyYCoordinate = yCoordinate;

        animatedSprite = new AnimatedSprite(imageManager, 8,
                "/Sprites/processed_image.png",1,1);

        animation.put(movement.left,animatedSprite.getImagesSubList(0,2));
        animation.put(movement.right,animatedSprite.getImagesSubList(2,4));
        animation.put(movement.up,animatedSprite.getImagesSubList(4,6));
        animation.put(movement.down,animatedSprite.getImagesSubList(6,8));
    }

    @Override
    public void update(){
        /////////Update the movementStates after building the tracking algorithm!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        bufferedImages = animation.get(movementStates);
        g2.drawImage(bufferedImages.get(iterator % bufferedImages.size()), enemyXCoordinate, enemyYCoordinate, game);
        iterator++;
    }

}
