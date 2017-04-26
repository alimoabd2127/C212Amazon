package C212Amazon;

import java.util.HashMap;

/**
 * Buyer
 * a Buyer account
 * Nicholas de la Espriella
 * 4/13/2017
 */
public class Buyer extends Account {

    private Market market;

    //Shopping cart.
    private HashMap cart;

    //Total cost of item selected.
    private int totalCost = 0;

    //Current number of items.
    private int currentNumberOfItem = 0;

    //User's first name.
    private String firstName;

    //User's last name.
    private String lastName;

    //User's contact.
    private String contact;

    public Buyer(String username, String password, String firstName, String lastName, String phone, String email) {

        super(username, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = phone;
    }

    /**
     * adds a product to the cart
     * @param productIndex Index of the product.
     * @param sellerID ID of seller who is selling the product.
     */
    public void addToCart(int productIndex, String sellerID) {}

    /**
     * checks out the cart
     */
    public void buyAllAvailable() {}

    /**
     * Method to create a buyer account.
     */
    public void create() {}

    /**
     * Method to get the First Name.
     * @return The First name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method to get the Last name.
     * @return The lat attack.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method to get user's contact
     * @return user's contact.
     */
    public String getContact() {
        return contact;
    }

    /**
     * Method to get the buyer's cart.
     * @return This buyer's cart.
     */
    public HashMap getCart() {
        return cart;
    }

}
