package org.example.entity;

import org.example.Game;
import org.example.factory.BoostFactory;
import org.example.manager.ImageManager;
import org.example.manager.InputManager;
import org.example.sprite.AnimatedSprite;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boost extends Entity{
    public enum movement {
        idle
    }
    private AnimatedSprite animatedSprite;
    private InputManager inputManager;
    private ImageManager imageManager;
    private java.util.List<BufferedImage> bufferedImages;
    private Map<Boost.movement, List<BufferedImage>> animation;
    private movement movementStates;
    private int boostXCoordinate;
    private int boostYCoordinate;
    private Game game;
    private int iterator = 0;
    private int aniTick, aniIndex, aniSpeed = 10;
    private String boostType;
    public Boost(BoostFactory.boostType BoostTypes, ImageManager imageManagers, int xCoordinate, int yCoordinate, InputManager inputManagers, Game
            games){
        inputManagers = inputManagers;
        bufferedImages = new ArrayList<>();
        imageManager = imageManagers;
        boostXCoordinate = xCoordinate;
        boostYCoordinate = yCoordinate;
        game = games;
        animation = new HashMap<>();
        int number;
        movementStates = movement.idle;
        boostType = switch (BoostTypes) {
            case coin -> "coin";
            case powerup -> "powerup";
            default -> "snacks";
        };
        number = switch (BoostTypes) {
            case coin -> 1;
            case powerup -> 1;
            default -> 16;
        };
        animatedSprite = new AnimatedSprite( imageManager, 10,
                "/Sprites/"+boostType+".png", 1, 1);


        BufferedImage bufferedImage = switch (BoostTypes) {
            case coin, powerup, apple -> animatedSprite.getImagesList().get(0);
            case banana -> animatedSprite.getImagesList().get(1);
            case donut -> animatedSprite.getImagesList().get(2);
            case burger -> animatedSprite.getImagesList().get(3);
            case egg -> animatedSprite.getImagesList().get(4);
            case corn -> animatedSprite.getImagesList().get(5);
            case shoes -> animatedSprite.getImagesList().get(6);
            case cake -> animatedSprite.getImagesList().get(7);
            case peach -> animatedSprite.getImagesList().get(8);
            case melon -> animatedSprite.getImagesList().get(9);
            case tea -> animatedSprite.getImagesList().get(10);
            case mushroom -> animatedSprite.getImagesList().get(11);
            case bell -> animatedSprite.getImagesList().get(12);
            case leaf -> animatedSprite.getImagesList().get(13);
            case ice_cream -> animatedSprite.getImagesList().get(14);
            case present -> animatedSprite.getImagesList().get(15);
        };
        bufferedImages.add(bufferedImage);
        animation.put(movement.idle, bufferedImages);
    }
    @Override
    public void update(double deltaTime) {
    }


    private void updateTick(){
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= animation.get(movementStates).size()) {
                aniIndex = 0;
            }
        }
    }

    @Override
    public void draw(Graphics g, double deltaTime) {
        Graphics2D g2 = (Graphics2D) g;
        bufferedImages = animation.get(movementStates);
        //updateTick();
        g2.drawImage(animation.get(movementStates).get(iterator%animation.get(movementStates).size()),boostXCoordinate,boostYCoordinate, game);
        iterator++;
    }
}
