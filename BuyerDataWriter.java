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
    public void createBuyer(Buyer buyer) {
        String sqlQuery = "INSERT INTO buyer (buyer.username, buyer.password, buyer.firstname, buyer.lastname, buyer.phone, buyer.email)" +
                "VALUES ('" + buyer.getUserName() + "', '" + buyer.getPassword() + "', "
                + "'" + buyer.getFirstName() + "', '" + buyer.getLastName() + "', '"
                + buyer.getContact() + "', '" + buyer.getEmailAddress() + "');";

        try{
            Statement query = conn.createStatement();
            query.executeUpdate(sqlQuery);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Method to change a buyer's password.
     * @param id Buyer's id whose password is being changed.
     * @param password New password.
     */
    public void setPassword(String id, String password) {

    }

    /**
     * Method to change a buyer's username.
     * @param id Buyer's id whose username is being changed.
     * @param userName new username.
     */
    public void setUserName(String id, String userName) {

    }

    /**
     * Method to change a buyer's first name.
     * @param id Buyer's id whose first name is being changed.
     * @param firstName New first name.
     */
    public void setFirstName(String id, String firstName) {

    }

    /**
     * Method to change a buyer's last name.
     * @param id Buyer's id whose last name is being changed.
     * @param lastName New last name.
     */
    public void setLastName(String id, String lastName) {

    }

    /**
     * Method to change a buyer's contact information.
     * @param id Buyer's id whose contact information is being changed.
     * @param contact New contact information.
     */
    public void setContact(String id, String contact) {

    }

    /**
     * Method to change a buyer's email address.
     * @param id Buyer's id whose email is being changed.
     * @param email New email address.
     */
    public void setEmail(String id, String email) {

    }

    public static void main(String[] args) {
        BuyerDataWriter bdw = new BuyerDataWriter();
        bdw.createBuyer(new Buyer("asdf", "asdf","asdf","asdf","asdf","asdf"));
    }

}
