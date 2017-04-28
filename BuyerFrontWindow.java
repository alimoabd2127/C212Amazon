package C212Amazon;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for buyer's front gui
 * @author Syed Turab Ali Jafri
 * 4/28/2017
 */
public class BuyerFrontWindow extends FrontWindow {


    private Buyer buyer;

    private SellerDataWriter sellerdatawriter = new SellerDataWriter();
    private SellerDataReader sellerdatareader = new SellerDataReader();
    private ItemDataWriter itemdatawriter = new ItemDataWriter();
    private ItemDataReader itemdatareader = new ItemDataReader();

    private JTextField searchBar = new JTextField(40);
    private JButton searchButton = new JButton("Search");
    private JPanel searchBarPanel = new JPanel();
    private BufferedImage groupLogo;
    private JLabel groupLogoLabel;

    private JButton logoffButton = new JButton("Log off");
    private JButton cartButton = new JButton("Cart");
    private JButton editInfoButton = new JButton("Edit Info");
    private JButton historyButton = new JButton("History");
    private JPanel buttonPanel = new JPanel();

    private ArrayList<Item> searchedItemArrayList = new ArrayList<>();
    private JList<String> searchedItemList = new JList<>();
    private JPanel listPanel = new JPanel();

    private JButton clearListButton = new JButton("Clear");
    private JButton addToCartButton = new JButton("Add to Cart");

    private JPanel northPanel = new JPanel();
    private JPanel southPanel = new JPanel();

    public BuyerFrontWindow(Buyer buyer) {

        super("Market 46");

        this.buyer = buyer;

        setAllPanels();

    }


    private void setAllPanels() {
        mainPanel.setLayout(new BorderLayout());

//        try {
//            groupIcon = ImageIO.read(new File("C:\\Users\\Turab\\Downloads\\thg.jpg"));
//            groupImage = new JLabel(new ImageIcon(groupIcon));
//        }
//
//
//        catch(IOException e) {
//            e.printStackTrace();
//        }

        northPanel.setLayout(new BorderLayout());
        //northPanel.add(groupImage , BorderLayout.WEST);

        setSearchBarPanel();
        setTopRightButtonPanel();
        setListPanel();
        setSouthPanel();

        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(new JPanel(), BorderLayout.WEST);
        mainPanel.add(listPanel, BorderLayout.CENTER);
        mainPanel.add(new JPanel(), BorderLayout.EAST);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        clearButtonOperation();
        setSearchButtonConfig();

        add(mainPanel);
        setVisible(true);
    }

    private void setSearchBarPanel() {

        searchBarPanel.add(searchBar);
        searchBarPanel.add(searchButton);

        searchBar.setFont(new Font(null,0,20));
        searchButton.setFont(new Font(null, 0, 20));

        JPanel searchPanel = new JPanel();

        searchPanel.setLayout(new GridLayout(5,1));

        searchPanel.add(new JPanel());
        searchPanel.add(new JPanel());
        searchPanel.add(searchBarPanel);
        searchPanel.add(new JPanel());
        searchPanel.add(new JPanel());

        northPanel.add(searchPanel, BorderLayout.CENTER);
    }


    private void setTopRightButtonPanel() {

        buttonPanel.setLayout(new GridLayout(8,2));

        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());

        buttonPanel.add(historyButton);
        buttonPanel.add(new JPanel());
        historyButton.addActionListener(e -> {
            new BuyerHistoryWindow(buyer.getUniqueID());
        });

        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());

        buttonPanel.add(cartButton);
        buttonPanel.add(new JPanel());
        cartButton.addActionListener(e -> {
            new CartWindow(buyer.getCart());
        });

        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());

        buttonPanel.add(editInfoButton);
        buttonPanel.add(new JPanel());
        editInfoButton.addActionListener(e -> new BuyerEditInfoWindow(buyer));

        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());

        buttonPanel.add(logoffButton);
        buttonPanel.add(new JPanel());
        logoffButton.addActionListener(e -> {
            dispose();
            new MainWindow();
        });

        northPanel.add(buttonPanel, BorderLayout.EAST);
    }

    private void setListPanel() {
        listPanel.setLayout(new BorderLayout());

        searchedItemList.setFont(new Font(null, Font.BOLD, 15));
        listPanel.add(new JScrollPane(searchedItemList), BorderLayout.CENTER);
        listPanel.add(new JPanel(), BorderLayout.NORTH);
        listPanel.add(new JPanel(), BorderLayout.SOUTH);

    }

    private void setSouthPanel() {
        southPanel.setLayout(new GridLayout(1,7));
        southPanel.add(new JPanel());
        southPanel.add(clearListButton);
        southPanel.add(new JPanel());
        southPanel.add(new JPanel());
        southPanel.add(addToCartButton);
        southPanel.add(new JPanel());
    }

    private void clearButtonOperation() {

        clearListButton.addActionListener(e -> searchedItemList.setModel(new DefaultListModel<>()));
        searchedItemList.ensureIndexIsVisible(0);
    }

    private void setSearchButtonConfig() {
        searchButton.addActionListener(e -> {
//            if((searchedItemArrayList = itemdatareader.searchItems("inventory", searchBar.getText())).size() == 0) {
//                searchedItemList.setModel(new DefaultListModel<>());
//                }
//            else {
            DefaultListModel<String> itemStrings = new DefaultListModel<>();
//                for(Item item: searchedItemArrayList) {
//                    itemStrings.addElement(item.toString());
//                }
            itemStrings.addElement("TEST");
            itemStrings.addElement("TEST");
            itemStrings.addElement("TEST");
            itemStrings.addElement("TEST");
            itemStrings.addElement("TEST");
            itemStrings.addElement("TEST");
            itemStrings.addElement("TEST");
            itemStrings.addElement("TEST");
            searchedItemList.setModel(itemStrings);
            for(int i = 0; i < itemStrings.size(); i++) {
                searchedItemList.ensureIndexIsVisible(i);
                System.out.println("S");
            }
//            }
//        }
        });
    }

    public static void main(String[] args) {
        Buyer mock = new Buyer(100, "mockmock", "mockmockmock", "Mock", "Mock",
                "9999999999", "mock@mock.mock");

        //mock.

        JFrame jf = new BuyerFrontWindow(mock);
    }

}
