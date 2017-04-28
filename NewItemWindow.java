package C212Amazon;

import javax.swing.*;
import java.awt.*;
/**
 * Gui for making a new item.
 * @author Syed Turab Ali Jafri
 * 4/28/2017
 */
public class NewItemWindow extends JFrame{

    protected final int FRAME_WIDTH = 800;
    protected final int FRAME_HEIGHT = 500;
    protected JPanel mainPanel = new JPanel();

    private int sellerID;

    protected JLabel headerLabel = new JLabel("Item");

    protected JLabel productNameLabel = new JLabel("Product Name: ");
    protected JTextField productNameTextField = new JTextField(20);

    protected JLabel categoryLabel = new JLabel("Category: ");
    protected JTextField categoryTextField = new JTextField(20);

    protected JLabel descriptionLabel = new JLabel("Description: ");
    protected JTextField descriptionTextField = new JTextField(20);

    protected JLabel quantityLabel = new JLabel("Quantity: ");
    protected JTextField  quantityTextField = new JTextField(20);

    protected JLabel priceLabel = new JLabel("Price: ");
    protected JTextField priceTextField = new JTextField(20);

    protected JButton cancelButton = new JButton("Cancel");
    protected JButton createButton = new JButton("Create");

    public NewItemWindow(int sellerID) {

        super("Item");

        this.sellerID = sellerID;

        setPanelSizeAndLayout();

        setLeftPanel();

        setRightPanel();

        setBottomPanel();

        //createButton.addActionListener(e -> setCreateButton());

        cancelButton.addActionListener(e -> dispose());
        add(mainPanel);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    protected void setLeftPanel(){

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(9,2));

        leftPanel.add(new JPanel());
        leftPanel.add(new JPanel());

        leftPanel.add(new JPanel());
        leftPanel.add(new JPanel());

        productNameLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(productNameLabel);

        categoryLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(categoryLabel);

        descriptionLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(descriptionLabel);

        quantityLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(quantityLabel);

        priceLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(priceLabel);

        mainPanel.add(leftPanel,BorderLayout.WEST);
    }
    protected void setRightPanel(){

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(9,2));

        rightPanel.add(new JPanel());
        rightPanel.add(new JPanel());

        rightPanel.add(new JPanel());
        rightPanel.add(new JPanel());

        rightPanel.add(productNameTextField);
        rightPanel.add(new JPanel());

        rightPanel.add(categoryTextField);
        rightPanel.add(new JPanel());

        rightPanel.add(descriptionTextField);
        rightPanel.add(new JPanel());

        rightPanel.add(quantityTextField);
        rightPanel.add(new JPanel());

        rightPanel.add(priceTextField);
        rightPanel.add(new JPanel());

        mainPanel.add(rightPanel,BorderLayout.EAST);
    }

    private void setBottomPanel() {

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2,5));
        bottomPanel.add(new JPanel());
        bottomPanel.add(cancelButton);
        bottomPanel.add(new JPanel());
        bottomPanel.add(createButton);
        bottomPanel.add(new JPanel());
        bottomPanel.add(new JPanel());
        bottomPanel.add(new JPanel());
        bottomPanel.add(new JPanel());
        bottomPanel.add(new JPanel());
        bottomPanel.add(new JPanel());
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void setPanelSizeAndLayout() {
        mainPanel.setLayout(new BorderLayout());
        JPanel sidePanel1 = new JPanel();
        JPanel sidePanel2 = new JPanel();
        sidePanel1.add(new JLabel("   "));
        sidePanel2.add(new JLabel("   "));

        mainPanel.add(sidePanel1, BorderLayout.EAST);
        mainPanel.add(sidePanel2, BorderLayout.WEST);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(2,1));
        headerPanel.add(new JPanel());
        headerPanel.add(headerLabel);
        headerLabel.setHorizontalAlignment(0);
        headerLabel.setFont(new Font(Font.SERIF,Font.BOLD, 40));
        mainPanel.add(headerPanel, BorderLayout.NORTH);

    }

//    private void setCreateButton() {
//
//        JOptionPane jop = new JOptionPane();
//        int errors = 0;
//        String error = "";
//        boolean usernameExists = true;
//
//        if (sellerdatareader.verifyNewUsername("seller", usernameTextField.getText())) {
//
//            usernameExists = false;
//
//            if (usernameTextField.getText().length() < 4) {
//                errors++;
//                error += "Invalid username (4)\n";
//                usernameTextField.setText("");
//            }
//            if (passwordTextField.getText().length() < 8) {
//                errors++;
//                error += "Invalid password (8)\n";
//                passwordTextField.setText("");
//                confirmedPasswordTextField.setText("");
//            }
//            else if(!confirmedPasswordTextField.getText().equals(passwordTextField.getText())) {
//                errors++;
//                error += "Passwords don't match.\n";
//                passwordTextField.setText("");
//                confirmedPasswordTextField.setText("");
//            }
//            if (nameTextField.getText().length() < 3) {
//                errors++;
//                error += "Invalid name (3)\n";
//                nameTextField.setText("");
//            }
//            if (phoneTextField.getText().length() < 10) {
//                errors++;
//                error += "Invalid phone number (10)\n";
//                phoneTextField.setText("");
//            }
//            if (emailAddressTextField.getText().length() < 5) {
//                errors++;
//                error += "Invalid email address (5)\n";
//                emailAddressTextField.setText("");
//            }
//
//        }
//
//        if(usernameExists) {
//            errors++;
//            error += "Username already exists!\n";
//            usernameTextField.setText("");
//        }
//
//        if(errors == 0) {
//            if(!sellerdatawriter.createSeller(new Seller(0,usernameTextField.getText(), passwordTextField.getText(),
//                    nameTextField.getText(), phoneTextField.getText(),
//                    emailAddressTextField.getText()))) {
//                jop.showMessageDialog(null, "Error while creating user. Please try again.",
//                        "Writing Error", JOptionPane.ERROR_MESSAGE);
//            }
//            else {
//                jop.showMessageDialog(null, "Seller created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
//                dispose();
//            }
//
//        }
//
//        else {
//            jop.showMessageDialog(null, "Errors (" + errors + ")\n" + error, "Error", JOptionPane.ERROR_MESSAGE);
//        }
//
//    }
}
