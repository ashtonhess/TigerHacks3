package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Pair;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
/**
 * Author: Jacob
 */
public class createAccountFXMLController implements Initializable, PropertyChangeListener {

    Boolean holderBool = false;

    public daDatabase databaseObj = new daDatabase();

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button createButton;

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

    @FXML
    void handleCreateButton(ActionEvent event) throws IOException {




        Pair<Boolean, Pair<Integer,ResultSet>> databaseResult = new Pair<Boolean, Pair<Integer,ResultSet>>(false, new Pair<Integer, ResultSet>(0,null));

        Boolean databaseBoolResult;
        Integer databaseRowsResult;
        ResultSet databaseResultSet;

        if(holderBool == false){
            String usernameInput = usernameTextField.getText();
            String passwordInput = passwordTextField.getText();
            if (usernameInput == "" | passwordInput == ""){
                Alert emptyInputAlert = new Alert(Alert.AlertType.ERROR);
                emptyInputAlert.setContentText("Please enter a valid username and password.");
                emptyInputAlert.showAndWait();
                holderBool = false;
            }else{
                databaseResult = databaseObj.executeQuery(constructCheckUserIDExistsQuery(usernameInput));
                databaseBoolResult = databaseResult.getKey();
                databaseRowsResult = databaseResult.getValue().getKey();
                databaseResultSet = databaseResult.getValue().getValue();
                if (databaseBoolResult == false){
                    Alert boolResultFalseAlert = new Alert(Alert.AlertType.ERROR);
                    boolResultFalseAlert.setContentText("There was an error executing query. Check DB connection.");
                    boolResultFalseAlert.showAndWait();
                }else{
                    try {
                        if (databaseResultSet.next() == false){
                            //this means that another user with that username DOES NOT exist.
                            //continue to add new user to database.


                            //left off
                            //committing these now...

                            databaseResult = databaseObj.executeQuery(constructNewUserQuery(usernameInput, passwordInput));
                            System.out.println("New user: "+usernameInput+" has been added to the UserTable.");
                            Alert emptyInputAlert = new Alert(Alert.AlertType.CONFIRMATION);
                            emptyInputAlert.setContentText("New user: "+usernameInput+" has been added to the UserTable.");
                            emptyInputAlert.showAndWait();
                            ScreenController.activate("loginFXML");
                        }else{
                            Alert usernameTaken = new Alert(Alert.AlertType.INFORMATION);
                            usernameTaken.setContentText("Sorry, this username is taken. Please try another.");
                            usernameTaken.showAndWait();

                        }
                    } catch (SQLException e) {
                        System.out.println("DATABASE ERROR. createAccountFXMLController.java @ handleCreateButton");
                        e.printStackTrace();
                    }
                }

            }
        }




        // return new Pair<Boolean, Pair<Integer, ResultSet>>(false, new Pair<Integer, ResultSet>(0, null));

        databaseResult = databaseObj.executeQuery("");

        //This is the code to get information out of the databaseResult that is returned by DB.




        //ScreenController.activate("loginFXML");

    }

    public String constructCheckUserIDExistsQuery(String usernameInput){
        String constructCheckUserIdExistsQueryString = "SELECT * FROM UserTable WHERE userID = '"+usernameInput+"';";
        return constructCheckUserIdExistsQueryString;
    }
    public String constructNewUserQuery(String usernameInput, String passwordInput){
        String constructNewUserQueryString = "INSERT INTO User (userID, userPassword, userDateCreated)\n" +
                "VALUES ('"+usernameInput+"', '"+passwordInput+"', '03/16/2001 08:42:09');";

        return constructNewUserQueryString;
    }

    @FXML
    void handleCancelPressed(ActionEvent event) {
        ScreenController.activate("loginFXML");
    }

}
