package C212Amazon;

/**
 * Seller
 * A seller account class
 * Nicholas de la Espriella
 * 4/13/2017
 */
public class Seller extends Account {

    private String name;
    private String phone;
    private String email;

    public Seller(int uniqueID, String username, String password, String name, String phone, String email) {

        super(uniqueID, username, password, email);
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Method to get the first name.
     * @return The first name.
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get user's contact
     * @return user's contact
     */
    public String getPhone() {
        return phone;
    }
}
