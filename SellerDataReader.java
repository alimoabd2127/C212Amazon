package C212Amazon;
import java.sql.*;
/**
 * Created by alimo on 4/27/2017.
 */
public class SellerDataReader extends DataReader{

    private Connection conn = databaseConnector();

    public Seller getSeller(String table, String username){
        String sqlQuery = "SELECT * FROM " + table + " WHERE " + table + ".username COLLATE utf8mb4_bin = '" + username + "';";

        try {
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sqlQuery);

            int id = 0;
            String uname = "", pass = "", name = "", phone = "", email = "";

            if(!rs.next()){
                System.out.println("No User");
            }
            id = rs.getInt("id");
            uname = rs.getString("username");
            pass = rs.getString("password");
            name = rs.getString("name");
            phone = rs.getString("phone");
            email = rs.getString("email");

            return new Seller(id, uname, pass, name, phone, email);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
