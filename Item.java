package C212Amazon;

/**
 * A class to represent an item in the cart
 * @author Syed Turab Ali Jafri
 * 4/26/2017
 */
public class Item {

    private int productID;
    private String prodName;
    private String description;
    private String category;
    private double price;
    private int quantity;
    private int sellerID;

    public Item(int productID, String prodName, String description, String category, double price, int quantity, int sellerID) {

        this.productID = productID;
        this.prodName = prodName;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.sellerID = sellerID;
    }

    public int getProductID() {
        return productID;
    }

    public String getProdName() {
        return prodName;
    }

    public double getPrice() {
        return price;
    }

    public int getSellerID() {
        return sellerID;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object obj) {

        if(!(obj instanceof Item)) {
            return false;
        }
        else {
            return this.productID == ((Item) obj).getProductID();
        }
    }

    public String toString() {
        return prodName + "    " + description + "    " + category + "     $" + price;
    }

    public String toString2() {
        return prodName + "     $" + price + "    Seller: " + sellerID;
    }
}
