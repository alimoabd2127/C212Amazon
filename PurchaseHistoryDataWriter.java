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
        Random rand = new Random();
        DataReader dr = new DataReader();

        String sqlQuery = "INSERT INTO purchasehistory (purchasehistory.cartid, purchasehistory.buyerid, purchasehistory.productid, purchasehistory.quantity, purchasehistory.checkoutdate, purchasehistory.estimatedshipping, purchasehistory.sellerid)" +
                "VALUES ('" + cartId + "', '" + buyerId + "', "
                + "'" + productId + "', '" + quantity + "', CURDATE(), '"
                + (rand.nextInt(4) + 2) + "', " + dr.getSellerId("inventory", productId) + ");";

        try{
            Connection conn = databaseConnector();
            Statement query = conn.createStatement();
            query.executeUpdate(sqlQuery);
            conn.close();
        }
        catch (Exception e){
            System.out.println(sqlQuery);
            System.err.println(e.getMessage());
        }

        return true;
    }

}
