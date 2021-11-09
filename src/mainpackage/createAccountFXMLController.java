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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
/**
 * Author: Jacob
 */
public class createAccountFXMLController extends AbstractDataController implements Initializable, PropertyChangeListener {

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
        
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals("textToChangePropertyChangeID")) {
            //System.out.println("Some shit");
//            textToChange.setText((String)evt.getNewValue());
        }
    }
//    @FXML
//    void handleCreateButton1(ActionEvent event) throws IOException {
//        /*
//        if(usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty() || usernameTextField.getText().length() >= 16 || usernameTextField.getText().length() <= 0) {
//            System.out.println("input error");
//        }
//        else{
//            boolean valid= false;
//
//        for(User x: userProfiles) {
//            if (x.userID.equals(usernameTextField.getText())) {
//                System.out.println("username taken");
//            } else {
//                userProfiles.add(new User(usernameTextField.getText(), passwordTextField.getText()));
//                System.out.println("account created");
//
//            }
//
//
//        }
//        if(valid){
//            //ScreenController.addScreen("loginFXML", FXMLLoader.load(getClass().getResource("loginFXML.fxml")));
//            ScreenController.activate("loginFXML");
//        }
//
//
//
//        }
//
//         */
//        //userProfiles.add(new User(usernameTextField.getText(), passwordTextField.getText()));
//        ScreenController.addScreen("loginFXML", FXMLLoader.load(getClass().getResource("loginFXML.fxml")));
//        ScreenController.activate("loginFXML");
//
//
//
//
//    }

    @FXML
    void handleCreateButton(ActionEvent event) throws IOException {

        //databaseObj.doExampleQuery("SELECT * FROM UserTable");
        Pair<Boolean, Pair<Integer, ArrayList<String>>> databaseResult;
//= new Pair<Boolean, Pair<Integer,ResultSet>>(false, new Pair<Integer, ResultSet>(0,null))
        Boolean databaseBoolResult;
        Integer databaseRowsResult;
        ArrayList<String> databaseResultSet;

        if(holderBool == false){
            String usernameInput = usernameTextField.getText();
            String passwordInput = passwordTextField.getText();
            if (usernameInput == "" || passwordInput == ""){
                Alert emptyInputAlert = new Alert(Alert.AlertType.ERROR);
                emptyInputAlert.setContentText("Please enter a valid username and password.");
                emptyInputAlert.showAndWait();
                holderBool = false;
            }else{

                databaseResult = databaseObj.executeQuery(constructCheckUserIDExistsQuery(usernameInput));

                databaseBoolResult = databaseResult.getKey();
                databaseRowsResult = databaseResult.getValue().getKey();
                databaseResultSet = databaseResult.getValue().getValue();
                System.out.println(databaseBoolResult);
                System.out.println(databaseRowsResult);
                //System.out.println(databaseResultSet);
                if (databaseBoolResult == false){
                    Alert boolResultFalseAlert = new Alert(Alert.AlertType.ERROR);
                    boolResultFalseAlert.setContentText("There was an error executing query. Check DB connection.");
                    boolResultFalseAlert.showAndWait();
                }else{

                        if (databaseResultSet.isEmpty()){
                            //this means that another user with that username DOES NOT exist.
                            //continue to add new user to database.

                            //Create a new row in UserTable
                            databaseObj.executeUpdate(constructNewUserQuery(usernameInput, passwordInput));
                            //Create a new row in Portfolio Table for the new User
                            databaseObj.executeUpdate(constructNewPortfolioQuery(usernameInput));

                            //Print result and let user know they have been added and a portfolio was created for them.
                            System.out.println("New user: "+usernameInput+" added to UserTable and Portfolio initialized.");
                            Alert emptyInputAlert = new Alert(Alert.AlertType.CONFIRMATION);
                            emptyInputAlert.setContentText("New user: "+usernameInput+" added to UserTable and Portfolio initialized.");
                            emptyInputAlert.showAndWait();
                            ScreenController.activate("loginFXML");
                        }else{
                            Alert usernameTaken = new Alert(Alert.AlertType.INFORMATION);
                            usernameTaken.setContentText("Sorry, this username is taken. Please try another.");
                            usernameTaken.showAndWait();

                        }

                }

            }
        }


        // return new Pair<Boolean, Pair<Integer, ResultSet>>(false, new Pair<Integer, ResultSet>(0, null));

        //databaseResult = databaseObj.executeQuery("");

        //This is the code to get information out of the databaseResult that is returned by DB.
        //ScreenController.activate("loginFXML");
    }

    public String constructCheckUserIDExistsQuery(String usernameInput){
        String constructCheckUserIdExistsQueryString = "SELECT * FROM UserTable WHERE userID = '"+usernameInput+"';";
        return constructCheckUserIdExistsQueryString;
    }
    public String constructNewUserQuery(String usernameInput, String passwordInput){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateString = formatter.format(new Date());
        String constructNewUserQueryString = "INSERT INTO UserTable (userID, userPassword, userDateCreated)\n"
                +"VALUES ('"+usernameInput+"', '"+passwordInput+"', '"+dateString+"');";
        return constructNewUserQueryString;
    }
    public String constructNewPortfolioQuery(String usernameInput){
        String constructNewPortfolioQuery = "INSERT INTO Portfolio (userID, portfolioBalance, portfolioTotalReturns)\n"
                +"VALUES ('"+usernameInput+"', 0, 0);";
        return constructNewPortfolioQuery;
    }

    @FXML
    void handleCancelPressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("loginFXML", FXMLLoader.load(getClass().getResource("loginFXML.fxml")));
        ScreenController.activate("loginFXML");
    }

}
