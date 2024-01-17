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
    private ImageManager imageManager;
    private List<BufferedImage> bufferedImages;
    private Map<Boost.movement, List<BufferedImage>> animation;
    private movement movementStates;
    private int BOOST_X_COORDINATE;
    private int BOOST_Y_COORDINATE;
    private Game game;
    private int ANI_TICK = 10;
    private int ANI_INDEX = 0;
    private final static int ANI_SPEED = 10;
    public Boost(BoostFactory.boostType BoostTypes, ImageManager imageManagers, int xCoordinate, int yCoordinate, Game
            games){
        bufferedImages = new ArrayList<>();
        imageManager = imageManagers;
        BOOST_X_COORDINATE = xCoordinate;
        BOOST_Y_COORDINATE = yCoordinate;
        game = games;
        animation = new HashMap<>();
        movementStates = movement.idle;

        animatedSprite = switch (BoostTypes) {
            case coin -> new AnimatedSprite( imageManager, 1,
                    "/Sprites/"+BoostTypes+".png", 1, 1);
            case powerup ->  new AnimatedSprite( imageManager, 2,
                    "/Sprites/"+BoostTypes+".png", 1, 1);
            default -> new AnimatedSprite( imageManager, 16,
                    "/Sprites/snacks.png", 1, 1);
        };

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
        ANI_TICK++;
        if (ANI_TICK >= ANI_SPEED) {
            ANI_TICK = 0;
            ANI_INDEX++;
            if (ANI_INDEX >= animation.get(movementStates).size()) {
                ANI_INDEX = 0;
            }
        }
    }

    @Override
    public void draw(Graphics g, double deltaTime, int assetScale) {
        Graphics2D g2 = (Graphics2D) g;
        updateTick();
        g2.drawImage(animation.get(movementStates).get(ANI_INDEX),
                BOOST_X_COORDINATE,BOOST_Y_COORDINATE,
                animation.get(movementStates).get(ANI_INDEX).getWidth()*assetScale,
                animation.get(movementStates).get(ANI_INDEX).getHeight()*assetScale,game);
    }
}
