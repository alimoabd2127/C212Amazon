package guis;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Turab on 4/19/2017.
 */
public class BuyerSignUpWindow extends SignUpWindow {

    // All

    private JLabel firstNameLabel = new JLabel("First Name: ");
    private JTextField firstNameTextField = new JTextField(20);
    private String firstName = "";

    private JLabel lastNameLabel = new JLabel("Last Name: ");
    private JTextField lastNameTextField = new JTextField(20);
    private String lastName= "";

    private JLabel phoneLabel = new JLabel("Phone: ");
    private JTextField phoneTextField = new JTextField(20);
    private String phone = "";

    private JLabel emailAddressLabel = new JLabel("Email Address: ");
    private JTextField emailAddressTextField = new JTextField(20);
    private String emailAddress = "";

    public BuyerSignUpWindow() {

        setPanelSizeAndLayout();

        setLeftPanel();


        setRightPanel();

        setBottomPanel();
    }


    protected void setLeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(9,2));

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


        mainPanel.add(leftPanel,BorderLayout.WEST);
    }

    protected void setRightPanel() {

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(9,2));

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

        mainPanel.add(rightPanel,BorderLayout.EAST);
    }

    public static void main(String[] args) {
        JFrame jf = new BuyerSignUpWindow();
    }
}
