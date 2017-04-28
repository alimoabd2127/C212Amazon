package C212Amazon;
import java.sql.*;

/**
 * Created by alimo on 4/27/2017.
 */
public class AdminDataReader extends DataReader {

    public Admin getAdmin(String table, String username){
        String sqlQuery = "SELECT * FROM " + table + " WHERE " + table + ".username COLLATE utf8mb4_bin = '" + username + "';";

        try {
            Connection conn = databaseConnector();
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sqlQuery);

            int id = 0;
            String uname = "", pass = "", first = "", last = "", email = "";

            if(!rs.next()){
                System.out.println("No User");
            }
            id = rs.getInt("id");
            uname = rs.getString("username");
            pass = rs.getString("password");
            email = rs.getString("email");
            conn.close();
            return new Admin(id, uname, pass, email);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
