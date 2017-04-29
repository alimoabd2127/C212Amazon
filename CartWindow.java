/**
 * CartWindow
 * Cart's interface
 * @author Syed Turab Ali Jafri
 * 4/26/2017
 */

package C212Amazon;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;


public class CartWindow extends FrontWindow{


    private Cart currentCart;
    private Set<Item> itemSet;
    private JLabel cartHeader = new JLabel("Cart");
    private JList<String> cartList = new JList<>();
    private JButton cancelButton = new JButton("Cancel");
    private JButton removeButton = new JButton("Remove");
    private JButton confirmButton = new JButton("Confirm");

    // constructor
    public CartWindow(Cart cart) {

        super("Cart");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        currentCart = cart;
        itemSet = currentCart.getCart().keySet();
        cartHeader.setHorizontalAlignment(JLabel.CENTER);
        cartHeader.setFont(new Font(Font.SERIF, 0, 70));
//        cartList.setListData(getCartList());



        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(cartHeader, BorderLayout.NORTH);

        JPanel cartPanel = new JPanel();

        cartPanel.setLayout(new BorderLayout());
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


        initializeCartList();

        setCancelButton();
        setRemoveButton();
        setConfirmButton();

        setLocationRelativeTo(null);
        setVisible(true);

    }

    private Vector<String> getCartList() {
        Vector<String> cartList = new Vector<>();
        if(currentCart == null || currentCart.getCart().size() == 0) {
            cartList.add("Cart is empty");
        }
        else {
            Set<Item> keys = currentCart.getCart().keySet();

            for (Item item : keys) {

                cartList.add("(" + currentCart.getCart().get(item) + ") "
                        + item.getProdName() + " ");
            }
        }

        return cartList;

    }

    private void setCancelButton() {
        cancelButton.addActionListener(e -> {
            dispose();
        });
    }

    private void setRemoveButton() {
        removeButton.addActionListener(e -> {
            int selectedIndex = cartList.getSelectedIndex();

            if(selectedIndex == -1) {
            }
            else{
                String selectedItemString = cartList.getSelectedValue();
                Item actualSelectedItem = null;

                for(Item item: itemSet) {
                    String itemString = item.toString();
                    Integer itemCount = currentCart.getCart().get(item);
                    String itemCountString = itemCount == null? "0": itemCount+"";
                    if(("(" + itemCountString + ")" + "   " + item.toString()).equals(selectedItemString)) {
                        actualSelectedItem = item;
                    }
                }
                itemSet.remove(actualSelectedItem);
                currentCart.getCart().remove(actualSelectedItem);
                initializeCartList();
                refreshList();
            }
        });
    }

    private void refreshList() {
        DefaultListModel<String> currentList = (DefaultListModel)(cartList.getModel());

        if(currentList == null) {}
        else{
            for(int i = 0; i < currentList.size(); i++) {
                cartList.ensureIndexIsVisible(i);
            }
        }
    }

    private void initializeCartList() {
        itemSet = currentCart.getCart().keySet();

        if(itemSet.size() == 0) {
            cartList.setModel(new DefaultListModel<String>());
        }
        else {
            DefaultListModel<String> cartStringList = new DefaultListModel<>();

            for(Item item: itemSet) {
                Integer count = currentCart.getCart().get(item);
                String countString = count == null? 0 + "": count + "";
                cartStringList.addElement("(" + countString + ")" + "   " + item.toString());
            }

            cartList.setModel(cartStringList);

            for(int i = 0; i < cartStringList.size(); i++) {
                cartList.ensureIndexIsVisible(i);
            }
        }
    }

    private void setConfirmButton() {
        confirmButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();

            if(!currentCart.checkout()) {
                jop.showMessageDialog(null, "Cart is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                jop.showMessageDialog(null, "All items bought successfully", "Purchase Complete", JOptionPane.INFORMATION_MESSAGE);
                initializeCartList();
                dispose();
            }
        });

    }

}

