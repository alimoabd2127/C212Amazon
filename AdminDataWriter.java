package C212Amazon;
import java.sql.*;

/**
 * Created by alimo on 4/27/2017.
 */
public class AdminDataWriter extends DataWriter {
    // parameters
    private Connection conn = databaseConnector();


    // methods
    /**
     * Method to create a new buyer account.
     * @param admin The Buyer object whose account is created.
     */
    public boolean createBuyer(Admin admin) {
        String sqlQuery = "INSERT INTO buyer (buyer.username, buyer.password, buyer.firstname, buyer.lastname, buyer.phone, buyer.email)" +
                "VALUES ('" + admin.getUserName() + "', '" + admin.getPassword() + "', "
                + "'" + admin.getEmailAddress() + "');";

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
