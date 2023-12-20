package org.example.entity;

import org.example.Game;

import java.awt.*;

public abstract class Entity {
    abstract void update();
    abstract void draw(Graphics g, Game game, Long deltaTime);
}
