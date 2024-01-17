package org.example.factory;

import org.example.Game;
import org.example.entity.Enemy;
import org.example.manager.ImageManager;
import org.example.manager.InputManager;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class EnemyFactory extends EntityFactory{
    public enum EnemyType {
        red_enemy, pink_enemy, blue_enemy, yellow_enemy
    }
    private Map<EnemyType, Enemy> enemyMap;

    public EnemyFactory (ImageManager imageManagers, int enemyXCoordinate, int enemyYCoordinate,
                         InputManager inputManagers, Game games){
        int i = 100;
        enemyMap = new HashMap<>();
        for (EnemyType enemyType : EnemyType.values()) {
            Enemy enemy = new Enemy(enemyType,imageManagers, enemyXCoordinate+i, enemyYCoordinate+i,
                    inputManagers, games);
            enemyMap.put(enemyType, enemy);
            i+=50;
        }
    }
    @Override
    public void update(double deltaTime){
        for (Map.Entry<EnemyType, Enemy> entry : enemyMap.entrySet()) {
            entry.getValue().update(deltaTime);
        }
    }
    @Override
    public void draw(Graphics g, double deltaTime, int assetScale) {
        for (Map.Entry<EnemyType, Enemy> entry : enemyMap.entrySet()) {
            entry.getValue().draw(g, deltaTime, assetScale);
        }
    }
}
