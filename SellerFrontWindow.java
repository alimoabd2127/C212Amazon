package C212Amazon;

import javax.swing.*;
import java.awt.*;

/**
 * Interface for a seller.
 * @author Syed Turab Ali Jafri
 * 4/26/2017
 */
public class SellerFrontWindow extends FrontWindow {

    private Seller seller = null;

    private JTabbedPane centerPanel = new JTabbedPane();

    private JButton logoffButton = new JButton("Log Off");
    private JButton editInfoButton = new JButton("Edit Info");

    private JPanel inventoryPanel = new JPanel();
    private JList<String> itemList = new JList<>();
    private JButton addItemButton = new JButton("Add Item");
    private JButton editItemButton = new JButton("Edit Item");
    private JButton deleteItemButton = new JButton("Delete Item");

    private JPanel historyPanel = new JPanel();
    private JList historyList = new JList();

    public SellerFrontWindow(Seller seller) {

        super("Market 46");

        this.seller = seller;

        mainPanel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,1));

        buttonPanel.add(new JPanel());
        buttonPanel.add(logoffButton);
        buttonPanel.add(new JPanel());
        buttonPanel.add(editInfoButton);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(buttonPanel, BorderLayout.EAST);

        mainPanel.add(northPanel, BorderLayout.NORTH);

        centerPanel.addTab("Inventory",null,inventoryPanel,"View inventory");
        centerPanel.addTab("History",null,historyPanel,"View history");

        inventoryPanel.setLayout(new BorderLayout());

        JPanel inventoryButtonPanel = new JPanel();
        inventoryButtonPanel.setLayout(new GridLayout(9,2));
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(addItemButton);
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(editItemButton);
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(deleteItemButton);
        inventoryButtonPanel.add(new JPanel());

        inventoryPanel.add(new JPanel(), BorderLayout.NORTH);
        inventoryPanel.add(new JScrollPane(itemList),BorderLayout.CENTER);
        inventoryPanel.add(new JPanel(), BorderLayout.WEST);
        inventoryPanel.add(new JPanel(), BorderLayout.EAST);
        inventoryPanel.add(new JPanel(), BorderLayout.SOUTH);
        inventoryPanel.add(inventoryButtonPanel, BorderLayout.EAST);

        historyPanel.setLayout(new BorderLayout());
        historyPanel.add(new JScrollPane(historyList), BorderLayout.CENTER);
        historyPanel.add(new JPanel(), BorderLayout.NORTH);
        historyPanel.add(new JPanel(), BorderLayout.SOUTH);
        historyPanel.add(new JPanel(), BorderLayout.WEST);
        historyPanel.add(new JPanel(), BorderLayout.EAST);


        mainPanel.add(centerPanel, BorderLayout.CENTER);

        mainPanel.add(new JPanel(), BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }


}
