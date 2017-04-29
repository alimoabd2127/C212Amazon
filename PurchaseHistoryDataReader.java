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

    public ArrayList<String> getSoldHistory(String table, int sellerid){
        String sqlQuery = "SELECT * FROM " + table + " WHERE " + table + ".sellerid LIKE '%" + sellerid + "%';";
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

    public ArrayList<String> getPurchases(String table){
        String sqlQuery = "SELECT * FROM " + table + ";";
        ArrayList<String> output = new ArrayList<>();
        try {
            Connection conn = databaseConnector();
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sqlQuery);

            int id = 0, cartid = 0, buyerid = 0, productid = 0, quantity = 0, estimatedshipping = 0, sellerid = 0;
            String date = "";

            if(!rs.next()){
                System.out.println("No User");
            }
            id = rs.getInt("id");
            cartid = rs.getInt("cartid");
            buyerid = rs.getInt("buyerid");
            productid = rs.getInt("productid");
            quantity = rs.getInt("quantity");
            date = rs.getString("checkoutdate");
            estimatedshipping = rs.getInt("estimatedshipping");
            sellerid = rs.getInt("sellerid");


            String temp = "    ID: " + id + "    CartID: " + cartid + "    BuyerID: " + buyerid + "    ProductID: " +
                    productid + "    SellerID: " + sellerid + "    Quantity: " + quantity + "    Checkout Date: " +
                    date + "    Arrival Date: " + estimatedshipping;
            output.add(temp);
            conn.close();
            return output;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
