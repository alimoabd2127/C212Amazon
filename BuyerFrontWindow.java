package C212Amazon;

import ProjectSkeleton.Buyer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * @author Syed Turab Ali Jafri
 */
public class BuyerFrontWindow extends FrontWindow {

    private JTextField searchBar = new JTextField(30);
    private JButton searchButton = new JButton("Search");
    private JPanel searchBarPanel = new JPanel();
    private BufferedImage groupIcon;
    private JLabel groupImage;
    private JButton cartButton = new JButton("Cart");
    private JButton editInfoButton = new JButton("Edit Info");
    private JPanel buttonPanel = new JPanel();
    private JList<String> productList = new JList<>();
    private JButton clearListButton = new JButton("Clear");
    private JButton addToCartButton = new JButton("Add to Cart");
    private JPanel northPanel = new JPanel();
    private JPanel southPanel = new JPanel();

    public BuyerFrontWindow(Buyer buyer) {

        mainPanel.setLayout(new BorderLayout());

        try {
            groupIcon = ImageIO.read(new File("C:\\Users\\Turab\\Downloads\\thg.jpg"));
            groupImage = new JLabel(new ImageIcon(groupIcon));
        }


        catch(IOException e) {
            e.printStackTrace();
        }

        northPanel.setLayout(new BorderLayout());
        northPanel.add(groupImage , BorderLayout.WEST);

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

        buttonPanel.setLayout(new GridLayout(5,2));

        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());

        buttonPanel.add(cartButton);
        buttonPanel.add(new JPanel());

        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());

        buttonPanel.add(editInfoButton);
        editInfoButton.addActionListener(e -> new BuyerEditInfoWindow());
        buttonPanel.add(new JPanel());

        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());

        northPanel.add(buttonPanel, BorderLayout.EAST);

        mainPanel.add(northPanel, BorderLayout.NORTH);

        String[] testArray = {"TEST1", "TEST2", "TEST3", "TEST4", "TEST5", "TEST6", "TEST7", "TEST8", "TEST9", "TEST10", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A","C", "B"};

        productList = new JList<>(testArray);
        mainPanel.add(new JScrollPane(productList), BorderLayout.CENTER);

        southPanel.setLayout(new GridLayout(1,6));
        southPanel.add(new JPanel());
        southPanel.add(clearListButton);
        southPanel.add(new JPanel());
        southPanel.add(new JPanel());
        southPanel.add(addToCartButton);
        southPanel.add(new JPanel());

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setLocation(700,500);
        setVisible(true);

    }

    public static void main(String[] args) {
        JFrame jf = new BuyerFrontWindow(new Buyer());

    }
}
