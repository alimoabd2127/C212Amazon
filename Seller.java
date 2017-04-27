package C212Amazon;

/**
 * Seller
 * A seller account class
 * Nicholas de la Espriella
 * 4/13/2017
 */
public class Seller extends Account {

    private String name;
    private String phone;
    private String email;

    public Seller(int uniqueID, String username, String password, String name, String phone, String email) {

        super(uniqueID, username, password, email);
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Adds a quantity to a given index
     * @param index Index of product.
     * @param quantity quantity to be added.
     */
    public void addToQuantity(int index, int quantity) {}

    /**
     * Removes a quantity from the given index
     * @param index Index of product.
     * @param quantity quantity to be removed.
     */
    public void removeFromQuantity(int index, int quantity) {}

    /**
     * Updates an item's decription at the given index
     * @param index Index of the product.
     * @param detail Decription for the item.
     */
    public void updateItemDescription(int index, String detail) {}

    /**
     * deletes an item from the list
     * @param index Product's index.
     */
    public void deleteItem(int index) {}

    /**
     * Method to create a seller account.
     */
    public void create() {}

    public String getName() {
        return name;
    }
}
