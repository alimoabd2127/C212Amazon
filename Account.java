package C212Amazon;

/**
 * Account
 * abstract class that represents accounts
 * Nicholas de la Espriella
 * 4/13/2017
 */
public abstract class Account {

    // Unique ID of the account.
    private int uniqueID;
    // Username
    private String userName;
    // Password
    private String password;
    // Email
    private String emailAddress;

    public Account(int uniqueID, String username, String password, String emailAddress) {

        this.uniqueID = uniqueID;
        this.userName = username;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public int getUniqueID(){
        return uniqueID;
    }
    /**
     * returns a user name
     * @return The username.
     */
    public String getUserName() { return userName; }

    public String getPassword() {
        return password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * sets a user name
     * @param userName The new username
     */
    public void setUserName(String userName) { this.userName = userName; }

    /**
     * sets a password
     * @param password The new password.
     */
    public void setPassword(String password) { this.password = password; }

    /**
     * sets an email address
     * @param email The new email information.
     */
    public void setEmailAddress(String email) { this.emailAddress = email; }

}
