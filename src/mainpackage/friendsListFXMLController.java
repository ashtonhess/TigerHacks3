package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
/**
 * Author: Jacob
 */
public class friendsListFXMLController implements Initializable, PropertyChangeListener {

    @FXML
    private Button betButton;

    @FXML
    private Text addFriendsText;

    @FXML
    private ListView<?> addFriendsListView;

    @FXML
    private ListView<?> inviteLinkListView;

    @FXML
    private ListView<?> friendsListListView;

    @FXML
    private Text friendsListText;

    @FXML
    private Text inviteLinkTextarr;

    @FXML
    private Label coinBalLabel;

    @FXML
    private Label userNameLabel;

    @FXML
    void backPressed(ActionEvent event) throws IOException {
        ScreenController.activate("mainPage");

    }
    @FXML
    void requestsPressed(ActionEvent event) throws IOException {
        ScreenController.activate("betRequestsFXML");

    }

    @FXML
    void profilePressed(ActionEvent event) throws IOException {
       ScreenController.activate("userProfileFXML");

    }


    @FXML
    void addCoinsPressed(ActionEvent event) {

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
