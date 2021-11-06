package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class betmeMain extends Application {


        @Override
        public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("homeFXML.fxml"));

            Scene scene = new Scene(root);

            ScreenController.main = scene;

            ScreenController.addScreen("homeFXML", FXMLLoader.load(getClass().getResource("homeFXML.fxml")));

    // USE THESE METHODS TO ADD MORE SCREENS TO SWITCH TO
            //ScreenController.addScreen("", FXMLLoader.load(getClass().getResource("")));
            //ScreenController.addScreen("", FXMLLoader.load(getClass().getResource("")));

            ScreenController.activate("homeFXML");

            stage.setScene(scene);
            stage.show();
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            launch(args);
        }
}
