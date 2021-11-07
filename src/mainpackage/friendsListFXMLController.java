package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;
/**
 * Author: Jacob
 */
public class friendsListFXMLController implements Initializable, PropertyChangeListener {

    @FXML
    private ListView<Pane> friendsListListView;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label resultNumberLabel;

    @FXML
    private Label coinBalLabel;

    @FXML
    private ListView<Pane> searchResultList;

    @FXML
    private ImageView coinImage;

    @FXML
    private TextField usernameTextField;

    public ArrayList<Bet> userBets = new ArrayList<>();

    @FXML
    void searchPressed(ActionEvent event) {

    }

    @FXML
    void backPressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("mainPage", FXMLLoader.load(getClass().getResource("mainPage.fxml")));
        ScreenController.activate("mainPage");

    }
    @FXML
    void requestsPressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("betRequestsFXML", FXMLLoader.load(getClass().getResource("betRequestsFXML.fxml")));
        ScreenController.activate("betRequestsFXML");
    }

    @FXML
    void profilePressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("userProfileFXML", FXMLLoader.load(getClass().getResource("userProfileFXML.fxml")));
       ScreenController.activate("userProfileFXML");
    }


    @FXML
    void addCoinsPressed(ActionEvent event) {
    }

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
            pane.setPrefSize(friendsListListView.getPrefWidth() * (0.85), (friendsListListView.getPrefHeight() / 4));
            Label label = new Label("test" + x.betAmount);
            Line line = new Line();
            line.setStartX(0);
            line.setStartY(0);
            line.setEndX(pane.getPrefWidth() * 1.15);
            line.setEndY(0);
            line.setStyle("-fx-stroke: lightgray");

            pane.getChildren().addAll(label, line);
            friendsListListView.getItems().add(pane);
        }
    }
    //Use this to loop through array of bet object, creating a pane for the object and adding it to the list
    public void setUpListView2() {

        for (Bet x : userBets) {
            Pane pane = new Pane();
            pane.setPrefSize(searchResultList.getPrefWidth() * (0.85), (searchResultList.getPrefHeight() / 4));
            Label label = new Label("test" + x.betAmount);
            Line line = new Line();
            line.setStartX(0);
            line.setStartY(0);
            line.setEndX(pane.getPrefWidth() * 1.15);
            line.setEndY(0);
            line.setStyle("-fx-stroke: lightgray");

            pane.getChildren().addAll(label, line);
            searchResultList.getItems().add(pane);
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
