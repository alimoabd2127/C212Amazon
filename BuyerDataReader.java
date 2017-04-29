/**
 * BuyerDataReader
 * Reads buyer data from the database
 * Created by alimo on 4/14/2017.
 */

package C212Amazon;
import java.sql.*;
import java.util.ArrayList;

public class BuyerDataReader extends DataReader {

    public Buyer getBuyer(String table, String username){
        String sqlQuery = "SELECT * FROM " + table + " WHERE " + table + ".username COLLATE utf8mb4_bin = '" + username + "';";

        try {
            Connection conn = databaseConnector();
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sqlQuery);

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
            conn.close();
            return new Buyer(id, uname, pass, first, last, phone, email);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Buyer> getBuyers(String table){
        String sqlQuery = "SELECT * FROM " + table + ";";
        ArrayList<Buyer> output = new ArrayList<>();
        try {
            Connection conn = databaseConnector();
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sqlQuery);

            int id = 0;
            String uname = "", pass = "", first = "", last = "", phone = "", email = "";

            while(rs.next()){
                id = rs.getInt("id");
                uname = rs.getString("username");
                pass = rs.getString("password");
                first = rs.getString("firstname");
                last = rs.getString("lastname");
                phone = rs.getString("phone");
                email = rs.getString("email");

                Buyer temp = new Buyer(id, uname, pass, first, last, phone, email);
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
