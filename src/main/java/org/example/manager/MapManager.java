package org.example.manager;

import org.example.Game;
import org.example.HitBox;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class MapManager {
    BufferedImage mapImage;
    ImageManager imageManager;
    Game game;
    List<HitBox> boardHitBoxList;
    private final int ASSET_SIZE = 3;
    public MapManager(ImageManager imageManagers, String filePath, Game games) {
        imageManager = imageManagers;
        game = games;
        mapImage = imageManager.getImage(filePath);
        boardHitBoxList = new ArrayList<>();
        hitBoxSetUp();
    }
    private void hitBoxSetUp(){
        boardHitBoxList.add(new HitBox(0,0,224*ASSET_SIZE,4*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(0,4*ASSET_SIZE,4*ASSET_SIZE,100*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(4*ASSET_SIZE, 100*ASSET_SIZE,20*ASSET_SIZE,4*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(0,120*ASSET_SIZE,4*ASSET_SIZE, 120*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(4*ASSET_SIZE,120*ASSET_SIZE,20*ASSET_SIZE,4*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(220*ASSET_SIZE, 4*ASSET_SIZE, 4*ASSET_SIZE,100*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(200*ASSET_SIZE, 100*ASSET_SIZE, 20*ASSET_SIZE,4*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(220*ASSET_SIZE,120*ASSET_SIZE,4*ASSET_SIZE, 120*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(200*ASSET_SIZE,120*ASSET_SIZE,20*ASSET_SIZE,4*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(0,240*ASSET_SIZE,224*ASSET_SIZE,4*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(20*ASSET_SIZE,20*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(40*ASSET_SIZE,20*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(60*ASSET_SIZE,20*ASSET_SIZE,44*ASSET_SIZE,4*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(120*ASSET_SIZE,20*ASSET_SIZE,44*ASSET_SIZE,4*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(60*ASSET_SIZE,40*ASSET_SIZE,104*ASSET_SIZE,4*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(20*ASSET_SIZE,60*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(40*ASSET_SIZE,60*ASSET_SIZE,24*ASSET_SIZE,4*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(40*ASSET_SIZE,80*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(60*ASSET_SIZE,64*ASSET_SIZE,4*ASSET_SIZE,40*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(40*ASSET_SIZE,120*ASSET_SIZE,24*ASSET_SIZE,4*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(80*ASSET_SIZE,60*ASSET_SIZE,24*ASSET_SIZE,4*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(120*ASSET_SIZE,60*ASSET_SIZE,24*ASSET_SIZE,4*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(80*ASSET_SIZE,64*ASSET_SIZE,4*ASSET_SIZE,40*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(84*ASSET_SIZE,100*ASSET_SIZE,56*ASSET_SIZE,4*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(140*ASSET_SIZE,64*ASSET_SIZE,4*ASSET_SIZE,40*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(160*ASSET_SIZE,64*ASSET_SIZE,4*ASSET_SIZE,40*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(160*ASSET_SIZE,60*ASSET_SIZE,24*ASSET_SIZE,4*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(200*ASSET_SIZE,60*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(180*ASSET_SIZE,80*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(160*ASSET_SIZE,120*ASSET_SIZE,24*ASSET_SIZE,4*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(80*ASSET_SIZE,120*ASSET_SIZE,24*ASSET_SIZE,24*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(120*ASSET_SIZE,120*ASSET_SIZE,24*ASSET_SIZE,24*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(20*ASSET_SIZE,140*ASSET_SIZE,4*ASSET_SIZE,44*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(40*ASSET_SIZE,140*ASSET_SIZE,4*ASSET_SIZE,44*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(60*ASSET_SIZE,140*ASSET_SIZE,4*ASSET_SIZE,64*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(80*ASSET_SIZE,160*ASSET_SIZE,24*ASSET_SIZE,4*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(80*ASSET_SIZE,164*ASSET_SIZE,4*ASSET_SIZE,40*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(120*ASSET_SIZE,160*ASSET_SIZE,24*ASSET_SIZE,4*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(140*ASSET_SIZE,164*ASSET_SIZE,4*ASSET_SIZE,40*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(160*ASSET_SIZE,140*ASSET_SIZE,4*ASSET_SIZE,64*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(100*ASSET_SIZE,180*ASSET_SIZE,24*ASSET_SIZE,4*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(100*ASSET_SIZE,184*ASSET_SIZE,4*ASSET_SIZE,20*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(120*ASSET_SIZE,184*ASSET_SIZE,4*ASSET_SIZE,20*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(180*ASSET_SIZE,140*ASSET_SIZE,4*ASSET_SIZE,44*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(200*ASSET_SIZE,140*ASSET_SIZE,4*ASSET_SIZE,44*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(20*ASSET_SIZE,200*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(40*ASSET_SIZE,200*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(180*ASSET_SIZE,200*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(200*ASSET_SIZE,200*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(60*ASSET_SIZE,220*ASSET_SIZE,44*ASSET_SIZE,4*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(120*ASSET_SIZE,220*ASSET_SIZE,44*ASSET_SIZE,4*ASSET_SIZE));

        boardHitBoxList.add(new HitBox(180*ASSET_SIZE,20*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));
        boardHitBoxList.add(new HitBox(200*ASSET_SIZE,20*ASSET_SIZE,4*ASSET_SIZE,24*ASSET_SIZE));

    }

    public void draw(Graphics g, int assetScale) {
        Graphics2D g2g = (Graphics2D) g;
        g2g.drawImage(mapImage,0,0, mapImage.getWidth()*assetScale,
                mapImage.getHeight()*assetScale, game);
        for (HitBox hitBox : boardHitBoxList) {
            hitBox.drawHitBox(g);
        }
    }
}
