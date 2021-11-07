package mainpackage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bet {
    public int betID;
    //0 = closed
    //1 = open
    //2 = invalid
    //3 = finished
    public int betStatus = 0;
    public Date betDateTime;
    public String betDescription;
    public String betTitle;
    public int betAmount;
    public String betWinner;
    public String betSenderUserID;
    public String betTargetUserID;
    // 2 = null, 0 = false, 1 = true
    public int betSenderResult = 2;
    public int betTargetResult = 2;
    // 0 = bet sent and is pending
    // 1 = bet has been accepted
    // 2 = bet result has been sent
    public int betSenderStatus = 0;
    public int betTargetStatus = 0;
    public boolean betIsPrivate = false;
    public boolean betIsPaidOut = true;

/**
//full constructor
    public Bet(int betID, int betStatus, String betDateTime, String betDescription, String betTitle, int betAmount, String betWinner, String betSenderUserID, String betTargetUserID, int betSenderResult, int betTargetResult, int betSenderStatus, int betTargetStatus, boolean betIsPrivate, boolean betIsPaidOut) {
        this.betID = betID;
        this.betStatus = betStatus;
        this.betDateTime = new Date();
        this.betIsPrivate = betIsPrivate;

        this.betIsPaidOut = false;
        this.betTitle= senderId +"made a $"+betAmount+" with "+ targetID;
        // add this this.BetId =
        this.betDescription = description;
        this.betAmount = betAmount;
        this.betSenderUserID = senderId;
        this.betTargetUserID = targetID;
        this.betWinner = "";
    }
*/






    public Bet(String description, int betAmount, String senderId, String targetID, boolean isPrivate){
        this.betIsPrivate = isPrivate;
        this.betDateTime = new Date();
        this.betIsPaidOut = false;
        this.betTitle= senderId +"made a $"+betAmount+" with "+ targetID;
        // add this this.BetId =
        this.betDescription = description;
        this.betAmount = betAmount;
        this.betSenderUserID = senderId;
        this.betTargetUserID = targetID;
        this.betWinner = "";
    }




    public String convertBetToString(){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateString = formatter.format(this.betDateTime);
        return(Integer.toString(this.betAmount)+","+
                Integer.toString(this.betStatus)+","+
                dateString+","+
                this.betDescription+","+
                this.betTitle+","+
                Integer.toString(this.betAmount)+","+
                this.betWinner+","+
                this.betSenderUserID+","+
                this.betTargetUserID+","+
                Integer.toString(this.betSenderResult)+","+
                Integer.toString(this.betTargetResult)+","+
                Integer.toString(this.betSenderStatus)+","+
                Integer.toString(this.betTargetStatus)+","+
                Boolean.toString(this.betIsPrivate))+","+
                Boolean.toString(this.betIsPaidOut);
    }
    public Bet convertStringToBet(String bet){

        return null;
    }







}
