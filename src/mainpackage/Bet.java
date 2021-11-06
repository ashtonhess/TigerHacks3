package mainpackage;

import java.util.Date;

public class Bet {
    public int betID;
    //0 = closed
    //1 = open
    //2 = invalid
    //3 = finished
    public int betStatus = 0;
    public boolean isPrivate = false;
    public boolean paidOut = false;
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

    public Bet(String description, String title, int betAmount, String senderId, String targetID, boolean isPrivate){
        this.isPrivate = isPrivate;
        this.betDateTime = new Date();
        // add this this.BetId =
        this.betDescription = description;
        this.betTitle = title;
        this.betAmount = betAmount;
        this.betSenderUserID = senderId;
        this.betTargetUserID = targetID;
        this.betWinner = null;
    }






}
