package mainpackage;

        import java.beans.PropertyChangeEvent;
        import java.beans.PropertyChangeListener;
        import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextArea;
        import javafx.scene.image.ImageView;
        import javafx.scene.text.Text;

/**
 * @author ashtonhess
 */
public class loginFXMLController implements Initializable, PropertyChangeListener {

    @FXML
    private Button createAccountButton;

    @FXML
    private ImageView image;

    @FXML
    private Button submitButton;

    @FXML
    private Text passwordText;

    @FXML
    private TextArea usernameTextArea;

    @FXML
    private Text usernameText;

    @FXML
    private TextArea passwordTextArea;


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
    void submitPress(ActionEvent event) throws IOException {
            ScreenController.addScreen("mainPage", FXMLLoader.load(getClass().getResource("mainPage.fxml")));
            ScreenController.activate("mainPage");

    }
    @FXML
    void createAccountPressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("createAccountFXML", FXMLLoader.load(getClass().getResource("createAccountFXML.fxml")));
        ScreenController.activate("createAccountFXML");

    }

//    @FXML
//    private void handleDaButton(ActionEvent event) {
//        daModel.changeDaText();
//    }
}
