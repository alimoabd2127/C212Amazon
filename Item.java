package C212Amazon;

/**
 * A class to represent an item in the cart
 * @author Syed Turab Ali Jafri
 * 4/26/2017
 */
public class Item {

    private int productID;
    private String prodName;
    private float price;
    private int sellerID;

    public Item(int productID, String prodName, float price, int sellerID) {

        this.productID = productID;
        this.prodName = prodName;
        this.price = price;
        this.sellerID = sellerID;
    }

    public int getProductID() {
        return productID;
    }

    public String getProdName() {
        return prodName;
    }

    public float getPrice() {
        return price;
    }

    public int getSellerID() {
        return sellerID;
    }

}
