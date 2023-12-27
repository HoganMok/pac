package org.example.factory;

import org.example.Game;
import org.example.entity.Player;
import org.example.manager.ImageManager;
import org.example.manager.InputManager;

import java.awt.*;

public class PlayerFactory extends EntityFactory {
    public enum PlayerType {
        yellow
    }

    public Player player;
    public PlayerFactory (PlayerType playerType, ImageManager imageManagers, int xCoordinate, int yCoordinate,
                          InputManager inputManagers, Game games) {
        switch (playerType) {
            case yellow -> player = new Player(imageManagers, xCoordinate, yCoordinate, inputManagers,
                    games);
        }
    }

    public void update (Double deltaTime){
        player.update(deltaTime);
    }

    public void draw (Graphics g, Double deltaTime){
        player.draw(g, deltaTime);
    }
}
