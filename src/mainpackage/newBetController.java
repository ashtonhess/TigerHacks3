package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class newBetController implements Initializable, PropertyChangeListener {

    @FXML
    private Label targetName;

    @FXML
    private TextField amountTextField;

    @FXML
    private Label userNameLabel;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private Label coinBalLabel;

    @FXML
    private ImageView coinImage;

    @FXML
    private ListView<Pane> friendsListView;

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
    void friendsPressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("friendsListFXML", FXMLLoader.load(getClass().getResource("friendsListFXML.fxml")));
        ScreenController.activate("friendsListFXML");

    }
    @FXML
    void addCoinsPressed(ActionEvent event) {

    }

    @FXML
    void betConfirmPressed(ActionEvent event) throws IOException{
        ScreenController.addScreen("mainPage", FXMLLoader.load(getClass().getResource("mainPage.fxml")));
        ScreenController.activate("mainPage");

    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public ArrayList<Bet> userBets = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //use this method to create and array list of random bet objects
        for(int i= 0; i<10; i++){
            userBets.add(ranBet());
        }

        setUpListView();
    }
    //Use this to loop through array of bet object, creating a pane for the object and adding it to the list
    public void setUpListView() {

        for (Bet x : userBets) {
            Pane pane = new Pane();
            pane.setPrefSize(friendsListView.getPrefWidth() * (0.85), (friendsListView.getPrefHeight() / 4));
            Label label = new Label("test" + x.betAmount);
            Line line = new Line();
            line.setStartX(0);
            line.setStartY(0);
            line.setEndX(pane.getPrefWidth() * 1.15);
            line.setEndY(0);
            line.setStyle("-fx-stroke: lightgray");

            pane.getChildren().addAll(label, line);
            friendsListView.getItems().add(pane);
        }
    }
    //Ran bet function to generate random bet objects for testing
    public Bet ranBet(){
        Random rand = new Random(); //instance of random class

        //generate random values from 0-24
        int ran = rand.nextInt()/10000000;
        //System.out.println(ran);

        Bet randBet = new Bet("",ran,"","",false);
        return randBet;
    }
}
