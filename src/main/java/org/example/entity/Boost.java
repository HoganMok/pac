package org.example.entity;

import org.example.Game;
import org.example.HitBox;
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
    public HitBox hitBox;
    private List<HitBox> boostHitBoxList;
    private int ASSET_SCALE;
    public Boost(BoostFactory.boostType BoostTypes, ImageManager imageManagers, int xCoordinate, int yCoordinate, Game
            games, List<HitBox> hitBoxList, int gameAssetScale){
        bufferedImages = new ArrayList<>();
        imageManager = imageManagers;
        BOOST_X_COORDINATE = xCoordinate;
        BOOST_Y_COORDINATE = yCoordinate;
        game = games;
        ASSET_SCALE = gameAssetScale;
        boostHitBoxList = hitBoxList;
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

        BufferedImage bufferedImage = null;
        switch (BoostTypes) {
            case coin, powerup, apple -> {
                bufferedImage = animatedSprite.getImagesList().get(0);
                boostHitBoxList.add(new HitBox(BOOST_X_COORDINATE+6*ASSET_SCALE,BOOST_Y_COORDINATE+6*ASSET_SCALE,
                        4*ASSET_SCALE,4*ASSET_SCALE));
            }        
            case banana -> {
                bufferedImage = animatedSprite.getImagesList().get(1);
            }
            case donut -> {
                bufferedImage = animatedSprite.getImagesList().get(2);
            }
            case burger -> {
                bufferedImage = animatedSprite.getImagesList().get(3);
            }
            case egg -> {
                bufferedImage = animatedSprite.getImagesList().get(4);
            }
            case corn -> {
                bufferedImage = animatedSprite.getImagesList().get(5);
            }
            case shoes -> {
                bufferedImage = animatedSprite.getImagesList().get(6);
            }
            case cake -> {
                bufferedImage = animatedSprite.getImagesList().get(7);
            }
            case peach -> {
                bufferedImage = animatedSprite.getImagesList().get(8);
            }
            case melon -> {
                bufferedImage = animatedSprite.getImagesList().get(9);
            }
            case tea -> {
                bufferedImage = animatedSprite.getImagesList().get(10);
            }
            case mushroom -> {
                bufferedImage = animatedSprite.getImagesList().get(11);
            }
            case bell -> {
                bufferedImage = animatedSprite.getImagesList().get(12);
            }
            case leaf -> {
                bufferedImage = animatedSprite.getImagesList().get(13);
            }
            case ice_cream -> {
                bufferedImage = animatedSprite.getImagesList().get(14);
            }
            case present -> {
                bufferedImage = animatedSprite.getImagesList().get(15);
            }
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
        for (HitBox hitbox: boostHitBoxList) {
            hitbox.drawHitBox(g);
        }
    }
}
