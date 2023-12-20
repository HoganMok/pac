package org.example.manager;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ImageManager {
    BufferedImage image;
    public BufferedImage getImage(String name){
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(name)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public BufferedImage getSubImage(BufferedImage image, int xCoordinate, int yCoordinate, int width, int height){
        return image.getSubimage(xCoordinate, yCoordinate, 16, 16);
    }
}
