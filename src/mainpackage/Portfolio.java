package mainpackage;

import java.util.ArrayList;
import java.util.Random;

public class Portfolio {
    public String userID;
    public Integer portfolioBalance;
    public Integer portfolioTotalReturns;
    public ArrayList<Bet> userBets;


    public Portfolio(String userID, Integer portfolioBalance, Integer portfolioTotalReturns, ArrayList<Bet> bets){
        this.userID = userID;
        this.portfolioBalance = portfolioBalance;
        this.portfolioTotalReturns = portfolioTotalReturns;
        this.userBets = bets;
    }
    public Portfolio(String userID){
        this.userID= userID;
        this.portfolioBalance=0;
        this.portfolioTotalReturns=0;
        this.userBets = genRandomBet(30, userID);
    }

    public ArrayList<Bet> genRandomBet(int n, String userId){
        ArrayList<Bet> betList = new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            Random ranBet = new Random(); //instance of random class
            Random ranOutcome = new Random();


            //generate random values from 0-24
            int ranb = ranBet.nextInt(50);
            int rano = ranOutcome.nextInt(10);
            //System.out.println(rano);


            // add 5 element in ArrayList
            nameList.add("Ashton");
            nameList.add("Jacob");
            nameList.add("java jon");
            nameList.add("java joe");
            nameList.add("joe mama");

            Bet randBet = new Bet("", ranb, userId, nameList.get(ranBet.nextInt(nameList.size())), false);
            if(rano >= 4){
                randBet.betWinner=randBet.betSenderUserID;
            }
            else{
                randBet.betWinner=randBet.betTargetUserID;
            }
            betList.add(randBet);
        }

        return betList;
    }


}



//public class JDBCUtil {
//    String className, URL, user, password;
//    Connection connection;
//    public JDBCUtil(String className, String URL, String user, String password) {
//        this.className = className;
//        this.URL = URL;
//        this.user = user;
//        this.password = password;
//        this.connection = null;
//    }
//    public void getConnection() {
//        //Load the driver class
//        try {
//            Class.forName(className);
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Unable to load the class. Terminating the program");
//            System.exit(-1);
//        }
//        //get the connection
//        try {
//            connection = DriverManager.getConnection(URL, user, password);
//        } catch (SQLException ex) {
//            System.out.println("Error getting connection: " + ex.getMessage());
//            System.exit(-1);
//        } catch (Exception ex) {
//            System.out.println("Error: " + ex.getMessage());
//            System.exit(-1);
//        }
//    }
//}
