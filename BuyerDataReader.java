package C212Amazon;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;

/**
 * Created by alimo on 4/14/2017.
 */
public class BuyerDataReader extends DataReader {

    private Connection conn = databaseConnector();

    /**
     * Method to get the description for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the details of the buyer
     */
    public String getBuyerDetails(String id) {
        return "";
    }

    /**
     * Method to get the password for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the password of the buyer
     */
    public String getPassword(String id) {
        return "";
    }

    /**
     * Method to get the username for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the username of the buyer
     */
    public String getUsername(String id) {
        return "";
    }

    /**
     * Method to get the first name for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the first name of the buyer
     */
    public String getFirstName(String id) {
        return "";
    }

    /**
     * Method to get the last name for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the last name of the buyer
     */
    public String getLastName(String id) {
        return "";
    }

    /**
     * Method to get the contact information for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the contact information of the buyer
     */
    public String getContact(String id) {
        return "";
    }

    /**
     * Method to get the email for that specific buyer
     *
     * @param id A string with the unique id of the buyer
     * @return returns a string of the email of the buyer
     */
    public String getEmail(String id) {
        return "";
    }

    public boolean verifyBuyer(String username, String password) {
        String sqlQuery = "SELECT password FROM buyer WHERE buyer.username COLLATE utf8mb4_bin = '" + username + "';";
        ResultSet rs = null;
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        if (rs == null) {
            return false;
        }

        try {
            rs.next();
            if (rs == null) {
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

    public Buyer getBuyer(String username) {
        String sqlQuery = "SELECT * FROM buyer WHERE buyer.username COLLATE utf8mb4_bin = '" + username + "';";
        ResultSet rs = null;
        try {
            Statement query = conn.createStatement();
            rs = query.executeQuery(sqlQuery);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        int id = 0;
        String uname = "", pass = "", first = "", last = "", phone = "", email = "";
        try {
            rs.next();
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

    public static void main(String[] args) {
        BuyerDataReader bdr = new BuyerDataReader();
        System.out.println("Login: " + bdr.verifyBuyer("Jash", "testpass2"));
        Buyer test = bdr.getBuyer("Jash");
        System.out.println(test.getUniqueID());
        System.out.println(test.getUserName());
        System.out.println(test.getPassword());
        System.out.println(test.getLastName());
        System.out.println(test.getFirstName());
        System.out.println(test.getEmailAddress());
        System.out.println(test.getPhone());
    }
}
