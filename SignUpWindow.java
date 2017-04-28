package C212Amazon;

import javax.swing.*;
import java.awt.*;

/**
 * Class to represent a sign up gui.
 * @author Syed Turab Ali Jafri
 * 4/22/2017
 */
public abstract class SignUpWindow extends JFrame {

    //All fields required for a sign up gui
    protected final int FRAME_WIDTH = 800;
    protected final int FRAME_HEIGHT = 500;
    protected JPanel mainPanel = new JPanel();

    protected JLabel headerLabel = new JLabel("Sign Up");

    protected JLabel usernameLabel = new JLabel("Username: ");
    protected JTextField usernameTextField = new JTextField(20);

    protected JLabel passwordLabel = new JLabel("Password: ");
    protected JPasswordField passwordTextField = new JPasswordField(20);

    protected JLabel confirmPasswordLabel = new JLabel("                Confirm Password: ");
    protected JPasswordField confirmedPasswordTextField = new JPasswordField(20);

    protected JLabel emailAddressLabel = new JLabel("Email Address: ");
    protected JTextField emailAddressTextField = new JTextField(20);

    protected JButton cancelButton = new JButton("Cancel");
    protected JButton signUpButton = new JButton("Sign up");

    public SignUpWindow(String signUpAccount) {
        super(signUpAccount);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        add(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setCancelButton();
    }

    protected void setPanelSizeAndLayout() {
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

    protected abstract void setLeftPanel();
    protected abstract void setRightPanel();

    protected void setBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2,5));
        bottomPanel.add(new JPanel());
        bottomPanel.add(signUpButton);
        bottomPanel.add(new JPanel());
        bottomPanel.add(cancelButton);
        bottomPanel.add(new JPanel());
        bottomPanel.add(new JPanel());
        bottomPanel.add(new JPanel());
        bottomPanel.add(new JPanel());
        bottomPanel.add(new JPanel());
        bottomPanel.add(new JPanel());
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void setCancelButton() {
        cancelButton.addActionListener(e -> {
            dispose();
        });
    }

}
