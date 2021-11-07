package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * Author: Jacob
 */
public class userProfileFXMLController implements Initializable, PropertyChangeListener {

    @FXML
    private Text accountBalText;

    @FXML
    private Button friendRequestsButton;

    @FXML
    private ListView<?> friendsListListView;

    @FXML
    private ImageView userPicImageView;

    @FXML
    private Text friendsListText;

    @FXML
    private Text totalMoneyText;

    @FXML
    private Text closedBetsText;

    @FXML
    private Circle userPicBorderCircle;

    @FXML
    private Text usernameText;

    @FXML
    private Button betRequestsButton;

    @FXML
    private Text activeBetsText;

    @FXML
    private ListView<?> activeBetsListView;

    @FXML
    private ListView<?> closedBetsListView;

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
    void friendsPressed(ActionEvent event) throws IOException {

        ScreenController.activate("friendsListFXML");

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