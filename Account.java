package C212Amazon;

import java.io.File;

/**
 * Account
 * abstract class that represents accounts
 * Nicholas de la Espriella
 * 4/13/2017
 */
public abstract class Account {

    // Unique ID of the account.
    private String uniqueID;
    // Username
    private String userName;
    // Password
    private String password;
    // Contact
    private String contact;
    // Email
    private String emailAddress;


    /**
     * returns a user name
     * @return The username.
     */
    public String getUserName() { return userName; }

    /**
     * creates an account.
     */
    public abstract void create();

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
     * sets a contact
     * @param contact The new contact information
     */
    public void setContact(String contact) { this.contact = contact; }

    /**
     * sets an email address
     * @param email The new email information.
     */
    public void setEmailAddress(String email) { this.emailAddress = email; }

}
