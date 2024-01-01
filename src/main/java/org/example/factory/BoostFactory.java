package org.example.factory;

import org.example.Game;
import org.example.entity.Boost;
import org.example.entity.Enemy;
import org.example.manager.ImageManager;
import org.example.manager.InputManager;

import java.awt.*;
import java.util.HashMap;
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

    public BoostFactory (ImageManager imageManagers, InputManager inputManagers, Game games){
        boostMap = new HashMap<>();
        imageManager = imageManagers;
        inputManager = inputManagers;
         game = games;
    }

    public void createBoost(boostType BoostType, int xCoordinate, int yCoordinate){
        Boost boost = new Boost(BoostType, imageManager, xCoordinate, yCoordinate, inputManager, game);
        boostMap.put(BoostType, boost);
    }


    public void update(double deltaTime){
        for (Map.Entry<BoostFactory.boostType, Boost> entry : boostMap.entrySet()) {
            entry.getValue().update(deltaTime);
        }
    }

    public void draw(Graphics g, double deltaTime) {
        for (Map.Entry<BoostFactory.boostType, Boost> entry : boostMap.entrySet()) {
            entry.getValue().draw(g, deltaTime);
        }
    }
}
