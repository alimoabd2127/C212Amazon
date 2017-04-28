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
            connection = DriverManager.getConnection("jdbc:mysql://localhost/amazon", "root", "password");
            //connection = DriverManager.getConnection("jdbc:mysql://db.soic.indiana.edu/c212s17_aalimov", "c212s17_aalimov", "Guu37gu6");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void setDb(String table, String column, int id, String input){
        String sqlQuery = "UPDATE " + table + " SET " + table + "." + column + " COLLATE utf8mb4_bin = '" + input + "'" +
                "WHERE " + table + ".id = " + id + ";";

        try{
            Connection conn = databaseConnector();
            Statement query = conn.createStatement();
            query.executeUpdate(sqlQuery);
            conn.close();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}