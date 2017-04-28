/**
 * BuyerDataReader
 * Reads buyer data from the database
 * Created by alimo on 4/14/2017.
 */

package C212Amazon;
import java.sql.*;

public class BuyerDataReader extends DataReader {

    private Connection conn = databaseConnector();

    public Buyer getBuyer(String table, String username){
        String sqlQuery = "SELECT * FROM " + table + " WHERE " + table + ".username COLLATE utf8mb4_bin = '" + username + "';";

        try {
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sqlQuery);
            conn.close();

            int id = 0;
            String uname = "", pass = "", first = "", last = "", phone = "", email = "";

            if(!rs.next()){
                System.out.println("No User");
            }
            id = rs.getInt("id");
            uname = rs.getString("username");
            pass = rs.getString("password");
            first = rs.getString("firstname");
            last = rs.getString("lastname");
            phone = rs.getString("phone");
            email = rs.getString("email");

            return new Buyer(id, uname, pass, first, last, phone, email);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
