package mainpackage;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.text.SimpleDateFormat;

public class ListElement{
    Pane pane = new Pane();
    Line line = new Line();
    double height;
    double length;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy H:mm");


    public ListElement(double i, double j){
        this.height = j/4;
        this.length = i;
        this.pane.setPrefSize(this.length * (0.85), this.height);
        this.line.setStartX(0);
        this.line.setStartY(0);
        this.line.setEndX(this.length * 1.15);
        this.line.setEndY(0);
        this.line.setStyle("-fx-stroke: lightgray");
        this.pane.getChildren().add(this.line);
    }

    public Pane setTypePublicBet(Bet x){
        if(!x.betIsPrivate) {

            Label l = new Label();
            Label d = new Label();
            d.setLayoutX(this.length / 10);
            d.setLayoutY(this.height / 6);
            l.setLayoutX(this.length / 10);
            l.setLayoutY(this.height / 2);
            l.setText(x.makeTitle());
            d.setText(formatter.format(x.betDateTime));
            l.setFont(new Font("Arial", this.height / 6));
            d.setFont(new Font("Arial", this.height / 8));
            l.setTextFill(Paint.valueOf("#398994"));
            d.setTextFill(Paint.valueOf("#b5afaf"));
            this.pane.getChildren().addAll(l, d);

        }
        return this.pane;

    }


}
