package C212Amazon;

/**
 * Admin
 * An admin account
 * Nicholas de la Espriella
 * 4/13/2017
 */

public class Admin extends Account {

    public Admin(int uniqueID, String username, String password, String emailAddress) {
        super(uniqueID, username, password, emailAddress);
    }

    /**
     * adds a quantity to the given index
     * @param index
     * @param quantity
     */
    public void addToQuantity(int index, int quantity) {}

    /**
     * removes a quantity from a given index
     * @param index
     * @param quantity
     */
    public void removeFromQuantity(int index, int quantity) {}

    /**
     * updates an item detail
     * @param index
     * @param detail
     */
    public void updateItemDetail(int index, String detail) {}

    /**
     * deletes an Item
     * @param index
     */
    public void deleteItem(int index) {}
}

