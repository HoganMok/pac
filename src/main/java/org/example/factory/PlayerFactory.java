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
    public PlayerFactory (PlayerType playerType, ImageManager imageManagers, int playerXCoordinate, int playerYCoordinate,
                          InputManager inputManagers, Game games) {
        switch (playerType) {
            case yellow -> player = new Player(imageManagers, playerXCoordinate, playerYCoordinate, inputManagers,
                    games);
        }
    }

    public void update (double deltaTime){
        player.update(deltaTime);
    }

    public void draw (Graphics g, double deltaTime){
        player.draw(g, deltaTime);
    }
}
