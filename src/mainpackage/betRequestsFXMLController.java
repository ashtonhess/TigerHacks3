package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Author: Jacob
 */
public class betRequestsFXMLController implements Initializable, PropertyChangeListener {

    @FXML
    private Text betRequestsText;

    @FXML
    private ListView<?> betRequestsListView;

    @FXML
    private Button backButton;

    @FXML
    private CheckBox noCheckBox;

    @FXML
    private CheckBox yesCheckBox;

    @FXML
    private Text betRequestsDescriptionText;

    @FXML
    private Label coinBalLabel;

    @FXML
    private Label userNameLabel;



    @FXML
    void backPressed(ActionEvent event) throws IOException {
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
    void acceptAllFriends(ActionEvent event) {

    }

    @FXML
    void declineAllFriends(ActionEvent event) {

    }


    @FXML
    void acceptAllBets(ActionEvent event) {

    }

    @FXML
    void declineAllBets(ActionEvent event) {

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
//    @FXML
//    private void handleDaButton(ActionEvent event) {
//        daModel.changeDaText();
//    }
}
