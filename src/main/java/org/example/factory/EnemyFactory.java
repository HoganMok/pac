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
    public Map<EnemyType, Enemy> enemyMap;

    public EnemyFactory (ImageManager imageManagers, int xCoordinate, int yCoordinate, InputManager inputManagers, Game
            games){
        int i = 100;
        enemyMap = new HashMap<>();
        for (EnemyType Enemy : EnemyType.values()) {
            Enemy enemies = new Enemy(Enemy,imageManagers, xCoordinate+i, yCoordinate+i, inputManagers, games);
            enemyMap.put(Enemy, enemies);
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
    public void draw(Graphics g, double deltaTime) {
        for (Map.Entry<EnemyType, Enemy> entry : enemyMap.entrySet()) {
            entry.getValue().draw(g, deltaTime);
        }
    }
}
