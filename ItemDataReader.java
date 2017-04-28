package C212Amazon;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by alimo on 4/27/2017.
 */
public class ItemDataReader extends DataReader {

    private Connection conn = databaseConnector();

    public ArrayList<Item> searchItems(String table, String name){
        String sqlQuery = "SELECT * FROM " + table + " WHERE " + table + ".productname LIKE '%" + name + "%';";

        ArrayList<Item> output = new ArrayList<>();
        try {
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sqlQuery);

            int id = 0, quantity = 0, sellerid = 0;
            String prodname = "", description = "", category = "";
            double price = 0.0f;

            while(rs.next()){
                id = rs.getInt("id");
                prodname = rs.getString("productname");
                description = rs.getString("description");
                category = rs.getString("category");
                price = rs.getDouble("price");
                quantity = rs.getInt("quantity");
                sellerid = rs.getInt("sellerid");

                Item item = new Item(id, prodname, description, category, price, quantity, sellerid);
                output.add(item);
            }

            return output;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Item getItem(String table, int id){
        String sqlQuery = "SELECT * FROM " + table + " WHERE " + table + ".id = '" + id + "';";
        ResultSet rs = null;

        int quantity = 0, sellerid = 0;
        String prodname = "", description = "", category = "";
        double price = 0.0f;

        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
            rs.next();
            prodname = rs.getString("productname");
            description = rs.getString("description");
            category = rs.getString("category");
            price = rs.getDouble("price");
            quantity = rs.getInt("quantity");
            sellerid = rs.getInt("sellerid");

            return new Item(id, prodname, description, category, price, quantity, sellerid);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
