package C212Amazon;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract class for a log in window.
 * @author Syed Turab Ali Jafri
 * 4/25/2017
 */
public abstract class LogInWindow extends JFrame {

    private Market market = new Market();

    // All fields required for this panel.
    private final int FRAME_WIDTH = 600;
    private final int FRAME_HEIGHT = 15 * 30;
    private JPanel mainPanel = new JPanel();

    private JLabel headerLabel = new JLabel("Sign In");

    private JLabel usernameLabel = new JLabel("Username:");
    protected JTextField usernameTextField = new JTextField(20);
    private String username = "";

    private JLabel passwordLabel = new JLabel("Password:");
    protected JPasswordField passwordTextField = new JPasswordField(20);
    private String password = "";

    protected JButton loginButton = new JButton("Log in");
    protected JButton signupButton = new JButton("Sign up");

    public LogInWindow() {

        setTitle("Market 46");

        setSize(20 * 30, 15 * 30);
        setLocationRelativeTo(null);
        setResizable(false);
        add(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setPanelSizeAndLayout();

        setCenterPanel();

        setBottomPanel();

    }

    /**
     * Method to set up this panel.
     */
    private void setPanelSizeAndLayout() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        mainPanel.setLayout(new BorderLayout());

        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setFont(new Font(Font.SERIF,Font.BOLD, 40));
        mainPanel.add(headerLabel, BorderLayout.NORTH);
    }

    /**
     * Method to set up the center panel of this panel.
     */
    private void setCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4,1));

        JPanel usernamePanel = new JPanel();
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameTextField);

        JPanel passwordPanel = new JPanel();
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordTextField);

        JPanel loginPanel = new JPanel();
        loginPanel.add(loginButton);
        loginButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();
            username = usernameTextField.getText();
            password = passwordTextField.getText();
            if(username.equals("") && password.equals(""))
            jop.showMessageDialog(null, "Error: Username or password not found");
        });

        centerPanel.add(new JPanel());
        centerPanel.add(usernamePanel);
        centerPanel.add(passwordPanel);
        centerPanel.add(loginPanel);

        mainPanel.add(centerPanel,BorderLayout.CENTER);
    }

    /**
     * Method to set up the panel in the bottom of the frame.
     */
    private void setBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2,3));
        bottomPanel.add(new JPanel());
        bottomPanel.add(signupButton);
        bottomPanel.add(new JPanel());
        bottomPanel.add(new JPanel());
        bottomPanel.add(new JPanel());
        bottomPanel.add(new JPanel());
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

}
