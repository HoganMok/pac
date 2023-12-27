package org.example.entity;

import org.example.Game;

import java.awt.*;

public abstract class Entity {
    private int currentAnimationFrame = 0;
    private double currentAnimationSeconds = 0;
    private double currentAnimationFramesPerSecond = 8.5;
    private double currentAnimationSecondsPerFrame = 1 / currentAnimationFramesPerSecond;
    void update(Double deltaTime){
        currentAnimationSeconds += deltaTime;
        if (currentAnimationSeconds >= currentAnimationSecondsPerFrame) {
            int frameIncrease = (int) (currentAnimationSeconds / currentAnimationSecondsPerFrame);
            currentAnimationSeconds = 0;
        }
    }
    abstract void draw(Graphics g, Double deltaTime);
}
