/**
 * Buyer
 * a buyer account class that represents a buyer
 * Nicholas de la Espriella
 * 4/13/2017
 */

package C212Amazon;

import java.util.HashMap;
import java.util.Date;

public class Buyer extends Account {

    // parameters
    private Cart cart;                      // Cart class
    private int totalCost = 0;              // Total cost of item selected.
    private int currentNumberOfItem = 0;    // Current number of items.
    private String firstName;               // User's first name.
    private String lastName;                // User's last name.
    private String phone;                   // User's contact.

    // constructor
    public Buyer(int uniqueID, String username, String password, String firstName, String lastName, String phone, String email) {

        super(uniqueID, username, password, email);
        this.firstName = firstName;         // first name
        this.cart = new Cart(uniqueID);
        this.lastName = lastName;           // last name
        this.phone = phone;                 // phone
    }

    /**
     * Method to get the first name.
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method to get the last name
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method to get user's contact
     * @return user's contact
     */
    public String getPhone() {
        return phone;
    }

    public Cart getCart() { return cart; }

}
