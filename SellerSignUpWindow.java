package C212Amazon;

import javax.swing.*;
import java.awt.*;

/**
 * A class to represent a sign up gui for a seller.
 * @author Syed Turab Ali Jafri
 * 4/22/2017
 */
public class SellerSignUpWindow extends SignUpWindow {

    private JLabel nameLabel = new JLabel("Name: ");
    private JTextField nameTextField = new JTextField(20);
    private String name= "";

    private JLabel phoneLabel = new JLabel("Phone: ");
    private JTextField phoneTextField = new JTextField(20);
    private String phone = "";

    private JLabel emailAddressLabel = new JLabel("Email Address: ");
    private JTextField emailAddressTextField = new JTextField(20);
    private String emailAddress = "";

    public SellerSignUpWindow() {

        setPanelSizeAndLayout();

        setLeftPanel();

        setRightPanel();

        setBottomPanel();
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

    public static void main(String[] args) {
        JFrame jf = new SellerSignUpWindow();
    }
}
