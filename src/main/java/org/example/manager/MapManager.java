package org.example.manager;

import org.example.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapManager {
    BufferedImage mapImage;
    ImageManager imageManager;
    Game game;
    public MapManager(ImageManager imageManagers, String filePath, Game games) {
        imageManager = imageManagers;
        game = games;
        mapImage = imageManager.getImage(filePath);
    }

    public void draw(Graphics g, int assetScale) {
        Graphics2D g2g = (Graphics2D) g;
        g2g.drawImage(mapImage,0,0, mapImage.getWidth()*assetScale,
                mapImage.getHeight()*assetScale, game);
    }
}
