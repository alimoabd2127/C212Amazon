package C212Amazon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
    private ArrayList<Buyer> buyersArrayList = new ArrayList<>();
    private JButton editBuyerButton = new JButton("Edit Buyer");
    private JButton addBuyerButton = new JButton("Add Buyer");
    private JButton printBuyerHistoryButton = new JButton("Print History");
    private JButton refreshBuyersPanelButton = new JButton("Refresh");

    private JPanel sellersPanel = new JPanel();
    private JList<String> sellersList = new JList<>();
    private ArrayList<Seller> sellerArrayList = new ArrayList<>();
    private JButton editSellerButton = new JButton("Edit Seller");
    private JButton addSellerButton = new JButton("Add Seller");
    private JButton printSellerHistoryButton = new JButton("Print History");
    private JButton refreshSellerPanelButton = new JButton("Refresh");

    private JPanel inventoryPanel = new JPanel();
    private JList<String> itemList = new JList<>();
    private ArrayList<Item> itemArrayList = new ArrayList<>();
    private JButton addItemButton = new JButton("Add Item");
    private JButton editItemButton = new JButton("Edit Item");
    private JButton deleteItemButton = new JButton("Delete Item");
    private JButton refreshInventoryPanelButton = new JButton("Refresh");

    private JPanel historyPanel = new JPanel();
    private JList<String> historyList = new JList<>();
    private JButton refreshHistoryPanelButton = new JButton("Refresh");

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


        centerPanel.addTab("Buyers",null,buyersPanel,"View buyers");
        centerPanel.addTab("Sellers",null,sellersPanel,"View sellers");
        centerPanel.addTab("Inventory",null,inventoryPanel,"View inventory");
        centerPanel.addTab("History",null,historyPanel,"View history");

        setUpBuyersPanel();

        setUpSellersPanel();

        setUpInventoryPanel();

        setUpHistoryPanel();


        mainPanel.add(centerPanel, BorderLayout.CENTER);

        setUpEditInfoButton();
        setLogOffButton();

        setUpBuyerRefreshButton();
        setUpAddBuyerButton();
        setUpEditBuyerButton();
        setUpPrintBuyerHistoryButton();

        setUpSellerRefreshButton();
        setUpAddSellerButton();
        setUpEditSellerButton();
        setUpPrintSellerHistoryButton();

        setUpItemRefreshButton();
        setUpAddItemButton();
        setUpEditItemButton();
        setUpDeleteItemButton();

        setUpRefreshHistoryPanelButton();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setUpBuyersPanel() {

        buyersPanel.setLayout(new BorderLayout());

        JPanel buyersPanelsButtonPanel = new JPanel();
        buyersPanelsButtonPanel.setLayout(new GridLayout(9,2));

        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(refreshBuyersPanelButton);
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(addBuyerButton);
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(editBuyerButton);
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(new JPanel());
        buyersPanelsButtonPanel.add(printBuyerHistoryButton);


        buyersPanel.add(new JPanel(), BorderLayout.NORTH);
        buyersPanel.add(new JScrollPane(buyersList),BorderLayout.CENTER);
        buyersPanel.add(new JPanel(), BorderLayout.WEST);
        buyersPanel.add(new JPanel(), BorderLayout.SOUTH);
        buyersPanel.add(buyersPanelsButtonPanel, BorderLayout.EAST);

    }

    private void setUpBuyersJList() {}

    private void setUpSellersPanel() {
        sellersPanel.setLayout(new BorderLayout());

        JPanel sellersPanelsButtonPanel = new JPanel();
        sellersPanelsButtonPanel.setLayout(new GridLayout(9,2));

        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(refreshSellerPanelButton);
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(addSellerButton);
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(editSellerButton);
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(new JPanel());
        sellersPanelsButtonPanel.add(printSellerHistoryButton);

        sellersPanel.add(new JPanel(), BorderLayout.NORTH);
        sellersPanel.add(new JScrollPane(sellersList),BorderLayout.CENTER);
        sellersPanel.add(new JPanel(), BorderLayout.WEST);
        sellersPanel.add(new JPanel(), BorderLayout.SOUTH);
        sellersPanel.add(sellersPanelsButtonPanel, BorderLayout.EAST);
    }

    private void setUpSellersJList() {}

    private void setUpHistoryPanel() {
        historyPanel.setLayout(new BorderLayout());

        JPanel historyButtonPanel = new JPanel();
        historyButtonPanel.setLayout(new GridLayout(9,2));
        historyButtonPanel.add(new JPanel());
        historyButtonPanel.add(new JPanel());
        historyButtonPanel.add(new JPanel());
        historyButtonPanel.add(new JPanel());
        historyButtonPanel.add(new JPanel());
        historyButtonPanel.add(new JPanel());
        historyButtonPanel.add(new JPanel());
        historyButtonPanel.add(refreshHistoryPanelButton);
        historyButtonPanel.add(new JPanel());
        historyButtonPanel.add(new JPanel());
        historyButtonPanel.add(new JPanel());
        historyButtonPanel.add(new JPanel());
        historyButtonPanel.add(new JPanel());
        historyButtonPanel.add(new JPanel());
        historyButtonPanel.add(new JPanel());
        historyButtonPanel.add(new JPanel());

        historyPanel.add(new JScrollPane(historyList), BorderLayout.CENTER);
        historyPanel.add(new JPanel(), BorderLayout.NORTH);
        historyPanel.add(new JPanel(), BorderLayout.SOUTH);
        historyPanel.add(new JPanel(), BorderLayout.WEST);
        historyPanel.add(historyButtonPanel, BorderLayout.EAST);

    }

    private void setUpHistoryJList() {}

    private void setUpInventoryPanel() {
        inventoryPanel.setLayout(new BorderLayout());

        JPanel inventoryButtonPanel = new JPanel();
        inventoryButtonPanel.setLayout(new GridLayout(9,2));

        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(refreshInventoryPanelButton);
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(addItemButton);
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(editItemButton);
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(deleteItemButton);


        inventoryPanel.add(new JPanel(), BorderLayout.NORTH);
        inventoryPanel.add(new JScrollPane(itemList),BorderLayout.CENTER);
        inventoryPanel.add(new JPanel(), BorderLayout.WEST);
        inventoryPanel.add(new JPanel(), BorderLayout.EAST);
        inventoryPanel.add(new JPanel(), BorderLayout.SOUTH);
        inventoryPanel.add(inventoryButtonPanel, BorderLayout.EAST);
    }

    private void setUpInventoryJList() {}






    private void setUpEditInfoButton() {
        editInfoButton.addActionListener(e -> new AdminEditInfoWindow(admin));
    }

    private void setLogOffButton() {
        logoffButton.addActionListener(e -> dispose());
    }

    private void setUpBuyerRefreshButton() {
      //  refreshBuyersPanelButton.addActionListener(e -> );
    }

    private void setUpAddBuyerButton() {
        addBuyerButton.addActionListener(e -> new CreateBuyerWindow());
    }

    private void setUpEditBuyerButton() {
       // editBuyerButton.addActionListener(e -> new BuyerEditInfoWindow());
    }

    private void setUpPrintBuyerHistoryButton() {
      //  printBuyerHistory
    }

    private void setUpSellerRefreshButton() {
      //  refreshBuyersPanelButton.addActionListener(e -> );
    }

    private void setUpAddSellerButton() {
        addSellerButton.addActionListener(e -> new CreateSellerWindow());
    }

    private void setUpEditSellerButton() {
        //editSellerButton.addActionListener(e -> new SellerEditInfoWindow());
    }

    private void setUpPrintSellerHistoryButton() {
        //printSellerHistory
    }

    private void setUpItemRefreshButton() {
        //refreshBuyersPanelButton.addActionListener(e -> );
    }

    private void setUpAddItemButton() {
        addItemButton.addActionListener(e -> new NewItemWindow(0));
    }

    private void setUpEditItemButton() {
     //   editItemButton.addActionListener(e -> new ItemEditInfoWindow());
    }

    private void setUpDeleteItemButton() {
        //deleteItemButton
    }

    private void setUpRefreshHistoryPanelButton() {
       // refreshHistoryPanelButton
    }







    public static void main(String[] args) {
        JFrame jf = new AdminFrontWindow(new Admin(1,"d","D","d"));
    }

}
