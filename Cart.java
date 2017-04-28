/**
 * Cart
 * Cart represents a buyers cart
 */

package C212Amazon;

import java.util.HashMap;
import java.util.Set;
import java.util.Date;

public class Cart {
    private int buyerID;
    private HashMap<Item, Integer> cart;    // Shopping cart.
    private PurchaseHistoryDataWriter purchaseHistoryWriter = new PurchaseHistoryDataWriter();
    private PurchaseHistoryDataReader purchaseHistoryDataReader = new PurchaseHistoryDataReader();

    public Cart (int buyerID){
        this.buyerID = buyerID;
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
        int cartID = purchaseHistoryDataReader.getCartId();
        Set<Item> keys = cart.keySet();

        // 2. iterate over every item in cart
        for (Item item : keys) {

            // 3. get item parameters
            int qty = cart.keySet();
            int productID = item.getProductID();
            cart.remove(item);

            // 4.
            purchaseHistoryWriter(cartID, buyerID, productID, qty);
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




