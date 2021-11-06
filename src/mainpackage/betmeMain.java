package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class betmeMain extends Application {


        @Override
        public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));

            Scene scene = new Scene(root);

            ScreenController.main = scene;

            ScreenController.addScreen("loginFXML", FXMLLoader.load(getClass().getResource("loginFXML.fxml")));
            ScreenController.addScreen("newBetFXML", FXMLLoader.load(getClass().getResource("newBetFXML.fxml")));
            ScreenController.addScreen("mainPage", FXMLLoader.load(getClass().getResource("mainPage.fxml")));
            ScreenController.addScreen("createAccountFXML", FXMLLoader.load(getClass().getResource("createAccountFXML.fxml")));
            ScreenController.addScreen("userProfileFXML", FXMLLoader.load(getClass().getResource("userProfileFXML.fxml")));
            ScreenController.addScreen("friendsListFXML", FXMLLoader.load(getClass().getResource("friendsListFXML.fxml")));



            // USE THESE METHODS TO ADD MORE SCREENS TO SWITCH TO
            //ScreenController.addScreen("", FXMLLoader.load(getClass().getResource("")));
            //ScreenController.addScreen("", FXMLLoader.load(getClass().getResource("")));

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
