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

    // a database connection
    private Connection conn = databaseConnector();

    /**
     * Method to change a buyer's password.
     * @param id Buyer's id whose password is being changed.
     * @param password New password.
     */
    public void setPassword(String table, int id, String password) {
        String sqlQuery = "UPDATE " + table + " SET " + table + ".password = '" + password + "'" +
                "WHERE " + table + ".id = " + id + ";";

        try{
            Statement query = conn.createStatement();
            query.executeUpdate(sqlQuery);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Method to change a buyer's username.
     * @param id Buyer's id whose username is being changed.
     * @param userName new username.
     */
    public void setUserName(String table, int id, String userName) {
        String sqlQuery = "UPDATE " + table + " SET " + table + ".username = '" + userName + "'" +
                "WHERE " + table + ".id = " + id + ";";

        try{
            Statement query = conn.createStatement();
            query.executeUpdate(sqlQuery);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Method to change a buyer's first name.
     * @param id Buyer's id whose first name is being changed.
     * @param firstName New first name.
     */
    public void setFirstName(String table, int id, String firstName) {
        String sqlQuery = "UPDATE " + table + " SET " + table + ".firstname = '" + firstName + "'" +
                "WHERE " + table + ".id = " + id + ";";

        try{
            Statement query = conn.createStatement();
            query.executeUpdate(sqlQuery);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Method to change a buyer's last name.
     * @param id Buyer's id whose last name is being changed.
     * @param lastName New last name.
     */
    public void setLastName(String table, int id, String lastName) {
        String sqlQuery = "UPDATE " + table + " SET " + table + ".lastname = '" + lastName + "'" +
                "WHERE " + table + ".id = " + id + ";";

        try{
            Statement query = conn.createStatement();
            query.executeUpdate(sqlQuery);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Method to change a buyer's contact information.
     * @param id Buyer's id whose contact information is being changed.
     * @param phone New contact information.
     */
    public void setPhone(String table, int id, String phone) {
        String sqlQuery = "UPDATE " + table + " SET " + table + ".phone = '" + phone + "'" +
                "WHERE " + table + ".id = " + id + ";";

        try{
            Statement query = conn.createStatement();
            query.executeUpdate(sqlQuery);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Method to change a buyer's email address.
     * @param id Buyer's id whose email is being changed.
     * @param email New email address.
     */
    public void setEmail(String table, int id, String email) {
        String sqlQuery = "UPDATE " + table + " SET " + table + ".email = '" + email + "'" +
                "WHERE " + table + ".id = " + id + ";";

        try{
            Statement query = conn.createStatement();
            query.executeUpdate(sqlQuery);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}