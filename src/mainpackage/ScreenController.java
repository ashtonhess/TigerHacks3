package mainpackage;

import java.util.HashMap;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public abstract class ScreenController {

    public static HashMap<String, Pane> screenMap = new HashMap<>();
    public static Scene main;

    public static void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }
    public static void removeScreen(String name){
        screenMap.remove(name);

    }
    public static void activate(String name){
        main.setRoot(screenMap.get(name));

    }
}
