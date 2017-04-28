/**
 * Cart
 * Cart represents a buyers cart
 */

package C212Amazon;

import java.util.HashMap;
import java.util.Date;

public class Cart {

    private HashMap<Item, Integer> cart;    // Shopping cart.
    private int buyerID;

    public Cart (int buyerID) {
        this.buyerID = buyerID;

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
        PurchaseHistoryDataReader phdr = new PurchaseHistoryDataReader();
        int cartID = phdr.getCartId();
        // 2. iterate over every item in cart
        for (Item item : Keys) {

            // 3. get parameters from item
            int productID = item.getProductID();
            int qty = cart.getKey();


            // 4. write the current data in the cart to the database
            purchaseHistoryWriter(cartID, buyerID, productID, qty);
        }

        // 5. clear the cart
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




