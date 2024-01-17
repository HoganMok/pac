package org.example.entity;

import org.example.Game;

import java.awt.*;

public abstract class Entity<T extends Enum<T>> {
    public abstract void update(double deltaTime);
    public abstract void draw(Graphics g, double deltaTime, int assetScale);
}
