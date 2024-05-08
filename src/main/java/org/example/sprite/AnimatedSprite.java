package org.example.sprite;

import org.example.manager.ImageManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AnimatedSprite implements Sprite {
    public enum spriteType {
        player,
        enemy,
        boost
    }

    private List<BufferedImage> imagesList;
    private BufferedImage image;

    public AnimatedSprite(ImageManager imageManager, int imageNumbers, String filePath,
                          int xCoordinate, int yCoordinate, int width, int height) {
        //switch case for different spriteType
        imagesList = new ArrayList<>();
//                BufferedImage[imageNumbers];
        image = imageManager.getImage(filePath);
        setBufferedImageList(imageManager, filePath, imageNumbers, xCoordinate, yCoordinate, width, height);
    }

    @Override
    public void draw(Graphics g) {
    }

    private void setBufferedImageList (ImageManager imageManager, String filePath, int imageNumbers,
                                       int xCoordinate, int yCoordinate, int width, int height){
        for (int i = 0; i < imageNumbers; i++) {
            imagesList.add(imageManager.getSubImage(image, xCoordinate+i+i*16, yCoordinate, width, height));
            //imagesList[i] = imageManager.getSubImage(image, i+i*16, 0, 16, 16);
        }
    }

    public List<BufferedImage> getImagesList(){return imagesList;}
    public List<BufferedImage> getImagesSubList(int start, int end){ return imagesList.subList(start,end);}

    public void getImagesListSize(){System.out.println(imagesList.size());}
}
