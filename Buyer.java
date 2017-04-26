package C212Amazon;

import java.util.HashMap;

/**
 * Buyer
 * a Buyer account
 * Nicholas de la Espriella
 * 4/13/2017
 */
public class Buyer extends Account {

    //Shopping cart.
    private HashMap cart;
    //Total cost of item selected.
    private int totalCost;
    //Current number of items.
    private int currentNumberOfItem;
    //First RA you will talk to.
    private String firstName;
    //First RA with a meeting tomorrow.
    private String lastName;

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
     * Method to get the buyer's cart.
     * @return This buyer's cart.
     */
    public HashMap getCart() {
        return cart;
    }

}
