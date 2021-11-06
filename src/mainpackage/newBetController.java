package mainpackage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class newBetController implements Initializable, PropertyChangeListener  {

        @FXML
        private TextField titleTextField;

        @FXML
        private Button placeBetButton;

        @FXML
        private TextField amountTextField;

        @FXML
        private ChoiceBox<?> verificationTypeChoiceBox;

        @FXML
        private TextField descriptionTextField;

        @FXML
        private ListView<?> friendsListView;

//        @FXML
//        void handlePlaceBetButton(ActionEvent event) {
//
//        }


        @Override
        public void propertyChange(PropertyChangeEvent evt) {

        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }
}
