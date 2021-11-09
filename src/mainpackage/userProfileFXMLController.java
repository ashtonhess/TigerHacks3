package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
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
public class userProfileFXMLController extends AbstractDataController implements Initializable, PropertyChangeListener {

    @FXML
    private Button friendRequestsButton;

    @FXML
    private ListView<Pane> friendsListListView;

    @FXML
    private ImageView userPicImageView;

    @FXML
    private Text friendsListText;

    @FXML
    private Label coinBalLabel;

    @FXML
    private Text closedBetsText;

    @FXML
    private Circle userPicBorderCircle;

    @FXML
    private Text usernameText;

    @FXML
    private Button betRequestsButton;

    @FXML
    private Text activeBetsText;

    @FXML
    private Label userNameLabel;

    @FXML
    private ListView<Pane> activeBetsListView;

    @FXML
    private ListView<Pane> closedBetsListView;

    @FXML
    private ImageView coinImage;

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
    void friendsPressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("mainPage", FXMLLoader.load(getClass().getResource("mainPage.fxml")));
        ScreenController.activate("friendsListFXML");

    }
    @FXML
    void addCoinsPressed(ActionEvent event) {
        if(userProfile == null){

        }
        else{
            userProfile.userPortfolio.portfolioBalance=userProfile.userPortfolio.portfolioBalance+10;
            coinBalLabel.setText(Integer.toString(userProfile.userPortfolio.portfolioBalance));
        }

    }

    public ArrayList<Bet> userBets = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //use this method to create and array list of random bet objects
        if(userProfile != null) {
            coinBalLabel.setText(Integer.toString(userProfile.userPortfolio.portfolioBalance));
        }
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
    public void setUpListView1() {

        for (Bet x : userBets) {
            Pane pane = new Pane();
            pane.setPrefSize(activeBetsListView.getPrefWidth() * (0.85), (activeBetsListView.getPrefHeight() / 4));
            Label label = new Label(x.betSenderUserID + " bet " + x.betTargetUserID + " $" + x.betAmount);
            Line line = new Line();
            line.setStartX(0);
            line.setStartY(0);
            line.setEndX(pane.getPrefWidth() * 1.15);
            line.setEndY(0);
            line.setStyle("-fx-stroke: lightgray");

            pane.getChildren().addAll(label, line);
            activeBetsListView.getItems().add(pane);
        }
    }
    //Use this to loop through array of bet object, creating a pane for the object and adding it to the list
    public void setUpListView2() {

        for (Bet x : userBets) {
            Pane pane = new Pane();
            pane.setPrefSize(closedBetsListView.getPrefWidth() * (0.85), (closedBetsListView.getPrefHeight() / 4));
            Label label = new Label("test" + x.betAmount);
            Line line = new Line();
            line.setStartX(0);
            line.setStartY(0);
            line.setEndX(pane.getPrefWidth() * 1.15);
            line.setEndY(0);
            line.setStyle("-fx-stroke: lightgray");

            pane.getChildren().addAll(label, line);
            closedBetsListView.getItems().add(pane);
        }
    }
    //Ran bet function to generate random bet objects for testing
    public Bet ranBet(){
        Random rand = new Random(); //instance of random class

        //generate random values from 0-24
        int ran = rand.nextInt()/10000000;
        //System.out.println(ran);

        Bet randBet = new Bet("I'm ",ran,"","",false);
        return randBet;
    }
//    @FXML
//    private void handleDaButton(ActionEvent event) {
//        daModel.changeDaText();
//    }
}