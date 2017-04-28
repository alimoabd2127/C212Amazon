package C212Amazon;

import javax.swing.*;
import java.awt.*;
/**
 * AdminFront
 * The front page for the admin
 * Created by Turab on 4/22/2017.
 */
public class AdminFrontWindow extends FrontWindow{

    private Admin admin = null;

    private JTabbedPane centerPanel = new JTabbedPane();

    private JButton logoffButton = new JButton("Log Off");
    private JButton editInfoButton = new JButton("Edit Info");

    private JPanel buyersPanel = new JPanel();
    private JList<String> buyersList = new JList<>();
    private JButton editBuyerButton = new JButton("Edit Buyer");
    private JButton deleteBuyerButton = new JButton("Delete Buyer");
    private JButton printBuyerHistory = new JButton("Print History");

    private JPanel sellersPanel = new JPanel();
    private JList<String> sellersList = new JList<>();
    private JButton editSellerButton = new JButton("Edit Seller");
    private JButton deleteSellerButton = new JButton("Delete Seller");
    private JButton printSellerHistory = new JButton("Print History");

    private JPanel inventoryPanel = new JPanel();
    private JList<String> itemList = new JList<>();
    private JButton addItemButton = new JButton("Add Item");
    private JButton editItemButton = new JButton("Edit Item");
    private JButton deleteItemButton = new JButton("Delete Item");

    private JPanel historyPanel = new JPanel();
    private JList<String> historyList = new JList<>();

    public AdminFrontWindow(Admin admin) {

        super("Market 46");

        this.admin= admin;

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

        buyersPanel.setLayout(new BorderLayout());

        JPanel buyersPanelsButtonPanel = new JPanel();
        buyersPanelsButtonPanel.setLayout(new GridLayout(9,2));
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(editBuyerButton);
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(deleteBuyerButton);
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(printBuyerHistory);
        buyersPanelsButtonPanel.add(new JPanel());

        buyersPanel.add(new JPanel(), BorderLayout.NORTH);
        buyersPanel.add(new JScrollPane(buyersList),BorderLayout.CENTER);
        buyersPanel.add(new JPanel(), BorderLayout.WEST);
        buyersPanel.add(new JPanel(), BorderLayout.EAST);
        buyersPanel.add(new JPanel(), BorderLayout.SOUTH);
        buyersPanel.add(buyersPanelsButtonPanel, BorderLayout.EAST);
        buyersPanel.setLayout(new BorderLayout());

        buyersPanel.setLayout(new BorderLayout());

        JPanel sellersPanelsButtonPanel = new JPanel();
        sellersPanelsButtonPanel.setLayout(new GridLayout(9,2));
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(editSellerButton);
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(deleteSellerButton);
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(printSellerHistory);
        sellersPanelsButtonPanel.add(new JPanel());

        sellersPanel.add(new JPanel(), BorderLayout.NORTH);
        sellersPanel.add(new JScrollPane(buyersList),BorderLayout.CENTER);
        sellersPanel.add(new JPanel(), BorderLayout.WEST);
        sellersPanel.add(new JPanel(), BorderLayout.EAST);
        sellersPanel.add(new JPanel(), BorderLayout.SOUTH);
        sellersPanel.add(buyersPanelsButtonPanel, BorderLayout.EAST);
        sellersPanel.setLayout(new BorderLayout());

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