package mainpackage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
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
    private Button backButton;

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
