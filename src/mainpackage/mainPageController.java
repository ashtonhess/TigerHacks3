package mainpackage;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Pair;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;


public class mainPageController  implements Initializable, PropertyChangeListener {
    @FXML
    private NumberAxis yAxis;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private LineChart<String,Number> lineGraph;

    @FXML
    private Button activeBets;

    @FXML
    private Button betRequests;

    @FXML
    private ListView<?> friendBetsList;

    @FXML
    private Label totalBets;

    @FXML
    private Label totalGains;

    @FXML
    private Button newBet;

    @FXML
    private AnchorPane mainPane;
    @FXML
    private ImageView coinImage;

    @FXML
    private Label coinBalLabel;

    @FXML
    private Label userNameLabel;

    @FXML
    void logoutPressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("loginFXML", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginFXML.fxml"))));
        ScreenController.activate("loginFXML");

    }

    @FXML
    void profilePressed(ActionEvent event) throws IOException {
        ScreenController.addScreen("userProfileFXML", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("userProfileFXML.fxml"))));
        ScreenController.activate("userProfileFXML");

    }

    @FXML
    void friendsPressed(ActionEvent event) {

    }
    @FXML
    void addCoinsPressed(ActionEvent event) {

    }

    @FXML
    void newBetPressed(ActionEvent event) throws IOException {
            ScreenController.addScreen("newBetFXML", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("newBetFXML.fxml"))));
            ScreenController.activate("newBetFXML");
    }


    private XYChart.Series<String,Number> graphSeries;
    public ArrayList<Bet> userBets = new ArrayList<>();
    public daDatabase databaseObj = new daDatabase();

    //public Pair<Boolean, Pair<Integer, ResultSet>> finshedBets = databaseObj.executeQuery("SELECT * FROM Bet WHERE betStatus = 3 AND betIsPaidOut AND betSenderUserID = 'your userid' OR betTargetUserID = 'your userid';");
    public int maxAccountValue = 0 ;
    public int minAccountValue = 0;
    public int overallGains = 0 ;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lineGraph.setCreateSymbols(true);



        //System.out.println(Integer.toString(finshedBets.getValue().getKey()));
/*
        for(int i= 0; i<10; i++){
            userBets.add(ranBet());
        }

 */
        setUpChart();
    }

    public void setUpChart()
    {
        yAxis = new NumberAxis();
        xAxis = new CategoryAxis();
        graphSeries = new XYChart.Series();
        lineGraph.getData().add(graphSeries);
        int i=1;


        for(Bet x: userBets) {

            overallGains += x.betAmount;
            if (maxAccountValue < overallGains) {
                maxAccountValue = overallGains;
            }
            if (minAccountValue > overallGains) {
                minAccountValue = overallGains;

            }
            graphData(i);
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
/*
    public Bet ranBet(){
        Random rand = new Random(); //instance of random class

        //generate random values from 0-24
        int ran = rand.nextInt()/10000000;
        System.out.println(ran);

        Bet randBet = new Bet("","",ran,"","",false);
        return randBet;
    }

 */
}
