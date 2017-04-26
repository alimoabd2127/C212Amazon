package C212Amazon;

import java.io.File;

/**
 * Market
 * The market class
 * Nicholas de la Espriella
 * 4/13/2017
 */
public class Market {

    // Writer for buyer's data.
    private BuyerDataWriter buyerDataWriter;

    // Writer for inventory
    //private InventoryWriter inventoryWriter;

    // Writer for history
    //private HistoryWriter historyWriter;

    // Writer for seller's data
    //private SellerDataWriter sellerDataWriter;

    /**
     * adds a quantity to a given index
     * @param index Index of current product.
     * @param quantity Quantity to be added.
     */
    public void addToQuantity(int index, int quantity) {}

    /**
     * removes a quantity from a given index
     * @param index Index of the current product.
     * @param quantity Quantity to be removed.
     */
    public void removeFromQuantity(int index, int quantity) {}

    /**
     * updates an item at the given index
     * @param index Index of the current product.
     * @param detail Details to be added.
     */
    public void updateItemDetail(int index, String detail) {}

    /**
     * deletes an item from the given index
     * @param index INdex of the item.
     */
    public void deleteItem(int index) {}

    /**
     * adds a buyer to the market
     * @param buyer Buyer to be added.
     */
    public void addBuyer(Buyer buyer) {}

    /**
     * adds a seller to the market
     * @param seller Seller to be added.
     */
    //public void addSeller(Seller seller) {}

    /**
     * verifies the buyer exists
     * @param username Buyer's username entered.
     * @param pass Buyer's password entered.
     */
    public void verifyBuyer(String username, String pass) {}

    /**
     * verifies the seller exeists
     * @param username Seller's username entered.
     * @param pass Seller's password entered.
     */
    public void verifySeller(String username, String pass) {}

}
