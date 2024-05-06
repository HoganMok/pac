package org.example.factory;

import org.example.CollisionDetection;
import org.example.Game;
import org.example.HitBox;
import org.example.entity.Player;
import org.example.manager.ImageManager;
import org.example.manager.InputManager;

import java.awt.*;
import java.util.List;

public class PlayerFactory extends EntityFactory {
    public enum PlayerType {
        yellow
    }

    public Player player;
    public PlayerFactory (PlayerType playerType, ImageManager imageManagers, int playerXCoordinate, int playerYCoordinate,
                          InputManager inputManagers, Game games, CollisionDetection collisionDetection,
                          List<HitBox> boardHitBoxList) {
        switch (playerType) {
            case yellow -> player = new Player(imageManagers, playerXCoordinate, playerYCoordinate, inputManagers,
                    games, collisionDetection, boardHitBoxList);
        }
    }
    public void update (double deltaTime){
        player.update(deltaTime);
    }
    public void draw (Graphics g, double deltaTime, int assetScale){
        player.draw(g, deltaTime, assetScale);
    }
    public Player getPlayer() {return player;}
}
