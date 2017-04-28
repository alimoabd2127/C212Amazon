package C212Amazon;

/**
 * Account
 * abstract class that represents accounts
 * Nicholas de la Espriella
 * 4/13/2017
 */
public abstract class Account {

    // Parameters

    private int uniqueID;        // Unique ID of the account.
    private String userName;     // Username
    private String password;     // Password
    private String emailAddress; // Email

    // constructor
    public Account(int uniqueID, String username, String password, String emailAddress) {
        this.uniqueID = uniqueID;
        this.userName = username;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    /**
     * returns a unique ID
     * @return uniqueID.
     */
    public int getUniqueID(){
        return uniqueID;
    }
    /**
     * returns a user name
     * @return username.
     */
    public String getUserName() { return userName; }

    /**
     * returns a password
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * returns an email address
     * @return emailAddress.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

}
