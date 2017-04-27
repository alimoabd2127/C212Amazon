package C212Amazon;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author Syed Turab Ali Jafri
 */
public class BuyerFrontWindow extends FrontWindow {


    private Buyer buyer;

    private ArrayList<Item> searchedItemList = new ArrayList<>();

    private JTextField searchBar = new JTextField(50);
    private JButton searchButton = new JButton("Search");
    private JPanel searchBarPanel = new JPanel();
    private BufferedImage groupIcon;
    private JLabel groupImage;

    private JButton logoffButton = new JButton("Log off");
    private JButton cartButton = new JButton("Cart");
    private JButton editInfoButton = new JButton("Edit Info");
    private JPanel buttonPanel = new JPanel();

    private JList<String> productList = new JList<>();
    private JPanel listPanel = new JPanel();

    private JButton clearListButton = new JButton("Clear");
    private JButton addToCartButton = new JButton("Add to Cart");

    private JPanel northPanel = new JPanel();
    private JPanel southPanel = new JPanel();

    public BuyerFrontWindow(Buyer buyer) {

        super("Market 46");

        this.buyer = buyer;

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

        searchBarPanel.add(searchBar);
        searchBarPanel.add(searchButton);

        JPanel searchPanel = new JPanel();

        searchPanel.setLayout(new GridLayout(5,1));

        searchPanel.add(new JPanel());

        searchPanel.add(new JPanel());

        searchPanel.add(searchBarPanel);

        searchPanel.add(new JPanel());

        searchPanel.add(new JPanel());

        northPanel.add(searchPanel, BorderLayout.CENTER);

        buttonPanel.setLayout(new GridLayout(6,2));

        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());

        buttonPanel.add(logoffButton);
        buttonPanel.add(new JPanel());

        logoffButton.addActionListener(e -> {
            dispose();
            new MainWindow();
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
        editInfoButton.addActionListener(e -> new BuyerEditInfoWindow(buyer));
        buttonPanel.add(new JPanel());

        northPanel.add(buttonPanel, BorderLayout.EAST);

        mainPanel.add(northPanel, BorderLayout.NORTH);

        listPanel.setLayout(new BorderLayout());

        String[] testArray = {"TEST1", "TEST2", "TEST3", "TEST4", "TEST5", "TEST6", "TEST7", "TEST8", "TEST9", "TEST10", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A","C", "B"};
        productList = new JList<>(testArray);
        productList.setFont(new Font(null, 0, 15));
        listPanel.add(new JScrollPane(productList), BorderLayout.CENTER);
        listPanel.add(new JPanel(), BorderLayout.NORTH);
        listPanel.add(new JPanel(), BorderLayout.SOUTH);

        mainPanel.add(listPanel, BorderLayout.CENTER);

        mainPanel.add(new JPanel(), BorderLayout.WEST);
        mainPanel.add(new JPanel(), BorderLayout.EAST);

        southPanel.setLayout(new GridLayout(1,7));
        southPanel.add(new JPanel());
        southPanel.add(clearListButton);
        southPanel.add(new JPanel());
        southPanel.add(new JPanel());
        southPanel.add(addToCartButton);
        southPanel.add(new JPanel());

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);

    }

    private void removeButtonOperation() {


        DefaultListModel<String> model = (DefaultListModel) (productList.getModel());
        int index = productList.getSelectedIndex();

        if(index != -1) {
            model.remove(index);
        }
        productList.updateUI();
    }

    private void clearButtonOperation() {

        clearListButton.addActionListener(e -> productList.setListData(new Vector<String>()));
    }

    public static void main(String[] args) {
        JFrame jf = new BuyerFrontWindow(new Buyer(1,"2","3", "4", "5", "6", "7"));
    }

}
