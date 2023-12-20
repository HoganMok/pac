package org.example.sprite;

import org.example.manager.ImageManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimatedSprite implements Sprite {
    public enum spriteType {
        player,
        enemy
    }

    private BufferedImage[] imagesList;
    private BufferedImage image;

    public AnimatedSprite(spriteType SpriteType, ImageManager imageManager, int imageNumbers, String filePath) {
        //switch case for different spriteType
        imagesList = new BufferedImage[imageNumbers];
        image = imageManager.getImage(filePath);
        setBufferedImageList(imageManager, filePath, imageNumbers);
    }

    @Override
    public void draw(Graphics g) {
    }

    private void setBufferedImageList (ImageManager imageManager, String filePath, int imageNumbers){
        for (int i = 0; i < imageNumbers; i++) {
            imagesList[i] = imageManager.getSubImage(image, i+i*16, 0, 16, 16);
        }
    }

    public BufferedImage[] getImagesList(){return imagesList;}

    public void getImagesListSize(){System.out.println(imagesList.length);}
}
