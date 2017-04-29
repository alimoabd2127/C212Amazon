package C212Amazon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Interface for a seller.
 * @author Syed Turab Ali Jafri
 * 4/26/2017
 */
public class SellerFrontWindow extends FrontWindow {

    private Seller seller = null;

    private ItemDataReader itemdatareader = new ItemDataReader();
    private PurchaseHistoryDataReader historydatareader = new PurchaseHistoryDataReader();
    private DataWriter itemdatawriter = new DataWriter();

    private JTabbedPane centerPanel = new JTabbedPane();

    private JButton logoffButton = new JButton("Log Off");
    private JButton editInfoButton = new JButton("Edit Info");

    private JPanel inventoryPanel = new JPanel();
    private ArrayList<Item> itemArrayList = new ArrayList<>();
    private JList<String> itemList = new JList<>();
    private JButton addItemButton = new JButton("Add Item");
    private JButton editItemButton = new JButton("Edit Item");
    private JButton deleteItemButton = new JButton("Delete Item");
    private JButton refreshItemButton = new JButton("Refresh");

    private JPanel historyPanel = new JPanel();
    private JList<String> historyList = new JList<>();
    private JButton refreshHistoryButton = new JButton("Refresh");

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

        setUpHistoryJList();
        setUpInventoryJList();


        mainPanel.add(centerPanel, BorderLayout.CENTER);

        setLogOffButton();
        setEditInfoButton();
        setAddItemButton(seller.getUniqueID());
        setEditItemInfoButton();
        setDeleteItemButton();
        setRefreshHistoryButton();
        setRefreshItemButton();

        setLocationRelativeTo(null);
        setVisible(true);

        addItemButton.addActionListener(e -> setAddItemButton(seller.getUniqueID()));
    }

    private void setUpHistoryJList() {

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
        historyButtonPanel.add(refreshHistoryButton);
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

        setUpHistoryPanel();

    }

    private void setUpInventoryJList() {

        inventoryPanel.setLayout(new BorderLayout());

        JPanel inventoryButtonPanel = new JPanel();
        inventoryButtonPanel.setLayout(new GridLayout(8,2));
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(new JPanel());
        inventoryButtonPanel.add(refreshItemButton);
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

        refreshInventoryJList();


    }

    private void refreshInventoryJList() {

        itemArrayList = itemdatareader.getInventory("inventory", seller.getUniqueID());

        DefaultListModel<String> itemStrings = new DefaultListModel<>();

        if(itemArrayList.size() == 0) {}
        else {

            for (Item item : itemArrayList) {
                itemStrings.addElement(item.toString());
            }


            itemList.setModel(itemStrings);

            for (int i = 0; i < itemStrings.size(); i++) {
                itemList.ensureIndexIsVisible(i);
            }

        }
    }

    private void setRefreshItemButton() {
        refreshItemButton.addActionListener(e -> refreshInventoryJList());
    }

    private void setLogOffButton() {
        logoffButton.addActionListener(e -> {
            dispose();
            new MainWindow();
        });
    }

    private void setEditInfoButton() {
        editInfoButton.addActionListener(e -> new SellerEditInfoWindow(seller));
    }

    private void setEditItemInfoButton() {

        editItemButton.addActionListener(e -> {

            int selectedIndex = itemList.getSelectedIndex();
            System.out.println(selectedIndex);

            if(selectedIndex == -1) {}
            else {
            new ItemEditInfoWindow(itemArrayList.get(selectedIndex));
            }
        });
    }

    private void setAddItemButton(int sellerID) {
        addItemButton.addActionListener(e -> {
            new NewItemWindow(sellerID);
        });
    }

    private void setDeleteItemButton() {
        deleteItemButton.addActionListener(e -> {
            int selectedIndex = itemList.getSelectedIndex();

            if(selectedIndex == -1) {}
            else {
                itemdatawriter.setDb("inventory","quantity",itemArrayList.get(selectedIndex).getProductID(), 0);
                refreshInventoryJList();
            }
        }
        );
    }

    private void setUpHistoryPanel() {

        ArrayList<String> history = historydatareader.getSoldHistory("purchasehistory", seller.getUniqueID());

        DefaultListModel<String> historyStrings = new DefaultListModel<>();

        if(history == null) {
            historyStrings.addElement("No History Found!");
        }

        else {

            for (String record : history) {
                historyStrings.addElement(record);
            }

            historyList.setModel(historyStrings);

            for (int i = 0; i < historyStrings.size(); i++) {
                historyList.ensureIndexIsVisible(i);
            }
        }
    }

    private void setRefreshHistoryButton() {
        refreshHistoryButton.addActionListener(e -> setUpHistoryPanel());
    }

}
