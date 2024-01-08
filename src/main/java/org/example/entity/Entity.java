package org.example.entity;

import org.example.Game;

import java.awt.*;

public abstract class Entity {
    private int currentAnimationFrame = 0;
    private double currentAnimationSeconds = 0;
    private double currentAnimationFramesPerSecond = 8.5;
    private double currentAnimationSecondsPerFrame = 1 / currentAnimationFramesPerSecond;
    public abstract void update(double deltaTime);
    public void draw(Graphics g, double deltaTime) {
        this.get
    }
}
