package org.example;

import org.example.manager.JsonManager;
import org.json.JSONObject;

public class Level {
    JsonManager jsonManager;
    public Level(){
        jsonManager = new JsonManager();
        jsonManager.getJsonObject("/config/game.json");
    }
}
