package org.example;

import org.example.entity.Entity;
import org.example.entity.Player;
import org.example.factory.EnemyFactory;
import org.example.factory.BoostFactory;
import org.example.factory.EntityFactory;
import org.example.factory.PlayerFactory;
import org.example.manager.ImageManager;
import org.example.manager.InputManager;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game extends JPanel implements Runnable{
    private boolean isRunning;
    private Thread gameThread;
    private InputManager inputManager;
    private ImageManager imageManager;
    private PlayerFactory playerFactory;
    private EnemyFactory enemyFactory;
    private BoostFactory boostFactory;
    private Map<EntityFactory<?>, Boolean> entityFactory;
    private Player player;
    private long lastTime;
    private double currentFPS, currentDeltaTime;
    private int aniTick, aniSpeed = 10;
    Game(){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        startGameThread();
    }
    public void startGameThread (){
        setUpGame();
        this.addKeyListener(inputManager);
        this.setFocusable(true);
    }
    public void setUpGame(){
        isRunning = true;
        gameThread = new Thread(this);
        gameThread.start();
        inputManager = new InputManager();
        imageManager = new ImageManager();
        entityFactory = new HashMap<>();
        entityFactory.put(playerFactory = new PlayerFactory(PlayerFactory.PlayerType.yellow, imageManager, 0, 0,
                inputManager, this), true);
        entityFactory.put(enemyFactory = new EnemyFactory(imageManager, 0, 0, inputManager,this), true);
        entityFactory.put(boostFactory = new BoostFactory(imageManager, inputManager, this), true);
        boostFactory.createBoost(BoostFactory.boostType.egg, 100, 100);
    }
    @Override
    public void run(){
        double timePerFrame = 1000000000/60;
        double timePerUps = 1000000000/60;

        long lastFrame = System.nanoTime();
        long lastTimeUps = System.nanoTime();
        long lastTImeCheck = System.currentTimeMillis();

        if (gameThread.isAlive()){
            while (isRunning) {
                if (System.nanoTime() - lastFrame >= timePerFrame) {
                    lastFrame = System.nanoTime();
                    repaint();
                }
                if (System.nanoTime() - lastTimeUps >= timePerUps) {
                    update();
                    lastTimeUps = System.nanoTime();
                }
                if (System.currentTimeMillis() - lastTImeCheck >= 1000) {
                    lastTImeCheck = System.currentTimeMillis();
                }
            }
        }
    }
    private void update() {
        for (Map.Entry<EntityFactory<?>, Boolean> entry : entityFactory.entrySet()){
            if (entry.getKey() != null) {
                entry.getKey().update(currentDeltaTime);
            }
        }
        /*
        remember to set a stop condition
        if (inputManager.getKeyStates().get(InputManager.direction.End) != null && inputManager.getKeyStates().get(InputManager.direction.End)) {
            isRunning = false;
        }
         */
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Map.Entry<EntityFactory<?>, Boolean> entry : entityFactory.entrySet()){
            if (entry.getKey() != null) {
                entry.getKey().draw(g, currentDeltaTime);
            }
        }
    }
}
