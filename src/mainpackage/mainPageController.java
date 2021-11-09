package mainpackage;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;


public class mainPageController extends AbstractDataController  implements Initializable, PropertyChangeListener {

    @FXML
    private NumberAxis yAxis;

    @FXML
    private ImageView arrowImage;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private LineChart<String,Number> lineGraph;


    @FXML
    private ListView<Pane> friendBetsList;

    @FXML
    private Label totalBets;

    @FXML
    private Label totalGains;

    @FXML
    private AnchorPane mainPane;
    @FXML
    private ImageView coinImage;

    @FXML
    private Label coinBalLabel;
    @FXML
    private Button myBetsButton;
    @FXML
    private Button requestsButton;
    @FXML
    private Button newBetButton;
    @FXML
    private Label userNameLabel;



    @FXML
    void logoutPressed(ActionEvent event) throws IOException {
        //userProfile = null;
        ScreenController.addScreen("loginFXML", FXMLLoader.load(getClass().getResource("loginFXML.fxml")));
        ScreenController.activate("loginFXML");

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
    void myBetsPressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("betsFXML", FXMLLoader.load(getClass().getResource("betsFXML.fxml")));
        ScreenController.activate("betsFXML");

    }
    @FXML
    void requestsPressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("betRequestsFXML", FXMLLoader.load(getClass().getResource("betRequestsFXML.fxml")));
        ScreenController.activate("betRequestsFXML");

    }

    @FXML
    void newBetPressed(ActionEvent event) throws IOException {
            ScreenController.addScreen("newBetFXML", FXMLLoader.load(getClass().getResource("newBetFXML.fxml")));
            ScreenController.activate("newBetFXML");
    }

    @FXML
    private Button recentGraph;
    @FXML
    private Button totalGraph;

    @FXML
    void totalGraphPressed(ActionEvent event) {
        recentGraph.setStyle("-fx-background-color: #90EE90");
        totalGraph.setStyle("-fx-background-color: #a9a9a9");
        lineGraph.getData().clear();
        lineGraph.setCreateSymbols(false);
        graphType=1;
        setUpChart(graphType,userProfile.userPortfolio.userBets);
    }

    @FXML
    void recentGraphPressed(ActionEvent event) {
        recentGraph.setStyle("-fx-background-color: #a9a9a9");
        totalGraph.setStyle("-fx-background-color: #90EE90");
        lineGraph.getData().clear();
        lineGraph.setCreateSymbols(true);
        graphType=0;
        setUpChart(graphType, userProfile.userPortfolio.userBets);

    }

    private XYChart.Series<String,Number> graphSeries;
   // public ArrayList<Bet> userBets = new ArrayList<>();
    public daDatabase databaseObj = new daDatabase();
    private Image arrowUp = new Image(getClass().getResourceAsStream("up.png"));
    private Image arrowDown = new Image(getClass().getResourceAsStream("down.png"));

    //public Pair<Boolean, Pair<Integer, ResultSet>> finshedBets = databaseObj.executeQuery("SELECT * FROM Bet WHERE betStatus = 3 AND betIsPaidOut AND betSenderUserID = 'your userid' OR betTargetUserID = 'your userid';");
    public int maxAccountValue = 0 ;
    public int graphType= 0;
    public int minAccountValue = 0;
    public int overallGains = 0 ;
    final int WINDOW_SIZE = 20;
    public ArrayList<Bet> userBets = new ArrayList<>();
    public String userId;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //System.out.println(Integer.toString(finshedBets.getValue().getKey()));
        lineGraph.setCreateSymbols(true);

        //System.out.println(userBets);



        //custom data
        if(userProfile != null) {
            coinBalLabel.setText(Integer.toString(userProfile.userPortfolio.portfolioBalance));
            userId= userProfile.userID;
            userBets = userProfile.userPortfolio.userBets;
            userNameLabel.setText(userProfile.userID);
            update(userProfile.userPortfolio.userBets);
        }
        else{
            update(userBets);
        }


    }
    public void update(ArrayList<Bet> bets){
        setUpChart(graphType,bets);
        setUpData(bets);
        setUpListView(bets);

    }



    public void setUpListView(ArrayList<Bet> bets) {
        for(Bet x: bets){
            friendBetsList.getItems().add(new ListElement(friendBetsList.getPrefWidth(),friendBetsList.getPrefHeight()).setTypePublicBet(x));

        }



    }

    public void setUpData(ArrayList<Bet> bets){

        totalBets.setText(Integer.toString(bets.size()));
        if(overallGains>=0){
            arrowImage.setImage(arrowUp);
            totalGains.setText("$"+Integer.toString(overallGains));
            totalGains.setTextFill(Color.GREEN);
            totalBets.setTextFill(Color.GREEN);
            requestsButton.setStyle("-fx-background-radius: 10px");
            myBetsButton.setStyle("-fx-background-radius: 10px");
            newBetButton.setStyle("-fx-background-radius: 10px");
            requestsButton.setStyle("-fx-background-color: #90EE90");
            myBetsButton.setStyle("-fx-background-color: #90EE90");
            newBetButton.setStyle("-fx-background-color: #90EE90");
        }
        else{
            arrowImage.setImage(arrowDown);
            totalGains.setText(Integer.toString(overallGains));
            totalGains.setTextFill(Color.RED);
            totalBets.setTextFill(Color.RED);

            requestsButton.setStyle("-fx-background-radius: 10px");
            myBetsButton.setStyle("-fx-background-radius: 10px");
            newBetButton.setStyle("-fx-background-radius: 10px");
            requestsButton.setStyle("-fx-background-color: #ee2645");
            myBetsButton.setStyle("-fx-background-color: #EE2645FF");
            newBetButton.setStyle("-fx-background-color: #EE2645FF");

        }

    }

    public void setUpChart(int type,ArrayList<Bet> bets )
    {
        maxAccountValue=0;
        minAccountValue=0;
        overallGains=0;
        yAxis = new NumberAxis();
        xAxis = new CategoryAxis();
        graphSeries = new XYChart.Series();
        lineGraph.getData().add(graphSeries);
        int i=1;


        for(Bet x: bets) {

            if(x.betWinner.equals(userId)){
                overallGains += x.betAmount;

            }
            else if(!x.betWinner.equals("") && !x.betWinner.equals(userId)){
                overallGains -= x.betAmount;

            }


            if (maxAccountValue < overallGains) {
                maxAccountValue = overallGains;
            }
            if (minAccountValue > overallGains) {
                minAccountValue = overallGains;

            }
            if(type ==0){
                graphData(i);
            }
            else{
                graphTotal(i);
            }

            i++;
        }
        yAxis.setLowerBound(minAccountValue-(minAccountValue *0.1));
        yAxis.setUpperBound((maxAccountValue+(maxAccountValue *0.1)));

    }

    public void graphData(int i){

        if(i==1){
            XYChart.Data<String, Number> graphData = new XYChart.Data("0",0);
            graphSeries.getData().add(graphData);

        }
        XYChart.Data<String, Number> data = new XYChart.Data(Integer.toString(i),overallGains);
        graphSeries.getData().add(data);
        if (graphSeries.getData().size() > WINDOW_SIZE) {
            graphSeries.getData().remove(0);
        }
        data.getNode().setOnMouseEntered(e -> {
            Label dataLabel = new Label();
            dataLabel.setText("$"+data.getYValue());
            dataLabel.setLayoutX(data.getNode().getLayoutX()+70);
            dataLabel.setLayoutY(data.getNode().getLayoutY()+20);
            mainPane.getChildren().add(dataLabel);
            data.getNode().setOnMouseExited(ei -> {
                mainPane.getChildren().remove(dataLabel);
            });

        });
        if(overallGains < 0){
            graphSeries.getNode().setStyle("-fx-stroke: red");

        }
        else{
            graphSeries.getNode().setStyle("-fx-stroke: lightgreen");
        }

    }
    public void graphTotal(int i){
        if(i==1){
            XYChart.Data<String, Number> graphData = new XYChart.Data("0",0);
            graphSeries.getData().add(graphData);

        }
        XYChart.Data<String, Number> data = new XYChart.Data(Integer.toString(i),overallGains);
        graphSeries.getData().add(data);
        if(overallGains < 0){
            graphSeries.getNode().setStyle("-fx-stroke: red");

        }
        else{
            graphSeries.getNode().setStyle("-fx-stroke: lightgreen");
        }

    }



}
