/**
 * BuyerDataWriter
 * Class to edit a buyer data file.
 * @author Syed Turab Ali Jafri.
 * 4/14/2017
 */


package C212Amazon;
import java.sql.*;

public class BuyerDataWriter extends DataWriter{

    // parameters
    private Connection conn = databaseConnector();


    // methods
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
}