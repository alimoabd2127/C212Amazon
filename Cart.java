/**
 * Cart
 * Cart represents a buyers cart
 */

package C212Amazon;

import java.util.HashMap;
import java.util.Set;
import java.util.Date;

public class Cart {

    private HashMap<Item, Integer> cart;    // Shopping cart.
    private PurchaseHistoryDataWriter purchaseHistoryWriter = new PurchaseHistoryDataWriter();

    public Cart (){
    }

    /**
     * adds a product to the cart
     * @param item An Item object
     */
    public void addToCart(Item item) {

        if(cart.get(item) == null) {
            cart.put(item, 1);
        }
        else {
            cart.put(item, cart.get(item) + 1);
        }
    }

    public void checkout() {
        // 1. get unique cartID
            // call the reader to get the latest value and + 1

        Set<Item> keys = cart.keySet();

        // 2. iterate over every item in cart
        for (Item item : keys) {

            // 3. get item parameters
            int qty = cart.get(item);
            cart.remove(item);

            // 4.
            //purchaseHistoryWriter
        }
    }

    /**
     * Method to get the cart
     * @return This cart
     */
    public HashMap<Item, Integer> getCart() {
        return cart;
    }

}




