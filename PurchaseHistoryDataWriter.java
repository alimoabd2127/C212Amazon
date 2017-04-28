package C212Amazon;
import java.sql.*;
import java.util.Random;

/**
 * Created by alimo on 4/27/2017.
 */
public class PurchaseHistoryDataWriter extends DataWriter{
    /**
     * Method to create a new buyer account.
     * @param cartId The Seller object whose account is created.
     * @param buyerId
     * @param productId
     * @param quantity
     */
    public boolean createPurchaseHistory(int cartId, int buyerId, int productId, int quantity){
        Connection conn = databaseConnector();
        Random rand = new Random();

        String sqlQuery = "INSERT INTO purchasehistory (purchasehistory.cartid, purchasehistory.buyerid, purchasehistory.productid, purchasehistory.quantity, purchasehistory.checkoutdate, purchasehistory.estimatedshipping)" +
                "VALUES ('" + cartId + "', '" + buyerId + "', "
                + "'" + productId + "', '" + quantity + "', CURDATE(), '"
                + (rand.nextInt(4) + 2) + "');";

        try{
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
