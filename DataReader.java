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
    public String getUsername(String table, int id) {
        String sqlQuery = "SELECT username FROM " + table + " WHERE " + table + ".id = '" + id + "';";
        ResultSet rs = null;
        String output = "";
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
            rs.next();
            output = rs.getString("username");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    /**
     * Method to get the password for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the password of the buyer
     */
    public String getPassword(String table, int id) {
        String sqlQuery = "SELECT password FROM " + table + " WHERE " + table + ".id = '" + id + "';";
        ResultSet rs = null;
        String output = "";
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
            rs.next();
            output = rs.getString("password");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    /**
     * Method to get the first name for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the first name of the buyer
     */
    public String getFirstName(String table, int id) {
        String sqlQuery = "SELECT firstname FROM " + table + " WHERE " + table + ".id = '" + id + "';";
        ResultSet rs = null;
        String output = "";
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
            rs.next();
            output = rs.getString("firstname");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    /**
     * Method to get the last name for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the last name of the buyer
     */
    public String getLastName(String table, int id) {
        String sqlQuery = "SELECT lastname FROM " + table + " WHERE " + table + ".id = '" + id + "';";
        ResultSet rs = null;
        String output = "";
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
            rs.next();
            output = rs.getString("lastname");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    /**
     * Method to get the contact information for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the contact information of the buyer
     */
    public String getPhone(String table, int id) {
        String sqlQuery = "SELECT phone FROM " + table + " WHERE " + table + ".id = '" + id + "';";
        ResultSet rs = null;
        String output = "";
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
            rs.next();
            output = rs.getString("phone");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    /**
     * Method to get the email for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the email of the buyer
     */
    public String getEmail(String table, int id) {
        String sqlQuery = "SELECT email FROM " + table + " WHERE " + table + ".id = '" + id + "';";
        ResultSet rs = null;
        String output = "";
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
            rs.next();
            output = rs.getString("email");
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
