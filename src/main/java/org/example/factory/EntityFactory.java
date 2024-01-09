package org.example.factory;

import java.awt.*;

public abstract class EntityFactory<T extends Enum<T>> {
    enum spriteType {
        moveableSprite, immoveableSprite
    }
    public enum factoryType {
        playerFactory, enemyFactory, boostFactory
    }
    public abstract void update(double deltaTime);

    public abstract void draw(Graphics g, double deltaTime);
}