package org.example;

import org.example.entity.Player;
import org.example.factory.PlayerFactory;
import org.example.manager.ImageManager;
import org.example.manager.InputManager;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;

public class Game extends JPanel implements Runnable{
    boolean isRunning;
    Thread gameThread;
    InputManager inputManager;
    ImageManager imageManager;
    PlayerFactory playerFactory;
    Player player;
    long lastTime;
    Game(){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        startGameThread();
    }

    public void startGameThread (){
        gameThread = new Thread(this);
        gameThread.start();
        inputManager = new InputManager();
        imageManager = new ImageManager();
        playerFactory = new PlayerFactory(PlayerFactory.PlayerType.yellow, imageManager, 0, 0,
                inputManager, this);
        this.addKeyListener(inputManager);
        this.setFocusable(true);
    }

    @Override
    public void run(){

        double timePerFrame = 1000000000/60;
        double timePerUps = 1000000000/60;

        long lastFrame = System.nanoTime();
        long lastTimeUps = System.nanoTime();
        long lastTImeCheck = System.currentTimeMillis();

        int frams = 0;
        int updates = 0;

        while (true) {

            if (System.nanoTime() - lastFrame >= timePerFrame) {
                lastFrame = System.nanoTime();
                repaint();
                frams++;
            }

            if (System.nanoTime() - lastTimeUps >= timePerUps) {
                update();
                lastTimeUps = System.nanoTime();
                updates++;
            }

            if (System.currentTimeMillis() - lastTImeCheck >= 1000) {
                frams = 0;
                updates = 0;
                lastTImeCheck = System.currentTimeMillis();
            }
        }
    }

    private void update() {
        if (playerFactory != null) {
            playerFactory.update();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        playerFactory.draw(g);
    }
}
