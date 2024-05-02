package org.example.manager;

import org.example.Game;
import org.example.HitBox;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapManager {
    BufferedImage mapImage;
    ImageManager imageManager;
    Game game;
    List<HitBox> hitBoxList;
    private final int ASSET_SIZE = 3;
    public MapManager(ImageManager imageManagers, String filePath, Game games) {
        imageManager = imageManagers;
        game = games;
        mapImage = imageManager.getImage(filePath);
        hitBoxList = new ArrayList<>();
        hitBoxSetUp();
    }
    private void hitBoxSetUp(){
//        hitBoxList.add(new HitBox(0,0,4*ASSET_SIZE,244*ASSET_SIZE));
//        hitBoxList.add(new HitBox(4*ASSET_SIZE, 240*ASSET_SIZE, 220*ASSET_SIZE, 4*ASSET_SIZE));
//        hitBoxList.add(new HitBox(4*ASSET_SIZE, 0, 220*ASSET_SIZE, 4*ASSET_SIZE));
//        hitBoxList.add(new HitBox(220*ASSET_SIZE,4*ASSET_SIZE, 4*ASSET_SIZE, 236*ASSET_SIZE));
//        squareHitBox(0,100);
//        squareHitBox(200,100);
//        squareHitBox(20,20);
//        squareHitBox(20,200);
//        squareHitBox(180,20);
//        squareHitBox(180,200);
//        squareHitBox(80,120);
//        squareHitBox(120,120);
//        squareHitBox(100,180);
//        pShapeHitBox(20,40,60);
//        pShapeHitBox(184,160,60);
//        pShapeHitBox(84, 60, 140);
//        pShapeHitBox(120,140,140);

        hitBoxList.add(new HitBox(0,0,224*ASSET_SIZE,4*ASSET_SIZE));

        hitBoxList.add(new HitBox(0,4*ASSET_SIZE,4*ASSET_SIZE,100*ASSET_SIZE));
        hitBoxList.add(new HitBox(4*ASSET_SIZE, 100*ASSET_SIZE,20*ASSET_SIZE,4*ASSET_SIZE));
        hitBoxList.add(new HitBox(0,120*ASSET_SIZE,4*ASSET_SIZE, 120*ASSET_SIZE));
        hitBoxList.add(new HitBox(4*ASSET_SIZE,120*ASSET_SIZE,20*ASSET_SIZE,4*ASSET_SIZE));

        hitBoxList.add(new HitBox(220*ASSET_SIZE, 4*ASSET_SIZE, 4*ASSET_SIZE,100*ASSET_SIZE));
        hitBoxList.add(new HitBox(200*ASSET_SIZE, 100*ASSET_SIZE, 20*ASSET_SIZE,4*ASSET_SIZE));
        hitBoxList.add(new HitBox(220*ASSET_SIZE,120*ASSET_SIZE,4*ASSET_SIZE, 120*ASSET_SIZE));
        hitBoxList.add(new HitBox(200*ASSET_SIZE,120*ASSET_SIZE,20*ASSET_SIZE,4*ASSET_SIZE));

        hitBoxList.add(new HitBox(0,240*ASSET_SIZE,224*ASSET_SIZE,4*ASSET_SIZE));

        hitBoxList.add(new HitBox(20*ASSET_SIZE,20*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));
        hitBoxList.add(new HitBox(40*ASSET_SIZE,20*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));

        hitBoxList.add(new HitBox(60*ASSET_SIZE,20*ASSET_SIZE,44*ASSET_SIZE,4*ASSET_SIZE));
        hitBoxList.add(new HitBox(120*ASSET_SIZE,20*ASSET_SIZE,44*ASSET_SIZE,4*ASSET_SIZE));
        hitBoxList.add(new HitBox(60*ASSET_SIZE,40*ASSET_SIZE,104*ASSET_SIZE,4*ASSET_SIZE));

        hitBoxList.add(new HitBox(180*ASSET_SIZE,20*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));
        hitBoxList.add(new HitBox(200*ASSET_SIZE,20*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));

    }

    public void draw(Graphics g, int assetScale) {
        Graphics2D g2g = (Graphics2D) g;
        g2g.drawImage(mapImage,0,0, mapImage.getWidth()*assetScale,
                mapImage.getHeight()*assetScale, game);
        for (HitBox hitBox : hitBoxList) {
            hitBox.drawHitBox(g);
        }
    }
}
