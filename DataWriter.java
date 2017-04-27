package C212Amazon;

import java.sql.*;
/**
 * Abstract class for file writers.
 * @author Syed Turab Ali Jafri
 * 4/14/2017
 */
public class DataWriter {

    public Connection databaseConnector(){

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://db.soic.indiana.edu/c212s17_aalimov", "c212s17_aalimov", "Guu37gu6");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}