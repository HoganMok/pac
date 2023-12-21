package org.example.factory;

import org.example.Game;
import org.example.entity.Enemy;
import org.example.manager.ImageManager;
import org.example.manager.InputManager;

import java.awt.*;
import java.util.Map;

public class EnemyFactory extends EntityFactory{
    public enum enemyType {
        red, pink, blue, orange
    }

    public Map<enemyType, Enemy> enemyMap;

    public void EnemyFactory (ImageManager imageManagers, int xCoordinate, int yCoordinate, InputManager inputManagers, Game
            games){
        for (enemyType Enemy : enemyType.values()) {
            Enemy enemies = new Enemy(imageManagers, xCoordinate, yCoordinate, inputManagers, games);
            enemyMap.put(Enemy, enemies);
        }
    }

    public void update(){
        for (Map.Entry<enemyType, Enemy> entry : enemyMap.entrySet()) {
            entry.getValue().update();
        }
    }

    public void draw(Graphics g) {
        for (Map.Entry<enemyType, Enemy> entry : enemyMap.entrySet()) {
            entry.getValue().draw(g);
        }
    }
}
