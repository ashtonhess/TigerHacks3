package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.util.ResourceBundle;
/**
 * Author: Jacob
 */
public class createAccountFXMLController implements Initializable, PropertyChangeListener {

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

        String usernameInput = usernameTextField.getText();
        String passwordInput = passwordTextField.getText();
        Pair<Boolean, Pair<Integer,ResultSet>> databaseResult = new Pair<Boolean, Pair<Integer,ResultSet>>(false, new Pair<Integer, ResultSet>(0,null));




       // return new Pair<Boolean, Pair<Integer, ResultSet>>(false, new Pair<Integer, ResultSet>(0, null));

        databaseResult = databaseObj.executeQuery("");

        //This is the code to get information out of the databaseResult that is returned by DB.
        Boolean databaseBoolResult;
        Integer databaseRowsResult;
        ResultSet databaseResultSet;
        databaseBoolResult = databaseResult.getKey();
        databaseRowsResult = databaseResult.getValue().getKey();
        databaseResultSet = databaseResult.getValue().getValue();


        /*
        * //executeQuery function.
    //INPUTS: String: a query written exactly as it should be.
    //OUTPUTS: Boolean: if the query was successfully executed or not.
    //         Integer: the number of rows in the resulting set.
    //         ResultSet: the set that the query returned.
    public Pair<Boolean,Pair<Integer,ResultSet>> executeQuery(String queryString){
        Connection executeQueryConn = null;
//        Pair<Boolean,ResultSet> resultPair = new Pair(false,null);
        ResultSet executeQueryResult;
        Integer numRows;
        try{
            executeQueryConn = getConnection();
            if (this.connectionStatus(executeQueryConn)==true) {
                Statement stmt = executeQueryConn.createStatement();
                numRows= stmt.executeUpdate(queryString);
                executeQueryResult =  stmt.executeQuery(queryString);
                return new Pair<Boolean, Pair<Integer, ResultSet>>(true, new Pair<Integer, ResultSet>(numRows, executeQueryResult));
            }else{
                return new Pair<Boolean, Pair<Integer, ResultSet>>(false, new Pair<Integer, ResultSet>(0, null));
            }
        }catch(SQLException sqlExcept){
            System.out.println("getConnection() failed. Database error.");
            return new Pair<Boolean, Pair<Integer, ResultSet>>(false, new Pair<Integer, ResultSet>(0, null));
        }
    }
        *
        * */

        //ScreenController.activate("loginFXML");



    }

    @FXML
    void handleCancelPressed(ActionEvent event) {
        ScreenController.activate("loginFXML");

    }
}
