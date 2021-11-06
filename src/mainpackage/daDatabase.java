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


public class daDatabase {

    private String databaseURL = "jdbc:mysql://localhost:3306/bOrderFlow";
    private String databaseUser = "root";
    private String databasePass = "";

    private Connection conn;

    public Pair<Boolean,Pair<Integer,ResultSet>> executeQuery(String queryString){
        Connection executeQueryConn = null;
//        Pair<Boolean,ResultSet> resultPair = new Pair(false,null);
        ResultSet executeQueryResult;
        Integer numRows;
        try{
            executeQueryConn = getConnection();
            if (this.connectionStatus(executeQueryConn)==true) {
                Statement stmt = executeQueryConn.createStatement();
                numRows= stmt.executeUpdate(queryString);
                executeQueryResult =  stmt.executeQuery(queryString);
                return new Pair<Boolean, Pair<Integer, ResultSet>>(true, new Pair<Integer, ResultSet>(numRows, executeQueryResult));
            }else{
                return new Pair<Boolean, Pair<Integer, ResultSet>>(false, new Pair<Integer, ResultSet>(0, null));
            }
        }catch(SQLException sqlExcept){
            System.out.println("getConnection() failed. Database error.");
            return new Pair<Boolean, Pair<Integer, ResultSet>>(false, new Pair<Integer, ResultSet>(0, null));
        }
    }

    public Connection getConnection() throws SQLException {
        Properties connProperties = new Properties();
        connProperties.put("user", this.databaseUser);
        connProperties.put("pass", this.databasePass);

        try(Connection connTry = DriverManager.getConnection(databaseURL, connProperties);){
            conn = connTry;
            System.out.println("Connected to database successfully.");
        } catch (SQLException e){
            System.out.println("Error connecting to database.");
            e.printStackTrace();
        }
        return conn;
    }

    public Boolean connectionStatus(Connection conn){
        try {
            if (conn.isClosed()==true) {
                System.out.println("The connection is closed.");
                return false;
            }else{
                System.out.println("The connection is open.");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(daDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error closing database connection.");
            Logger.getLogger(daDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
