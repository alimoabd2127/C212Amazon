package C212Amazon;
import java.sql.*;
/**
 * Created by alimo on 4/27/2017.
 */
public class PurchaseHistoryDataReader extends DataReader {

    public int getCartId() {
        Connection conn = databaseConnector();
        String sqlQuery = "SELECT MAX(cartid) FROM purchasehistory;";
        int cartid = -1;
        try {
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sqlQuery);

            if (!rs.next()) {
                System.out.println("Value");
            }
            cartid = rs.getInt(1) + 1;
            conn.close();
            return cartid;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return cartid;
        }
    }
}
