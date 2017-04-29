package C212Amazon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * GUI to edit items.
 * @author Syed Turab Ali Jafri
 * 4/28/2017
 */
public class ItemEditInfoWindow extends JFrame{

    private ItemDataWriter itemdatawriter = new ItemDataWriter();
    private ItemDataReader itemdatareader = new ItemDataReader();

    private JPanel mainPanel = new JPanel();
    private int FRAME_WIDTH = 600;
    private int FRAME_HEIGHT = 500;

    private JLabel productNameLabel = new JLabel("Product Name: ");
    private JLabel actualProductNameLabel = new JLabel();
    private JButton productNameLabelButton = new JButton("Edit");

    private JLabel categoryLabel = new JLabel("Category: ");
    private JLabel actualCategoryLabel = new JLabel();
    private JButton categoryButton = new JButton("Edit");

    private JLabel quantityLabel = new JLabel("Quantity: ");
    private JLabel actualQuantityLabel = new JLabel();
    private JButton quantityButton = new JButton("Edit");

    private JLabel priceLabel = new JLabel("Price: ");
    private JLabel actualPriceLabel = new JLabel();
    private JButton priceButton = new JButton("Edit");

    private JButton changeDescriptionButton = new JButton("Edit Description");


    public ItemEditInfoWindow(Item item) {

        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        actualProductNameLabel.setText(item.getProdName());
        actualQuantityLabel.setText(""+item.getQuantity());
        actualCategoryLabel.setText(item.getCategory());
        actualPriceLabel.setText("" + item.getPrice());

        setTitle("Edit Item");

        mainPanel.setLayout(new BorderLayout());
        JLabel headerLabel = new JLabel("Edit Item");
        headerLabel.setHorizontalAlignment(0);
        headerLabel.setFont(new Font(Font.SERIF,Font.BOLD, 40));
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5,3));

        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());

        productNameLabel.setHorizontalAlignment(JLabel.RIGHT);
        centerPanel.add(productNameLabel);
        actualProductNameLabel.setHorizontalAlignment((JLabel.CENTER));
        centerPanel.add(actualProductNameLabel);
        centerPanel.add(productNameLabelButton);

        productNameLabelButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();
            String nname = "" + jop.showInputDialog(null, "Enter new product name:");

            if(nname.equals(actualProductNameLabel.getText())){

            }
            else if(nname.length() < 4) {
                jop.showMessageDialog(null, "Product name should be at least 4 characters long."
                ,"Error",JOptionPane.ERROR_MESSAGE);
            }
            else {
                itemdatawriter.setDb("inventory", "productname", item.getProductID(), nname);
                jop.showMessageDialog(null, "Product name changed to " + nname + " successfully."
                , "Success", JOptionPane.INFORMATION_MESSAGE);
                actualProductNameLabel.setText(nname);
            }

        });

        categoryLabel.setHorizontalAlignment(JLabel.RIGHT);
        centerPanel.add(categoryLabel);
        actualCategoryLabel.setHorizontalAlignment((JLabel.CENTER));
        centerPanel.add(actualCategoryLabel);
        centerPanel.add(categoryButton);

        categoryButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();
            String cat = "" + jop.showInputDialog(null, "Enter new category:");

            if(cat.equals(actualCategoryLabel.getText())){

            }
            else if(cat.length() < 4) {
                jop.showMessageDialog(null, "Category name should be at least 4 characters long."
                ,"Error",JOptionPane.ERROR_MESSAGE);
            }
            else {
                itemdatawriter.setDb("inventory", "category", item.getProductID(), cat);
                jop.showMessageDialog(null, "Category name changed to " + cat + " successfully."
                , "Success", JOptionPane.INFORMATION_MESSAGE);
                actualCategoryLabel.setText(cat);
            }

        });

        quantityLabel.setHorizontalAlignment(JLabel.RIGHT);
        centerPanel.add(quantityLabel);
        actualQuantityLabel.setHorizontalAlignment((JLabel.CENTER));
        centerPanel.add(actualQuantityLabel);
        centerPanel.add(quantityButton);

        quantityButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();
            int quant = Integer.parseInt(jop.showInputDialog(null, "Enter new quantity:"));

            if(quant != Integer.parseInt(actualQuantityLabel.getText())){
                itemdatawriter.setDb("inventory", "quantity", item.getProductID(), quant);
                jop.showMessageDialog(null, "Quantity changed to " + quant + " successfully."
                        , "Success", JOptionPane.INFORMATION_MESSAGE);
                actualQuantityLabel.setText(quant + "");
            }

        });

        priceLabel.setHorizontalAlignment(JLabel.RIGHT);
        centerPanel.add(priceLabel);
        actualPriceLabel.setHorizontalAlignment((JLabel.CENTER));
        centerPanel.add(actualPriceLabel);
        centerPanel.add(priceButton);

        priceButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();
            double nprice = Double.parseDouble("" + jop.showInputDialog(null, "Enter new price:"));

            if((""+nprice).equals(actualPriceLabel.getText())){

            }
            else {
                itemdatawriter.setDb("inventory", "price", item.getProductID(), nprice + "");
                jop.showMessageDialog(null, "Price changed to " + nprice +"" + " successfully."
                , "Success", JOptionPane.INFORMATION_MESSAGE);
                actualPriceLabel.setText(nprice + "");
            }

        });

        changeDescriptionButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();
            String desc = "" + jop.showInputDialog(null, "Enter new category:");

                itemdatawriter.setDb("inventory", "description", item.getProductID(), desc);
                jop.showMessageDialog(null, "Description changed to " + desc +"" + " successfully."
                , "Success", JOptionPane.INFORMATION_MESSAGE);

        });

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(3,1));
        southPanel.add(new JPanel());
        southPanel.add(changeDescriptionButton);
        southPanel.add(new JPanel());

        mainPanel.add(southPanel, BorderLayout.SOUTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(new JPanel(), BorderLayout.EAST);
        add(mainPanel);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);



    }

}
