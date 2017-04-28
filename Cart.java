/**
 * Cart
 * Cart represents a buyers cart
 */

package C212Amazon;

import java.util.HashMap;
import java.util.Date;

public class Cart {

    private HashMap<Item, Integer> cart;    // Shopping cart.

    public Cart () {


    }


    /**
     * adds a product to the cart
     * @param item An Item object
     */
    public void addToCart(Item item) {
        cart.put(item);

    }



    public void checkout() {
        // 1. get unique cartID
            // call the reader to get the latest value and + 1

        // 2. iterate over every item in cart
        for (Item item : Keys) {

            // 3. get item parameters
            Int qty = cart.getKey();



            // 4.
            purchaseHistoryWriter()
        }


        cart.clear();

    }


    /**
     * Method to get the cart
     * @return This cart
     */
    public HashMap<Item, Integer> getCart() {
        return cart;
    }


}




