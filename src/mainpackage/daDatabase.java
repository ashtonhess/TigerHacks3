package mainpackage;


import javafx.util.Pair;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class daDatabase {



    static final String DB_URL1 = "jdbc:mysql://betmedb.cxzhslgwgxlk.us-east-2.rds.amazonaws.com:3306/BetMeDB";
    static final String USER1 = "admin";
    static final String PASS1 = "password";


    public void executeUpdate(String queryString){
        try(Connection conn = DriverManager.getConnection(DB_URL1, USER1, PASS1);
            Statement stmt = conn.createStatement();) {

            int resultCount = stmt.executeUpdate(queryString);
//             Extract data from result set
//            int x = 0;

//            ArrayList<String> rsArray = new ArrayList<String>();
//            while (rs.next()) {
//                rsArray.add(rs.toString());
//
//                // Retrieve by column name
////                x++;
////                System.out.println(x);
////                System.out.print("ID: " + rs.getInt("id"));
////                System.out.print(", Age: " + rs.getInt("age"));
////                System.out.print(", First: " + rs.getString("first"));
////                System.out.println(", Last: " + rs.getString("last"));
//            }


        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    public Pair<Boolean,Pair<Integer,ArrayList<String>>> executeQuery(String queryString) {

        try(Connection conn = DriverManager.getConnection(DB_URL1, USER1, PASS1);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);) {

//             Extract data from result set
//            int x = 0;

//            ArrayList<String> rsArray = new ArrayList<String>();
//            while (rs.next()) {
//                rsArray.add(rs.toString());
//
//                // Retrieve by column name
////                x++;
////                System.out.println(x);
////                System.out.print("ID: " + rs.getInt("id"));
////                System.out.print(", Age: " + rs.getInt("age"));
////                System.out.print(", First: " + rs.getString("first"));
////                System.out.println(", Last: " + rs.getString("last"));
//            }
            ArrayList<String> array = new ArrayList<String>();
            array = resultSetToSomething(rs);

            for (String i : array){
                System.out.println(i);
            }

            return new Pair<Boolean, Pair<Integer, ArrayList<String>>>(true, new Pair<Integer, ArrayList<String>>(1,array));
        } catch (SQLException e) {

            e.printStackTrace();
            return new Pair<Boolean, Pair<Integer, ArrayList<String>>>(false, new Pair<Integer, ArrayList<String>>(0, null));

        }
    }

    public ArrayList<String> resultSetToSomething(ResultSet rs) throws SQLException{
        ArrayList<String> a = new ArrayList<String>();
        int i = 1;
        while(rs.next()){

            a.add(rs.getString(i));
            i++;
        }
        return a;
    }






//    static final String DB_URL1 = "jdbc:mysql://localhost:3306/aaTigerHacks1";
//    static final String USER1 = "root";
//    static final String PASS1 = "";
//    static final String QUERY1 = "SELECT * FROM UserTable";
//
//    public static void doExampleQuery(String inputQuery) {
//        // Open a connection
//        try(Connection conn = DriverManager.getConnection(DB_URL1, USER1, PASS1);
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(inputQuery);) {
//            // Extract data from result set
//            int x =0;
//            while (rs.next()) {
//                // Retrieve by column name
//                x++;
//                System.out.println(x);
////                System.out.print("ID: " + rs.getInt("id"));
////                System.out.print(", Age: " + rs.getInt("age"));
////                System.out.print(", First: " + rs.getString("first"));
////                System.out.println(", Last: " + rs.getString("last"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }










//    private String databaseURL = "jdbc:mysql://localhost:3306/aaTigerHacks1";
//    private String databaseUser = "root";
//    private String databasePass = "";
//
//    private Connection conn;
//
//    Connection executeQueryConn;
//    //executeQuery function.
//    //INPUTS: String: a query written exactly as it should be.
//    //OUTPUTS: Boolean: if the query was successfully executed or not.
//    //         Integer: the number of rows in the resulting set.
//    //         ResultSet: the set that the query returned.
//    public Pair<Boolean,Pair<Integer,ResultSet>> executeQuery(String queryString){
//
//
//
//        try{
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("Error loading the driver.");
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//            System.out.println("Error loading the driver.");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//            System.out.println("Error loading the driver.");
//        }
////        Pair<Boolean,ResultSet> resultPair = new Pair(false,null);
//        ResultSet executeQueryResult;
//        Integer numRows;
//        try{
//            executeQueryConn = getConnection();
//
//            if (this.connectionStatus(executeQueryConn) == true) {
//                Statement stmt = executeQueryConn.createStatement();
//                numRows= stmt.executeUpdate(queryString);
//                executeQueryResult =  stmt.executeQuery(queryString);
//                return new Pair<Boolean, Pair<Integer, ResultSet>>(true, new Pair<Integer, ResultSet>(numRows, executeQueryResult));
//            }else{
//                System.out.println("Error in executeQuery. (this.connectionStatus(executeQueryConn)==true) FAILED");
//                return new Pair<Boolean, Pair<Integer, ResultSet>>(false, new Pair<Integer, ResultSet>(0, null));
//            }
//        }catch(SQLException sqlExcept){
//            System.out.println("getConnection() failed. Database error.");
//            return new Pair<Boolean, Pair<Integer, ResultSet>>(false, new Pair<Integer, ResultSet>(0, null));
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//    public Connection getConnection() throws SQLException {
//        Properties connProperties = new Properties();
//        connProperties.put("user", this.databaseUser);
//        connProperties.put("pass", this.databasePass);
//
//        try(Connection connTry = DriverManager.getConnection(databaseURL, connProperties);){
//            conn = connTry;
//            System.out.println("Connected to database successfully.");
//
//        } catch (SQLException e){
//            System.out.println("Error connecting to database.");
//            e.printStackTrace();
//        }
//        return conn;
//    }
//
//    public Boolean connectionStatus(Connection conn){
//        try {
//            if (conn.isClosed()==true) {
//                System.out.println("The connection is closed.");
//                return false;
//            }else{
//                System.out.println("The connection is open.");
//                return true;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(daDatabase.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }
//
//    public void closeConnection(Connection conn){
//        try {
//            conn.close();
//        } catch (SQLException ex) {
//            System.out.println("Error closing database connection.");
//            Logger.getLogger(daDatabase.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }


}
