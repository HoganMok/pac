package org.example.entity;

import org.example.Game;
import org.example.HitBox;
import org.example.factory.EnemyFactory;
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
        left, right, up, down, dead, hunted
    }
    private AnimatedSprite animatedSprite;
    private InputManager inputManager;
    private ImageManager imageManager;
    private Map<movement, List<BufferedImage>> animation;
    private movement movementStates;
    private int ENEMY_X_COORDINATE;
    private int ENEMY_Y_COORDINATE;
    private Game game;
    private int ANI_TICK = 10;
    private int ANI_INDEX = 0;
    private final static int ANI_SPEED = 10;
    private HitBox hitBox;
    public Enemy(EnemyFactory.EnemyType enemyType,ImageManager imageManagers, int xCoordinate, int yCoordinate, InputManager inputManagers, Game games) {
        inputManager = inputManagers;
        imageManager = imageManagers;
        game = games;
        animation = new HashMap<>();
        ENEMY_X_COORDINATE = xCoordinate;
        ENEMY_Y_COORDINATE = yCoordinate;

        animatedSprite = new AnimatedSprite(imageManager, 8,
                "/Sprites/"+enemyType+".png",1,1);
        movementStates = movement.left;
        animation.put(movement.left,animatedSprite.getImagesSubList(0,2));
        animation.put(movement.right,animatedSprite.getImagesSubList(2,4));
        animation.put(movement.up,animatedSprite.getImagesSubList(4,6));
        animation.put(movement.down,animatedSprite.getImagesSubList(6,8));
        animation.put(movement.dead,new AnimatedSprite(imageManager, 4,
                "/Sprites/enemy_eyes.png",1,1).getImagesList());
        animation.put(movement.hunted,new AnimatedSprite(imageManager, 3,
                "/Sprites/enemy_hunted.png",1,1).getImagesList());
        hitBox = new HitBox(xCoordinate,yCoordinate,16*3,16*3);
    }

    @Override
    public void update(double deltaTime){
        /////////Update the movementStates after building the tracking algorithm!!!!!!!!!!!!!!!!!!!!!!!!!
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
                ENEMY_X_COORDINATE,ENEMY_Y_COORDINATE,
                animation.get(movementStates).get(ANI_INDEX).getWidth()*assetScale,
                animation.get(movementStates).get(ANI_INDEX).getHeight()*assetScale,
                game);
        hitBox.drawHitBox(g);
    }
}
