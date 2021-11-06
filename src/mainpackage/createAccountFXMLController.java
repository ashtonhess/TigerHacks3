package mainpackage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class createAccountFXMLController implements Initializable, PropertyChangeListener {

    @FXML
    private TextField passwordTextField;

    @FXML
    private Text passwordText;

    @FXML
    private TextField emailTextField;

    @FXML
    private Text usernameText;

    @FXML
    private Text emailText;

    @FXML
    private Button doneButton;

    @FXML
    private TextField usernameTextField;

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
