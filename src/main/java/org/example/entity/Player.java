package org.example.entity;

import org.example.CollisionDetection;
import org.example.Game;
import org.example.manager.ImageManager;
import org.example.manager.InputManager;
import org.example.sprite.AnimatedSprite;
import org.example.HitBox;

import java.awt.*;
import java.awt.image.BufferedImage;
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
    private AnimatedSprite animatedSprite;
    private movement movementState;
    private Game game;
    private int ANI_TICK = 10;
    private int ANI_INDEX = 0;
    private final static int ANI_SPEED = 10;
    private HitBox playerHitBox;
    private List<HitBox> boardHitBoxList;
    private List<HitBox> playerhitBoxList;
    CollisionDetection collisionDetection;
    public Player(ImageManager imageManagers, int xCoordinate, int yCoordinate, InputManager inputManagers, Game games,
                  CollisionDetection gameCollisionDetection, List<HitBox> gameBoardHitBoxList){
        inputManager = inputManagers;
        imageManager = imageManagers;
        game = games;
        collisionDetection = gameCollisionDetection;
        boardHitBoxList = gameBoardHitBoxList;
        playerhitBoxList = new ArrayList<>();

        PLAYER_X_COORDINATE = xCoordinate;
        PLAYER_Y_COORDINATE = yCoordinate;

        animation = new HashMap<>();

        animatedSprite = new AnimatedSprite(imageManager, 12, "/Sprites/lil_pac.png",
                1, 1);

        animation.put(movement.idle, animatedSprite.getImagesSubList(0,1));
        animation.put(movement.left, animatedSprite.getImagesSubList(0,3));
        animation.put(movement.up, animatedSprite.getImagesSubList(3,6));
        animation.put(movement.right, animatedSprite.getImagesSubList(6,9));
        animation.put(movement.down, animatedSprite.getImagesSubList(9,12));

        animation.put(movement.dead,(new AnimatedSprite( imageManager, 11,
                "/Sprites/dead_pac.png", 1,1)).getImagesList());
        movementState=movement.idle;
        playerHitBox = new HitBox(xCoordinate+6,yCoordinate+6,(int)(16*3),(int)(16*3));
    }

    @Override
    public void update(double deltaTime) {
        for (Map.Entry<InputManager.direction, Boolean> entry : inputManager.getKeyStates().entrySet()) {
            if (entry.getValue()){
                switch (entry.getKey()) {
                    case Up -> {movementState = movement.up;}
                    case Down -> {movementState = movement.down;}
                    case Left -> {movementState = movement.left;}
                    case Right -> {movementState = movement.right;}
                }
            }
        }
        if (!collisionDetection.isCollided(boardHitBoxList, playerHitBox)) {
            switch (movementState) {
                case up -> {
                    PLAYER_Y_COORDINATE -= 5;
                }
                case down -> {
                    PLAYER_Y_COORDINATE += 5;
                }
                case left -> {
                    PLAYER_X_COORDINATE -= 5;
                }
                case right -> {
                    PLAYER_X_COORDINATE += 5;
                }
            }
        }
        playerHitBox.updateHixBox(PLAYER_X_COORDINATE, PLAYER_Y_COORDINATE);
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
    public void draw(Graphics g, double deltaTime, int assetScale){
        Graphics2D g2 = (Graphics2D) g;
        updateTick();
        g2.drawImage(animation.get(movementState).get(ANI_INDEX),PLAYER_X_COORDINATE,PLAYER_Y_COORDINATE,
                animation.get(movementState).get(ANI_INDEX).getWidth()*assetScale,
                animation.get(movementState).get(ANI_INDEX).getHeight()*assetScale, game);
        playerHitBox.drawHitBox(g);
    }
}
