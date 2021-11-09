package mainpackage;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Lists {
    ArrayList<Pane> panes = new ArrayList<>();
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy H:mm");


   //bets public
    public Lists(double i, double j,ArrayList<Bet> b){
        for(Bet x: b){
            if(!x.betIsPrivate) {


                Pane pane = new Pane();
                pane.setPrefSize(i * (0.85), (j / 4));
                Line line = new Line();
                line.setStartX(0);
                line.setStartY(0);
                line.setEndX(pane.getPrefWidth() * 1.15);
                line.setEndY(0);
                line.setStyle("-fx-stroke: lightgray");

                Label l = new Label();
                Label d = new Label();
                d.setLayoutX(pane.getPrefWidth() / 10);
                d.setLayoutY(pane.getPrefHeight() / 6);
                l.setLayoutX(pane.getPrefWidth() / 10);
                l.setLayoutY(pane.getPrefHeight() / 2);
                l.setText(x.makeTitle());
                d.setText(formatter.format(x.betDateTime));
                l.setFont(new Font("Arial", pane.getPrefHeight() / 6));
                d.setFont(new Font("Arial", pane.getPrefHeight() / 8));
                l.setTextFill(Paint.valueOf("#398994"));
                d.setTextFill(Paint.valueOf("#b5afaf"));

                pane.getChildren().addAll(l, d, line);
                panes.add(pane);
            }
        }




    }

    public Lists(double i, double j){
        Pane pane = new Pane();
        pane.setPrefSize(i * (0.85), (j / 4));
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(0);
        line.setEndX(pane.getPrefWidth() * 1.15);
        line.setEndY(0);
        line.setStyle("-fx-stroke: lightgray");

    }
    //your bets
    public Lists(int i){

    }
    //requests friend

    //requests bets
    public Lists(int w,String j){

    }
    // list of friends
    public Lists(){

    }



}
