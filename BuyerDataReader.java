package C212Amazon;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * Created by alimo on 4/14/2017.
 */
public class BuyerDataReader extends DataReader {

    private Connection conn = databaseConnector();

    /**
     * Method to get the username for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the username of the buyer
     */
    public String getUsername(int id) {
        String sqlQuery = "SELECT username FROM buyer WHERE buyer.id = '" + id + "';";
        ResultSet rs = null;
        String output = "";
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
            rs.next();
            output = rs.getString("username");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    /**
     * Method to get the password for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the password of the buyer
     */
    public String getPassword(int id) {
        String sqlQuery = "SELECT password FROM buyer WHERE buyer.id = '" + id + "';";
        ResultSet rs = null;
        String output = "";
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
            rs.next();
            output = rs.getString("password");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    /**
     * Method to get the first name for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the first name of the buyer
     */
    public String getFirstName(int id) {
        String sqlQuery = "SELECT firstname FROM buyer WHERE buyer.id = '" + id + "';";
        ResultSet rs = null;
        String output = "";
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
            rs.next();
            output = rs.getString("firstname");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    /**
     * Method to get the last name for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the last name of the buyer
     */
    public String getLastName(int id) {
        String sqlQuery = "SELECT lastname FROM buyer WHERE buyer.id = '" + id + "';";
        ResultSet rs = null;
        String output = "";
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
            rs.next();
            output = rs.getString("lastname");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    /**
     * Method to get the contact information for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the contact information of the buyer
     */
    public String getPhone(int id) {
        String sqlQuery = "SELECT phone FROM buyer WHERE buyer.id = '" + id + "';";
        ResultSet rs = null;
        String output = "";
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
            rs.next();
            output = rs.getString("phone");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    /**
     * Method to get the email for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the email of the buyer
     */
    public String getEmail(int id) {
        String sqlQuery = "SELECT email FROM buyer WHERE buyer.id = '" + id + "';";
        ResultSet rs = null;
        String output = "";
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
            rs.next();
            output = rs.getString("email");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    public boolean verifyNewUsername(String username) {
        String sqlQuery = "SELECT username FROM buyer WHERE buyer.username COLLATE utf8mb4_bin = '" + username + "'";
        try {
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sqlQuery);
            if(!rs.next()){
                return false;
            }
            else{
                return true;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public Buyer getBuyer(String username) {
        String sqlQuery = "SELECT * FROM buyer WHERE buyer.username COLLATE utf8mb4_bin = '" + username + "';";

        try {
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
            return new Buyer(id, uname, pass, first, last, phone, email);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean verifyBuyer(String username, String password) {
        String sqlQuery = "SELECT * FROM buyer WHERE buyer.username COLLATE utf8mb4_bin = '" + username + "';";
        try {
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery(sqlQuery);

            if (!rs.next()) {
                return false;
            }
            String tempPass = rs.getString("password");
            if (tempPass.equals(password)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
