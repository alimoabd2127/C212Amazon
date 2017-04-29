package C212Amazon;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by alimo on 4/27/2017.
 */
public class SellerDataReader extends DataReader{

    public Seller getSeller(String table, String username){
        String sqlQuery = "SELECT * FROM " + table + " WHERE " + table + ".username COLLATE utf8mb4_bin = '" + username + "';";

        try {
            Connection conn = databaseConnector();
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
            conn.close();
            return new Seller(id, uname, pass, name, phone, email);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Seller> getSellers(String table){
        String sqlQuery = "SELECT * FROM " + table + ";";
        ArrayList<Seller> output = new ArrayList<>();
        try {
            Connection conn = databaseConnector();
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sqlQuery);

            int id = 0;
            String uname = "", pass = "", name = "", phone = "", email = "";

            while(rs.next()){
                id = rs.getInt("id");
                uname = rs.getString("username");
                pass = rs.getString("password");
                name = rs.getString("name");
                phone = rs.getString("phone");
                email = rs.getString("email");

                Seller temp = new Seller(id, uname, pass, name, phone, email);
                output.add(temp);
            }
            conn.close();
            return output;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        SellerDataReader sdr = new SellerDataReader();
        System.out.println(sdr.getSellers("seller").size());
    }
}
