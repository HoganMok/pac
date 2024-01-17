package org.example;

import org.example.entity.Enemy;
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
    private Map<EntityFactory.factoryType, EntityFactory<?>> entityFactoryMap;
    private BoostFactory boostFactory;
    private Player player;
    private double CURRENT_DELTA_TIME;
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
        entityFactoryMap = new HashMap<>();
        entityFactoryMap.put(EntityFactory.factoryType.boostFactory, new BoostFactory(imageManager, this));
        entityFactoryMap.put(EntityFactory.factoryType.enemyFactory, new EnemyFactory(imageManager, 0,
                0, inputManager,this));
        entityFactoryMap.put(EntityFactory.factoryType.playerFactory, new PlayerFactory(PlayerFactory.PlayerType.yellow,
                imageManager, 0, 0, inputManager, this));
        boostFactory = (BoostFactory) entityFactoryMap.get(EntityFactory.factoryType.boostFactory);
        boostFactory.createBoost(BoostFactory.boostType.egg, 200, 250);
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
        for (Map.Entry<EntityFactory.factoryType, EntityFactory<?>> entry : entityFactoryMap.entrySet()) {
            if (entry != null) {
                entry.getValue().update(CURRENT_DELTA_TIME);
            }
        }
        ///////Remember to set a stop condition!!!!!
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Map.Entry<EntityFactory.factoryType, EntityFactory<?>> entry : entityFactoryMap.entrySet()) {
            entry.getValue().draw(g, CURRENT_DELTA_TIME, 2);
        }
    }
}
