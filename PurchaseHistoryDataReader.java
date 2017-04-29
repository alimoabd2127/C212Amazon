package C212Amazon;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by alimo on 4/27/2017.
 */
public class PurchaseHistoryDataReader extends DataReader {

    public int getCartId() {
        String sqlQuery = "SELECT MAX(cartid) FROM purchasehistory;";
        int cartid = -1;
        try {
            Connection conn = databaseConnector();
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

    public ArrayList<String> getPurchaseHistory(String table, int buyerid){
        String sqlQuery = "SELECT * FROM " + table + " WHERE " + table + ".buyerid LIKE '%" + buyerid + "%';";
        ArrayList<String> output = new ArrayList<>();

        ItemDataReader idr = new ItemDataReader();
        try {
            Connection conn = databaseConnector();
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sqlQuery);

            int cartid = 0, quantity = 0;
            String item = "", estDay, purchaseDate;

            while(rs.next()){
                cartid = rs.getInt("cartid");
                item = idr.getItem("inventory", rs.getInt("productid")).toString2();
                quantity = rs.getInt("quantity");
                estDay = rs.getString("estimatedshipping");
                purchaseDate = rs.getString("checkoutdate");

                String temp = cartid + "    Product: " + item + "    Quantity: " + quantity + "    Purchased: " + purchaseDate + "    Shipping time: " + estDay + " days";
                output.add(temp);
            }
            conn.close();
            return output;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }


}
