package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;
/**
 * Author: Jacob
 */
public class betsFXMLController extends AbstractDataController implements Initializable, PropertyChangeListener {

    @FXML
    private Text activeBetsText;

    @FXML
    private Text betsText;

    @FXML
    private Label coinBalLabel;

    @FXML
    private ListView<Pane> activeBetsListView;

    @FXML
    private ListView<Pane> closedBetsListView;

    @FXML
    private Text closedBetsText;

    @FXML
    private Label userNameLabel;
    private ArrayList<Bet> userBets;

    @FXML
    void homePressed(ActionEvent event) throws IOException {
        //ScreenController.removeScreen("mainPage");
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
        if(userProfile == null){

        }
        else{
            userProfile.userPortfolio.portfolioBalance=userProfile.userPortfolio.portfolioBalance+10;
            coinBalLabel.setText(Integer.toString(userProfile.userPortfolio.portfolioBalance));
        }

    }
    @FXML
    void requestsPressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("betRequestsFXML", FXMLLoader.load(getClass().getResource("betRequestsFXML.fxml")));
        ScreenController.activate("betRequestsFXML");
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(userProfile != null) {
            coinBalLabel.setText(Integer.toString(userProfile.userPortfolio.portfolioBalance));
            userBets = userProfile.userPortfolio.userBets;
            setUpLists();

        }


    }

    public void setUpLists(){
        for(Bet x: userBets){
            if(x.betTargetStatus==2 && x.betSenderStatus ==2){
                ListElement el = new ListElement(closedBetsListView.getPrefWidth(),closedBetsListView.getPrefHeight());
                Label profit = new Label();
                profit.setLayoutX(el.length - el.length/6);
                profit.setLayoutY(el.height / 6);
                profit.setFont(new Font("Arial", el.height / 8));
                if(x.betWinner.equals(userProfile.userID)){
                    profit.setText("+$"+x.betAmount);
                    profit.setTextFill(Paint.valueOf("#90EE90"));
                }
                else{
                    profit.setText("-$"+x.betAmount);
                    profit.setTextFill(Paint.valueOf("red"));
                }
                el.pane.getChildren().add(profit);


                closedBetsListView.getItems().add(el.setTypeBet(x));
            }
            else if(x.betTargetStatus==1 || x.betSenderStatus==1){
                activeBetsListView.getItems().add(new ListElement(activeBetsListView.getPrefWidth(),activeBetsListView.getPrefHeight()).setTypeBet(x));
            }

        }
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals("textToChangePropertyChangeID")) {
            //System.out.println("Some shit");
//            textToChange.setText((String)evt.getNewValue());
        }
    }




}
