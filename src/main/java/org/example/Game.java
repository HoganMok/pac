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
    private ArrayList<EntityFactory<?>> entityFactoryList;
    private Player player;
    private double currentDeltaTime;
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
        entityFactoryList = new ArrayList<>();
        entityFactoryList.add(boostFactory = new BoostFactory(imageManager, inputManager, this));
        boostFactory.createBoost(BoostFactory.boostType.egg, 150, 250);
        entityFactoryList.add(enemyFactory = new EnemyFactory(imageManager, 0, 0, inputManager,this));
        entityFactoryList.add(playerFactory = new PlayerFactory(PlayerFactory.PlayerType.yellow, imageManager, 0, 0,
                inputManager, this));
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
        for (EntityFactory<?> entityFactory : entityFactoryList) {
            if (entityFactory != null) {
                entityFactory.update(currentDeltaTime);
            }
        }
        ///////Remember to set a stop condition!!!!!
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (EntityFactory<?> entityFactory : entityFactoryList) {
            entityFactory.draw(g,currentDeltaTime);
        }
    }
}
