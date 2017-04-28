package C212Amazon;
import java.sql.*;

/**
 * Created by alimo on 4/27/2017.
 */
public class AdminDataWriter extends DataWriter {
    private Connection conn = databaseConnector();

    /**
     * Method to create a new admin account.
     * @param admin The Admin object whose account is created.
     */
    public boolean createAdmin(Admin admin) {
        String sqlQuery = "INSERT INTO admin (admin.username, admin.password, admin.email)" +
                "VALUES ('" + admin.getUserName() + "', '" + admin.getPassword() + "', "
                + "'" + admin.getEmailAddress() + "');";

        try{
            Statement query = conn.createStatement();
            query.executeUpdate(sqlQuery);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

        return true;
    }
}
