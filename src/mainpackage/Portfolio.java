package mainpackage;

public class Portfolio {
    public String userID;
    public Integer portfolioBalance;
    public Integer portfolioTotalReturns;


    public Portfolio(String userID, Integer portfolioBalance, Integer portfolioTotalReturns){
        this.userID = userID;
        this.portfolioBalance = portfolioBalance;
        this.portfolioTotalReturns = portfolioTotalReturns;
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
