package C212Amazon;
import java.sql.*;
/**
 * Created by alimo on 4/27/2017.
 */
public class ItemDataWriter extends DataWriter{

    /**
     * Method to create a new buyer account.
     * @param item The database enters the information of the given Item parameter
     */
    public boolean createItem(Item item) {
        String sqlQuery = "INSERT INTO inventory (inventory.productname, inventory.description, inventory.category, inventory.price, inventory.quantity, inventory.sellerid)" +
                "VALUES ('" + item.getProdName() + "', '" + item.getDescription() + "', "
                + "'" + item.getCategory() + "', '" + item.getPrice() + "', '"
                + item.getQuantity() + "', '" + item.getSellerID() + "');";
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
