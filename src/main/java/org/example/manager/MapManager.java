package org.example.manager;

import org.example.Game;
import org.example.HitBox;
import org.example.factory.BoostFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class MapManager {
    private BufferedImage mapImage;
    private ImageManager imageManager;
    private Game game;
    private List<HitBox> boardHitBoxList;
    private final int ASSET_SIZE = 3;
    private BoostFactory boostFactory;
    public MapManager(ImageManager imageManagers, String filePath, Game games) {
        imageManager = imageManagers;
        game = games;
        mapImage = imageManager.getImage(filePath);
        boardHitBoxList = new ArrayList<>();
    }
    public void mapSetUp(){
        hitBoxSetUp();
        initialCoinsSetUp();
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

    private void initialCoinsSetUp(){
        boostFactory = game.getBoostFactory();
        for (int i = 10; i < 216; i+=10) {
            boostFactory.createBoost(BoostFactory.boostType.coin, i*ASSET_SIZE, 10*ASSET_SIZE);
            boostFactory.createBoost(BoostFactory.boostType.coin, i*ASSET_SIZE, 50*ASSET_SIZE);
        }for (int i = 10; i < 100; i+=10) {
            boostFactory.createBoost(BoostFactory.boostType.coin, 10*ASSET_SIZE, i*ASSET_SIZE);
            boostFactory.createBoost(BoostFactory.boostType.coin, 210*ASSET_SIZE, i*ASSET_SIZE);
        }for (int i = 10; i < 50; i+=10) {
           boostFactory.createBoost(BoostFactory.boostType.coin, 50*ASSET_SIZE, i*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, 170*ASSET_SIZE, i*ASSET_SIZE);
        }for (int i = 60; i < 140; i+=10){
           boostFactory.createBoost(BoostFactory.boostType.coin, 70*ASSET_SIZE, i*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, 150*ASSET_SIZE, i*ASSET_SIZE);
        }for (int i = 100; i < 140; i+=10){
           boostFactory.createBoost(BoostFactory.boostType.coin, 30*ASSET_SIZE, i*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, 190*ASSET_SIZE, i*ASSET_SIZE);
        }for (int i = 80; i < 150; i+=10){
           boostFactory.createBoost(BoostFactory.boostType.coin, i*ASSET_SIZE, 110*ASSET_SIZE);
        }for (int i = 0; i < 20; i+=10){
           boostFactory.createBoost(BoostFactory.boostType.coin, (20+i)*ASSET_SIZE, 90*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, (190+i)*ASSET_SIZE, 90*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, (10+i)*ASSET_SIZE, 130*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, (200+i)*ASSET_SIZE, 130*ASSET_SIZE);
        }for (int i = 0; i < 30; i+=10){
           boostFactory.createBoost(BoostFactory.boostType.coin, (40+i)*ASSET_SIZE, 130*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, (160+i)*ASSET_SIZE, 130*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, (20+i)*ASSET_SIZE, 190*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, (180+i)*ASSET_SIZE, 190*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, (20+i)*ASSET_SIZE, 230*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, (180+i)*ASSET_SIZE, 230*ASSET_SIZE);
        }for (int i = 140; i <240; i+=10){
           boostFactory.createBoost(BoostFactory.boostType.coin, 10*ASSET_SIZE, i*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, 50*ASSET_SIZE, i*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, 170*ASSET_SIZE, i*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, 210*ASSET_SIZE, i*ASSET_SIZE);
        }for (int i = 120; i < 170; i+=10){
           boostFactory.createBoost(BoostFactory.boostType.coin, 110*ASSET_SIZE, i*ASSET_SIZE);
        }for (int i = 170; i < 210; i+=10){
           boostFactory.createBoost(BoostFactory.boostType.coin, 90*ASSET_SIZE, i*ASSET_SIZE);
           boostFactory.createBoost(BoostFactory.boostType.coin, 130*ASSET_SIZE, i*ASSET_SIZE);
        }for (int i = 60; i < 170; i+=10){
           boostFactory.createBoost(BoostFactory.boostType.coin, i*ASSET_SIZE, 210*ASSET_SIZE);
        }
    }

    public void draw(Graphics g, int assetScale) {
        Graphics2D g2g = (Graphics2D) g;
        g2g.drawImage(mapImage,0,0, mapImage.getWidth()*assetScale,
                mapImage.getHeight()*assetScale, game);
        for (HitBox hitBox : boardHitBoxList) {
            hitBox.drawHitBox(g);
        }
    }
    public List<HitBox> getBoardHitBoxList(){return boardHitBoxList;}
}
