package mainpackage;

        import java.beans.PropertyChangeEvent;
        import java.beans.PropertyChangeListener;
        import java.io.IOException;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.ResourceBundle;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.control.*;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.KeyCode;
        import javafx.scene.input.KeyEvent;
        import javafx.scene.text.Text;
        import javafx.util.Pair;

/**
 * @author ashtonhess
 */
public class loginFXMLController extends AbstractDataController implements Initializable, PropertyChangeListener {

    @FXML
    private Button createAccountButton;

    @FXML
    private ImageView image;

    @FXML
    private Button submitButton;

    @FXML
    private Text passwordText;

    @FXML
    private TextField usernameTextArea;
    @FXML
    private PasswordField passwordTextArea;

    @FXML
    void enterClicked(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER){

        }

    }
    @FXML
    private Text usernameText;

    public daDatabase databaseObj = new daDatabase();

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
        if(true) {
            loginSuccess();
        }else {
            if (verifyLogin()) {
                loginSuccess();
            } else {
//            Alert failedLoginAlert = new Alert(Alert.AlertType.ERROR);
//            failedLoginAlert.setContentText("Failed to login. Please check connection and credentials and try again.");
//            failedLoginAlert.showAndWait();
            }

        }

    }

    public Boolean verifyLogin(){


        Pair<Boolean, Pair<Integer, ArrayList<String>>> databaseResult;
        Boolean databaseBoolResult;
        Integer databaseRowsResult;
        ArrayList<String> databaseResultSet;

        if(true){
            String usernameInput = usernameTextArea.getText();
            String passwordInput = passwordTextArea.getText();
            if (usernameInput == "" || passwordInput == ""){
                Alert emptyInputAlert = new Alert(Alert.AlertType.ERROR);
                emptyInputAlert.setContentText("Please enter a valid username and password.");
                emptyInputAlert.showAndWait();
                //holderBool = false;
            }else{

                databaseResult = databaseObj.executeQuery(constructCheckUserIDPasswordQuery(usernameInput, passwordInput));

                databaseBoolResult = databaseResult.getKey();
                databaseRowsResult = databaseResult.getValue().getKey();
                databaseResultSet = databaseResult.getValue().getValue();
                System.out.println(databaseBoolResult);
                System.out.println(databaseRowsResult);

                if (databaseBoolResult == false){
                    Alert boolResultFalseAlert = new Alert(Alert.AlertType.ERROR);
                    boolResultFalseAlert.setContentText("There was an error executing query. Check DB connection.");
                    boolResultFalseAlert.showAndWait();
                }else{
                    if (databaseResultSet.isEmpty()){
                        //this means that a user with that username and password DOES NOT exist.
                        //Tells user that username and password are incorrect.
                        System.out.println("Incorrect username and password.");
                        Alert emptyInputAlert = new Alert(Alert.AlertType.CONFIRMATION);
                        emptyInputAlert.setContentText("Incorrect username and password.");
                        emptyInputAlert.showAndWait();
                        //exit
                    }else{
                        //Send to main page, login was successful.
                        return true;
                    }

                }

            }
        }


        return false;
    }

    public String constructCheckUserIDPasswordQuery(String usernameInput, String passwordInput){
        String constructCheckUserIDPassword = "SELECT * FROM UserTable WHERE '"+usernameInput+"' = userID AND '"+passwordInput+"' = userPassword;";
        return constructCheckUserIDPassword;
    }

    public void loginSuccess() throws IOException {
        ScreenController.addScreen("mainPage", FXMLLoader.load(getClass().getResource("mainPage.fxml")));
        ScreenController.activate("mainPage");
    }
    public void submit() throws IOException {
        if(userProfile == null){
            userProfile = (new User("test", ""));
        }


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
