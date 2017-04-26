package C212Amazon;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Turab on 4/22/2017.
 */
public class AdminSignUpWindow extends SignUpWindow {

    private JLabel emailAddressLabel = new JLabel("Email Address: ");
    private JTextField emailAddressTextField = new JTextField(20);
    private String emailAddress = "";

    public AdminSignUpWindow() {

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

        leftPanel.add(new JPanel());
        leftPanel.add(new JPanel());

        usernameLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(usernameLabel);

        passwordLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(passwordLabel);

        confirmPasswordLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(confirmPasswordLabel);

        emailAddressLabel.setHorizontalAlignment(4);
        leftPanel.add(new JPanel());
        leftPanel.add(emailAddressLabel);

        leftPanel.add(new JPanel());
        leftPanel.add(new JPanel());

        mainPanel.add(leftPanel,BorderLayout.WEST);


    }



    protected void setRightPanel() {
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(9,2));

        rightPanel.add(new JPanel());
        rightPanel.add(new JPanel());

        rightPanel.add(new JPanel());
        rightPanel.add(new JPanel());

        rightPanel.add(usernameTextField);
        rightPanel.add(new JPanel());

        rightPanel.add(passwordTextField);
        rightPanel.add(new JPanel());

        rightPanel.add(confirmedPasswordTextField);
        rightPanel.add(new JPanel());

        rightPanel.add(emailAddressTextField);
        rightPanel.add(new JPanel());

        rightPanel.add(new JPanel());
        rightPanel.add(new JPanel());

        mainPanel.add(rightPanel,BorderLayout.EAST);
    }

    public static void main(String[] args) {
        JFrame jf = new AdminSignUpWindow();
    }
}
