package org.example.factory;

import org.example.CollisionDetection;
import org.example.Game;
import org.example.HitBox;
import org.example.entity.Boost;
import org.example.entity.Enemy;
import org.example.manager.ImageManager;
import org.example.manager.InputManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoostFactory extends EntityFactory{

    public enum boostType{
        apple, banana, donut, burger, egg, corn, shoes, cake, peach, melon, tea, mushroom,
        bell, leaf, ice_cream, present, coin, powerup
    }
    private ImageManager imageManager;
    private InputManager inputManager;
    private Game game;
    public Map<boostType, Boost> boostMap;
    private List<Boost> boostList;
    private List<HitBox> boostHitBoxList;
    private CollisionDetection collisionDetection;
    private int ASSET_SCALE;
    public BoostFactory (ImageManager imageManagers, Game games, CollisionDetection gameCollisionDetection,
                         int gameAssetScale){
        boostMap = new HashMap<>();
        boostList = new ArrayList<>();
        boostHitBoxList = new ArrayList<>();
        imageManager = imageManagers;
        game = games;
        collisionDetection = gameCollisionDetection;
        ASSET_SCALE = gameAssetScale;
    }
    public void createBoost(boostType BoostType, int xCoordinate, int yCoordinate){
        Boost boost = new Boost(BoostType, imageManager, xCoordinate, yCoordinate, game, boostHitBoxList, ASSET_SCALE);
        boostList.add(boost);
        boostMap.put(BoostType, boost);
    }
    @Override
    public void update(double deltaTime){
        for (int i = 0; i < boostList.size(); i++){
            if (collisionDetection.isCollidedWithBoost(game.getPlayerFactory().getPlayer().getPlayerHitBox(),
                    boostHitBoxList.get(i))){
                boostList.remove(i);
                boostHitBoxList.remove(i);
                game.modifyGameScore(100);
                game.printGameScore();
            }
        }
    }
    @Override
    public void draw(Graphics g, double deltaTime, int assetScale) {
        for (Boost boost: boostList){
            boost.draw(g, deltaTime, assetScale);
        }
    }
    public List<HitBox> getBoostHitBoxList(){return boostHitBoxList;}
}
