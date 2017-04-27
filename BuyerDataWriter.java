package C212Amazon;

import java.sql.*;
/**
 * Class to edit a buyer data file.
 * @author Syed Turab Ali Jafri.
 * 4/14/2017
 */
public class BuyerDataWriter extends DataWriter{

    private Connection conn = databaseConnector();
    /**
     * Method to create a new buyer account.
     * @param buyer The Buyer object whose account is created.
     */
    public boolean createBuyer(Buyer buyer) {
        String sqlQuery = "INSERT INTO buyer (buyer.username, buyer.password, buyer.firstname, buyer.lastname, buyer.phone, buyer.email)" +
                "VALUES ('" + buyer.getUserName() + "', '" + buyer.getPassword() + "', "
                + "'" + buyer.getFirstName() + "', '" + buyer.getLastName() + "', '"
                + buyer.getPhone() + "', '" + buyer.getEmailAddress() + "');";

        try{
            Statement query = conn.createStatement();
            query.executeUpdate(sqlQuery);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

        return true;
    }

    /**
     * Method to change a buyer's password.
     * @param id Buyer's id whose password is being changed.
     * @param password New password.
     */
    public void setPassword(int id, String password) {
        String sqlQuery = "UPDATE buyer" + " SET buyer.password = '" + password + "'" +
        "WHERE  buyer.id = " + id + ";";

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
    public void setUserName(int id, String userName) {
        String sqlQuery = "UPDATE buyer" + " SET buyer.username = '" + userName + "'" +
                "WHERE  buyer.id = " + id + ";";

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
    public void setFirstName(int id, String firstName) {
        String sqlQuery = "UPDATE buyer" + " SET buyer.firstname = '" + firstName + "'" +
                "WHERE  buyer.id = " + id + ";";

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
    public void setLastName(int id, String lastName) {
        String sqlQuery = "UPDATE buyer" + " SET buyer.lastname = '" + lastName + "'" +
                "WHERE  buyer.id = " + id + ";";

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
    public void setPhone(int id, String phone) {
        String sqlQuery = "UPDATE buyer" + " SET buyer.phone = '" + phone + "'" +
                "WHERE  buyer.id = " + id + ";";

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
    public void setEmail(int id, String email) {
        String sqlQuery = "UPDATE buyer" + " SET buyer.email = '" + email + "'" +
                "WHERE  buyer.id = " + id + ";";

        try{
            Statement query = conn.createStatement();
            query.executeUpdate(sqlQuery);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}