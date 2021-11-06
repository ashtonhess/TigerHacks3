package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class newBetController implements Initializable, PropertyChangeListener {

    @FXML
    private Label targetName;

    @FXML
    private TextField amountTextField;

    @FXML
    private Label userNameLabel;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private Label coinBalLabel;

    @FXML
    private ImageView coinImage;

    @FXML
    private ListView<?> friendsListView;



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
    void friendsPressed(ActionEvent event) throws IOException {

        ScreenController.activate("friendsListFXML");

    }
    @FXML
    void addCoinsPressed(ActionEvent event) {

    }

    @FXML
    void betConfirmPressed(ActionEvent event) throws IOException{
        ScreenController.activate("mainPage");

    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
