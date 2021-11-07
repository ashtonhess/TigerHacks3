package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Author: Jacob
 */
public class betsFXMLController implements Initializable, PropertyChangeListener {

    @FXML
    private Text activeBetsText;

    @FXML
    private Text betsText;

    @FXML
    private ListView<?> activeBetsListView;

    @FXML
    private ListView<?> closedBetsListView;

    @FXML
    private Text closedBetsText;

    @FXML
    private Button newBetButton;

    @FXML
    private Label userNameLabel;

    @FXML
    void homePressed(ActionEvent event) throws IOException {
        ScreenController.activate("mainPage");

    }

    @FXML
    void profilePressed(ActionEvent event) throws IOException {
        ScreenController.activate("userProfileFXML");

    }

    @FXML
    void friendsPressed(ActionEvent event) throws IOException {

        ScreenController.activate("friendsListFXML");

    }
    @FXML
    void addCoinsPressed(ActionEvent event) {

    }
    @FXML
    void requestsPressed(ActionEvent event) throws IOException {
        ScreenController.activate("betRequestsFXML");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        daModel = new loginFXMLModel();
//        daModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals("textToChangePropertyChangeID")) {
            //System.out.println("Some shit");
//            textToChange.setText((String)evt.getNewValue());
        }
    }

    @FXML
    void donePressed(ActionEvent event) throws IOException {

        //code

        ScreenController.addScreen("loginFXML", FXMLLoader.load(getClass().getResource("loginFXML.fxml")));
        ScreenController.activate("loginFXML");


    }
//    @FXML
//    private void handleDaButton(ActionEvent event) {
//        daModel.changeDaText();
//    }
}
