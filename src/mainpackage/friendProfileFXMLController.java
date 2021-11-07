package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
public class friendProfileFXMLController implements Initializable, PropertyChangeListener {

    @FXML
    private Text friendNameText;

    @FXML
    private ImageView userPicImageView;

    @FXML
    private Text activeBetsText;

    @FXML
    private ListView<Pane> activeBetsListView;

    @FXML
    private ListView<Pane> closedBetsListView;

    @FXML
    private ListView<Pane> friendListListView;

    @FXML
    private Text closedBetsText;

    public ArrayList<Bet> userBets = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //use this method to create and array list of random bet objects
        for(int i= 0; i<10; i++){
            userBets.add(ranBet());
        }

        setUpListView();
        setUpListView1();
        setUpListView2();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals("textToChangePropertyChangeID")) {
            //System.out.println("Some shit");
//            textToChange.setText((String)evt.getNewValue());
        }
    }

    @FXML
    void donePressed(ActionEvent event) throws IOException {

        //code

        ScreenController.addScreen("loginFXML", FXMLLoader.load(getClass().getResource("loginFXML.fxml")));
        ScreenController.activate("loginFXML");

    }
    //Use this to loop through array of bet object, creating a pane for the object and adding it to the list
    public void setUpListView() {


        for (Bet x : userBets) {
            Pane pane = new Pane();
            pane.setPrefSize(activeBetsListView.getPrefWidth() * (0.85), (activeBetsListView.getPrefHeight() / 4));
            Label label = new Label("test" + x.betAmount);
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
    public void setUpListView1() {

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
    //Use this to loop through array of bet object, creating a pane for the object and adding it to the list
    public void setUpListView2() {

        for (Bet x : userBets) {
            Pane pane = new Pane();
            pane.setPrefSize(friendListListView.getPrefWidth() * (0.85), (friendListListView.getPrefHeight() / 4));
            Label label = new Label("test" + x.betAmount);
            Line line = new Line();
            line.setStartX(0);
            line.setStartY(0);
            line.setEndX(pane.getPrefWidth() * 1.15);
            line.setEndY(0);
            line.setStyle("-fx-stroke: lightgray");

            pane.getChildren().addAll(label, line);
            friendListListView.getItems().add(pane);
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
