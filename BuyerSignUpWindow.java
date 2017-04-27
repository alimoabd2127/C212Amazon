package C212Amazon;

import javax.swing.*;
import java.awt.*;

/**
 * GUI for making a new buyer.
 * @author Syed Turab Ali Jafri
 * 4/26/2017
 */
public class BuyerSignUpWindow extends SignUpWindow {

    private BuyerDataWriter buyerdatawriter = new BuyerDataWriter();
    private BuyerDataReader buyerdatareader = new BuyerDataReader();

    private JLabel firstNameLabel = new JLabel("First Name: ");
    private JTextField firstNameTextField = new JTextField(20);

    private JLabel lastNameLabel = new JLabel("Last Name: ");
    private JTextField lastNameTextField = new JTextField(20);

    private JLabel phoneLabel = new JLabel("Phone: ");
    private JTextField phoneTextField = new JTextField(20);

    private JLabel emailAddressLabel = new JLabel("Email Address: ");
    private JTextField emailAddressTextField = new JTextField(20);

    public BuyerSignUpWindow() {

        super("Buyer Sign Up");

        setPanelSizeAndLayout();

        setLeftPanel();

        setRightPanel();

        setBottomPanel();

        signUpButton.addActionListener(e -> setSignUpButton());
        cancelButton.addActionListener(e -> dispose());
    }


    protected void setLeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(9, 2));

        leftPanel.add(new JPanel());
        leftPanel.add(new JPanel());

        firstNameLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(firstNameLabel);

        lastNameLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(lastNameLabel);

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

        leftPanel.add(new JPanel());
        leftPanel.add(signUpButton);


        mainPanel.add(leftPanel, BorderLayout.WEST);
    }

    protected void setRightPanel() {

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(9, 2));

        rightPanel.add(new JPanel());
        rightPanel.add(new JPanel());

        rightPanel.add(firstNameTextField);
        rightPanel.add(new JPanel());

        rightPanel.add(lastNameTextField);
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

        mainPanel.add(rightPanel, BorderLayout.EAST);
    }

    private void setSignUpButton() {

        JOptionPane jop = new JOptionPane();
        int errors = 0;
        String error = "";
        boolean usernameExists = true;

        if (buyerdatareader.verifyNewUsername("buyer", usernameTextField.getText())) {

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
            if (firstNameTextField.getText().length() < 3) {
                errors++;
                error += "Invalid first name (3)\n";
                firstNameTextField.setText("");
            }
            if (lastNameTextField.getText().length() < 3) {
                errors++;
                error += "Invalid last name (3)\n";
                lastNameTextField.setText("");
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
            if(!buyerdatawriter.createBuyer(new Buyer(0,usernameTextField.getText(), passwordTextField.getText(),
                    firstNameTextField.getText(), lastNameTextField.getText(), phoneTextField.getText(),
                    emailAddressTextField.getText()))) {
                jop.showMessageDialog(null, "Error while creating user. Please try again.",
                        "Writing Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                jop.showMessageDialog(null, "Buyer created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }

        }

        else {
            jop.showMessageDialog(null, "Errors (" + errors + ")\n" + error, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//    public static void main(String[] args) {
//        JFrame jf = new BuyerSignUpWindow();
//    }
}
