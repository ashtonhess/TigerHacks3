package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class betmeMain extends Application {


        @Override
        public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));

            Scene scene = new Scene(root);

            ScreenController.main = scene;
    // USE THESE METHODS TO ADD MORE SCREENS TO SWITCH TO
            ScreenController.addScreen("loginFXML", FXMLLoader.load(getClass().getResource("loginFXML.fxml")));
            ScreenController.addScreen("newBetFXML", FXMLLoader.load(getClass().getResource("newBetFXML.fxml")));
            ScreenController.addScreen("userProfileFXML", FXMLLoader.load(getClass().getResource("userProfileFXML.fxml")));

    //Activating the login screen.
            ScreenController.activate("loginFXML");

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
