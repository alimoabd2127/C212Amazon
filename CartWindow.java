package C212Amazon;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

/**
 * Cart's interface.
 * @author Syed Turab Ali Jafri
 * 4/26/2017
 */
public class CartWindow extends FrontWindow{

    private HashMap<Item, Integer> currentCart;
    private JLabel cartHeader = new JLabel("Cart");
    private JList<String> cartList = new JList<>();
    private JButton cancelButton = new JButton("Cancel");
    private JButton removeButton = new JButton("Remove");
    private JButton confirmButton = new JButton("Confirm");

    public CartWindow(HashMap<Item, Integer> cart) {

        super("Cart");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        currentCart = cart;

        mainPanel.setLayout(new BorderLayout());

        cartHeader.setHorizontalAlignment(JLabel.CENTER);
        cartHeader.setFont(new Font(Font.SERIF, 0, 70));
        mainPanel.add(cartHeader, BorderLayout.NORTH);

        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BorderLayout());

        cartList.setListData(getCartList());

        cartPanel.add(new JPanel(), BorderLayout.NORTH);
        cartPanel.add(new JScrollPane(cartList), BorderLayout.CENTER);
        cartPanel.add(new JPanel(), BorderLayout.SOUTH);

        mainPanel.add(cartPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 7));

        buttonPanel.add(new JPanel());
        buttonPanel.add(cancelButton);
        buttonPanel.add(new JPanel());
        buttonPanel.add(removeButton);
        buttonPanel.add(new JPanel());
        buttonPanel.add(confirmButton);
        buttonPanel.add(new JPanel());


        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(new JPanel(), BorderLayout.WEST);
        mainPanel.add(new JPanel(), BorderLayout.EAST);

        add(mainPanel);
        setVisible(true);

    }

    private Vector<String> getCartList() {
        Vector<String> cartList = new Vector<>();
        if(currentCart == null || currentCart.size() == 0) {
            cartList.add("Cart is empty");
        }
        else {
            Set<Item> keys = currentCart.keySet();

            for (Item item : keys) {

                cartList.add("(" + currentCart.get(item) + ") "
                        + item.getProdName() + " ");
            }
        }

        return cartList;

    }

    public static void main(String[] args) {
        JFrame s = new CartWindow(new HashMap<>());
    }

}

