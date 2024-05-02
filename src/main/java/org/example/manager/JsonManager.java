package org.example.manager;

import org.json.JSONObject;

import java.io.*;

public class JsonManager {
//    public InputStream readReourceInputStream(String filename){
//        return getClass().getClassLoader().getResourceAsStream(filename);
//    }
//    public static String readJSON(String filename){
//        StringBuilder json = new StringBuilder();
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                json.append(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return json.toString();
//    }
//
//    public JSONObject getJsonObject(String jsonStr) {
//        return new JSONObject(readJSON(jsonStr));
//        // Assume your JSON object looks like this: {"name":"John", "age":30}
//    }
    public JSONObject getJsonObject(String jsonStr) {
        return new JSONObject(jsonStr);
        // Assume your JSON object looks like this: {"name":"John", "age":30}
    }
}
