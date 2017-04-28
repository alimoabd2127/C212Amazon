package C212Amazon;
import java.sql.*;
import java.util.Random;

/**
 * Created by alimo on 4/27/2017.
 */
public class PurchaseHistoryDataWriter extends DataWriter{
    // parameters
    private Connection conn = databaseConnector();
    private Random rand = new Random();
    // methods
    /**
     * Method to create a new buyer account.
     * @param cartId The Seller object whose account is created.
     * @param buyerId
     * @param productId
     * @param quantity
     */
    public boolean createPurchaseHistory(int cartId, int buyerId, int productId, int quantity){

        String sqlQuery = "INSERT INTO purchasehistory (purchasehistory.cartid, purchasehistory.buyerid, purchasehistory.productid, purchasehistory.quantity, purchasehistory.checkoutdate, purchasehistory.estimatedshipping)" +
                "VALUES ('" + cartId + "', '" + buyerId + "', "
                + "'" + productId + "', '" + quantity + "', CURDATE(), '"
                + (rand.nextInt(4) + 2) + "');";

        System.out.println(sqlQuery);
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
