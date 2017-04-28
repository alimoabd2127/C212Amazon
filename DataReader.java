package C212Amazon;

import java.sql.*;
/**
 * Abstract class for file writers.
 * @author Syed Turab Ali Jafri
 * 4/14/2017
 */
public class DataReader {

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

    // a database connection
    private Connection conn = databaseConnector();

    /**
     * Method to get the username for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the username of the buyer
     */
    public String getDb(String table, String column, int id) {
        String sqlQuery = "SELECT " + column + " FROM " + table + " WHERE " + table + ".id = '" + id + "';";
        ResultSet rs = null;
        String output = "";
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
            conn.close();

            rs.next();
            output = rs.getString(column);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    /**
     * Method to verify if a buyer exists for that specific word
     *
     * @param username A string with the name of the buyer
     * @return returns A string of the email of the buyer
     */
    public boolean verifyNewUsername(String table, String username) {
        String sqlQuery = "SELECT username FROM " + table + " WHERE " + table + ".username COLLATE utf8mb4_bin = '" + username + "'";
        try {
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sqlQuery);
            conn.close();

            if(!rs.next()){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return true;
        }
    }

    /**
     * Method to verifty if the buyers username matches their password
     *
     * @param username A string with the name of the buyer
     * @return returns a buyer object
     */
    public boolean verify(String table, String username, String password) {
        String sqlQuery = "SELECT * FROM " + table + " WHERE " + table + ".username COLLATE utf8mb4_bin = '" + username + "';";
        try {
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sqlQuery);
            conn.close();

            if (!rs.next()) {
                return false;
            }
            String tempPass = rs.getString("password");
            if (tempPass.equals(password)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
