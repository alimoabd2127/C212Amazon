package C212Amazon;

import java.util.HashMap;
import java.util.Set;
import java.util.Date;

/**
 * Cart
 * Cart represents a buyers cart
 */
public class Cart {

    private int buyerID;
    private HashMap<Item, Integer> cart = new HashMap<>();    // Shopping cart.

    private PurchaseHistoryDataWriter purchaseHistoryDataWriter = new PurchaseHistoryDataWriter();
    private PurchaseHistoryDataReader purchaseHistoryDataReader = new PurchaseHistoryDataReader();
    private DataReader dataReader = new DataReader();
    private DataWriter dataWriter = new DataWriter();


    public Cart (int buyerID){
        this.buyerID = buyerID;
    }

    /**
     * adds a product to the cart
     * @param item An Item object
     */
    public void addToCart(Item item) {

        if(cart.get(item) == null) {
            System.out.println(item);
            cart.put(item, 1);
        }
        else {
            System.out.println(item);
            cart.put(item, cart.get(item) + 1);
        }
    }

    public boolean checkout() {
        // 1. get unique cartID
            // call the reader to get the latest value and + 1
        int cartID = purchaseHistoryDataReader.getCartId();
        Set<Item> keys = cart.keySet();

        if(keys.size() == 0) {
            return false;
        }
        else {
            // 2. iterate over every item in cart
            for (Item item : keys) {

                // 3. get item parameters
                int qty = cart.get(item) == null ? 0 : cart.get(item);
                int productID = item.getProductID();
                cart.remove(item);

                // 4. write cart to purchaseHistory database
                purchaseHistoryDataWriter.createPurchaseHistory(cartID, buyerID, productID, qty);
                String testCurrentQuantity = "" + (dataReader.getDb("inventory", "quantity", productID));

                int currentQuantity = testCurrentQuantity.equals("")? 0 : Integer.parseInt(testCurrentQuantity);
                System.out.println(currentQuantity);
                int newQuantity = (currentQuantity - qty) < 0 ? 0 : currentQuantity - qty;
                dataWriter.setDb("inventory", "quantity", productID, newQuantity);
            }
            return true;
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




