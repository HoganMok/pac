package org.example.entity;

import org.example.Game;

import java.awt.*;

public abstract class Entity<T extends Enum<T>> {
    private int currentAnimationFrame = 0;
    private double currentAnimationSeconds = 0;
    private double currentAnimationFramesPerSecond = 8.5;
    private double currentAnimationSecondsPerFrame = 1 / currentAnimationFramesPerSecond;
    public abstract void update(double deltaTime);
    public abstract void draw(Graphics g, double deltaTime);
}
