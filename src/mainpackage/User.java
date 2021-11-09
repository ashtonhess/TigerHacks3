package mainpackage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    public String userID;
    public String userPassword;
    public String userDateCreated;
    public Portfolio userPortfolio;

    public User(String userID, String userPassword){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateString = formatter.format(new Date());
        this.userID = userID;
        this.userPassword = userPassword;
        this.userDateCreated = dateString;
        this.userPortfolio = new Portfolio(this.userID);
    }

    public User(String userID, String userPassword, String userDateCreated, Portfolio port){
        this.userID = userID;
        this.userPassword = userPassword;
        this.userDateCreated= userDateCreated;
        this.userPortfolio=port;

    }

    public void getUpdatedBets(){

    }



}
