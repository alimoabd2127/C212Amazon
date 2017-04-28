package C212Amazon;

import javax.swing.*;
import java.awt.*;

/**
 * A class to represent a sign up gui for a seller.
 * @author Syed Turab Ali Jafri
 * 4/22/2017
 */
public class SellerSignUpWindow extends SignUpWindow {

    private SellerDataWriter sellerdatawriter = new SellerDataWriter();
    private SellerDataReader sellerdatareader = new SellerDataReader();

    private JLabel nameLabel = new JLabel("Name: ");
    private JTextField nameTextField = new JTextField(20);

    private JLabel phoneLabel = new JLabel("Phone: ");
    private JTextField phoneTextField = new JTextField(20);

    public SellerSignUpWindow() {

        super("Seller");

        setPanelSizeAndLayout();

        setLeftPanel();

        setRightPanel();

        setBottomPanel();

        signUpButton.addActionListener(e -> setSignUpButton());

        setVisible(true);
    }


    protected void setLeftPanel(){

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(9,2));

        leftPanel.add(new JPanel());
        leftPanel.add(new JPanel());

        leftPanel.add(new JPanel());
        leftPanel.add(new JPanel());

        nameLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(nameLabel);

        usernameLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(usernameLabel);

        passwordLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(passwordLabel);

        confirmPasswordLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(confirmPasswordLabel);

        phoneLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(phoneLabel);

        emailAddressLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(emailAddressLabel);

        mainPanel.add(leftPanel,BorderLayout.WEST);
    }
    protected void setRightPanel(){

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(9,2));

        rightPanel.add(new JPanel());
        rightPanel.add(new JPanel());

        rightPanel.add(new JPanel());
        rightPanel.add(new JPanel());

        rightPanel.add(nameTextField);
        rightPanel.add(new JPanel());

        rightPanel.add(usernameTextField);
        rightPanel.add(new JPanel());

        rightPanel.add(passwordTextField);
        rightPanel.add(new JPanel());

        rightPanel.add(confirmedPasswordTextField);
        rightPanel.add(new JPanel());

        rightPanel.add(phoneTextField);
        rightPanel.add(new JPanel());

        rightPanel.add(emailAddressTextField);
        rightPanel.add(new JPanel());

        mainPanel.add(rightPanel,BorderLayout.EAST);
    }

    private void setSignUpButton() {

        JOptionPane jop = new JOptionPane();
        int errors = 0;
        String error = "";
        boolean usernameExists = true;

        if (sellerdatareader.verifyNewUsername("seller", usernameTextField.getText())) {

            usernameExists = false;

            if (usernameTextField.getText().length() < 4) {
                errors++;
                error += "Invalid username (4)\n";
                usernameTextField.setText("");
            }
            if (passwordTextField.getText().length() < 8) {
                errors++;
                error += "Invalid password (8)\n";
                passwordTextField.setText("");
                confirmedPasswordTextField.setText("");
            }
            else if(!confirmedPasswordTextField.getText().equals(passwordTextField.getText())) {
                errors++;
                error += "Passwords don't match.\n";
                passwordTextField.setText("");
                confirmedPasswordTextField.setText("");
            }
            if (nameTextField.getText().length() < 3) {
                errors++;
                error += "Invalid name (3)\n";
                nameTextField.setText("");
            }
            if (phoneTextField.getText().length() < 10) {
                errors++;
                error += "Invalid phone number (10)\n";
                phoneTextField.setText("");
            }
            if (emailAddressTextField.getText().length() < 5) {
                errors++;
                error += "Invalid email address (5)\n";
                emailAddressTextField.setText("");
            }

        }

        if(usernameExists) {
            errors++;
            error += "Username already exists!\n";
            usernameTextField.setText("");
        }

        if(errors == 0) {
            if(!sellerdatawriter.createSeller(new Seller(0,usernameTextField.getText(), passwordTextField.getText(),
                    nameTextField.getText(), phoneTextField.getText(),
                    emailAddressTextField.getText()))) {
                jop.showMessageDialog(null, "Error while creating user. Please try again.",
                        "Writing Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                jop.showMessageDialog(null, "Seller created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }

        }

        else {
            jop.showMessageDialog(null, "Errors (" + errors + ")\n" + error, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args) {
        JFrame jf = new SellerSignUpWindow();
    }
}
