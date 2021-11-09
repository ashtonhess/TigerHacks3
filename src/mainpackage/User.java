package mainpackage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class User {

    public String userID;
    public String userPassword;
    public String userDateCreated;
    public ArrayList<String> userFriends;
    public ArrayList<String> userFriendRequests;
    public Portfolio userPortfolio;

    public User(String userID, String userPassword){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateString = formatter.format(new Date());
        this.userFriends = new ArrayList<String>();
        this.userFriendRequests = new ArrayList<String>();
        this.userID = userID;
        this.userPassword = userPassword;
        this.userDateCreated = dateString;
        this.userPortfolio = new Portfolio(this.userID);
    }

    public User(String userID, String userPassword, String userDateCreated, Portfolio port,ArrayList<String> friends,ArrayList<String> friendRequests){
        this.userID = userID;
        this.userFriends = friends;
        this.userPassword = userPassword;
        this.userFriendRequests = friendRequests;
        this.userDateCreated= userDateCreated;
        this.userPortfolio=port;

    }




}
