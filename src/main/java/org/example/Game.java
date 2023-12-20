package org.example;

import org.example.entity.Player;
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
        this.addKeyListener(inputManager);
        this.setFocusable(true);
        player = new Player(imageManager, 0, 0, inputManager, this);
        if (player == null) {
            System.out.println("NULL");
        }
    }

    @Override
    public void run(){
        double drawInterval = 1000000000/60;
        double delta = 0;
        lastTime = System.nanoTime();
        long currentTime;
        while (gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    private void update() {
        if (player != null) {
            player.update();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.draw(g, this, lastTime);
    }


}
