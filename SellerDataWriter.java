package C212Amazon;
import java.sql.*;
/**
 * Created by alimo on 4/27/2017.
 */

public class SellerDataWriter extends DataWriter{

    /**
     * Method to create a new buyer account.
     * @param seller The Seller object whose account is created.
     */
    public boolean createSeller(Seller seller) {
        String sqlQuery = "INSERT INTO seller (seller.username, seller.password, seller.name, seller.phone, seller.email)" +
                "VALUES ('" + seller.getUserName() + "', '" + seller.getPassword() + "', "
                + "'" + seller.getName() + "', '"
                + seller.getPhone() + "', '" + seller.getEmailAddress() + "');";

        try{
            Connection conn = databaseConnector();
            Statement query = conn.createStatement();
            query.executeUpdate(sqlQuery);
            conn.close();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

        return true;
    }
}
