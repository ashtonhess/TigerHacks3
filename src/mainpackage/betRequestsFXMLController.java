package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
/**
 * Author: Jacob
 */
public class betRequestsFXMLController implements Initializable, PropertyChangeListener {

    @FXML
    private Text betRequestsText;

    @FXML
    private ListView<Pane> betRequestsListView1;

    @FXML
    private ListView<Pane> friendRequestsListView;

    @FXML
    private Label coinBalLabel;

    @FXML
    private Label userNameLabel;

    @FXML
    void backPressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("mainPage", FXMLLoader.load(getClass().getResource("mainPage.fxml")));
        ScreenController.activate("mainPage");

    }

    @FXML
    void profilePressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("userProfileFXML", FXMLLoader.load(getClass().getResource("userProfileFXML.fxml")));
        ScreenController.activate("userProfileFXML");

    }

    @FXML
    void friendsPressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("friendsListFXML", FXMLLoader.load(getClass().getResource("friendsListFXML.fxml")));
        ScreenController.activate("friendsListFXML");

    }
    @FXML
    void addCoinsPressed(ActionEvent event) {

    }


    @FXML
    void acceptAllFriends(ActionEvent event) {

    }

    @FXML
    void declineAllFriends(ActionEvent event) {

    }


    @FXML
    void acceptAllBets(ActionEvent event) {

    }

    @FXML
    void declineAllBets(ActionEvent event) {

    }

    public ArrayList<Bet> userBets = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //use this method to create and array list of random bet objects
        for(int i= 0; i<10; i++){
            userBets.add(ranBet());
        }

        setUpListView();
        setUpListView2();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals("textToChangePropertyChangeID")) {
            //System.out.println("Some shit");
//            textToChange.setText((String)evt.getNewValue());
        }
    }

    //Use this to loop through array of bet object, creating a pane for the object and adding it to the list
    public void setUpListView() {


        for (Bet x : userBets) {
            Pane pane = new Pane();
            pane.setPrefSize(betRequestsListView1.getPrefWidth() * (0.85), (betRequestsListView1.getPrefHeight() / 4));
            Label label = new Label("test" + x.betAmount);
            Line line = new Line();
            line.setStartX(0);
            line.setStartY(0);
            line.setEndX(pane.getPrefWidth() * 1.15);
            line.setEndY(0);
            line.setStyle("-fx-stroke: lightgray");

            pane.getChildren().addAll(label, line);
            betRequestsListView1.getItems().add(pane);
        }
    }
    //Use this to loop through array of bet object, creating a pane for the object and adding it to the list
    public void setUpListView2() {

        for (Bet x : userBets) {
            Pane pane = new Pane();
            pane.setPrefSize(friendRequestsListView.getPrefWidth() * (0.85), (friendRequestsListView.getPrefHeight() / 4));
            Label label = new Label("test" + x.betAmount);
            Line line = new Line();
            line.setStartX(0);
            line.setStartY(0);
            line.setEndX(pane.getPrefWidth() * 1.15);
            line.setEndY(0);
            line.setStyle("-fx-stroke: lightgray");

            pane.getChildren().addAll(label, line);
            friendRequestsListView.getItems().add(pane);
        }
    }
    //Ran bet function to generate random bet objects for testing
    public Bet ranBet(){
        Random rand = new Random(); //instance of random class

        //generate random values from 0-24
        int ran = rand.nextInt()/10000000;
        System.out.println(ran);

        Bet randBet = new Bet("",ran,"","",false);
        return randBet;
    }
//    @FXML
//    private void handleDaButton(ActionEvent event) {
//        daModel.changeDaText();
//    }
}
