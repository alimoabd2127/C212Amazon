package C212Amazon;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
/**
 * GUI for the main window of mini-amazon project.
 * @author Syed Turab Ali Jafri.
 * 4/25/2017
 */
public class MainWindow extends JFrame{

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 400;
    private JPanel mainPanel = new JPanel();
    private JButton buyerSignInButton = new JButton("Buyer");
    private JButton sellerSignInButton = new JButton("Seller");
    private JButton adminSignInButton = new JButton("Admin");

    /**
     * Constructor to initialize the window.
     */
    public MainWindow() {

        super("Market 46");
        setSize(FRAME_WIDTH,FRAME_HEIGHT);

        setMainPanel();

        setBuyerSignInButton();

        setSellerSignInButton();

        setAdminSignInButton();

        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Method to set the main panel.
     */
    private void setMainPanel() {

        mainPanel.setLayout(new BorderLayout());
        setSouthPanel();
    }

    /**
     * Method to set the South panel. new JPanel() objects are made to fill spaces.
     */
    private void setSouthPanel() {

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1,5));
        southPanel.add(buyerSignInButton);
        southPanel.add(new JPanel());
        southPanel.add(sellerSignInButton);
        southPanel.add(new JPanel());
        southPanel.add(adminSignInButton);

        mainPanel.add(southPanel, BorderLayout.SOUTH);
    }

    /**
     * Method to add action listener to buyer sign in button.
     */
    private void setBuyerSignInButton() {
        buyerSignInButton.addActionListener(e -> {
            dispose();
            new BuyerLogInWindow();
        });
    }

    /**
     * Method to add action listener to seller sign in button.
     */
    private void setSellerSignInButton() {
        sellerSignInButton.addActionListener(e -> {
            dispose();
            new SellerLogInWindow();
        });
    }

    /**
     * Method to add action listener to admin sign in button.
     */
    private void setAdminSignInButton() {
        adminSignInButton.addActionListener(e -> {
            dispose();
            new AdminLogInWindow();
        });
    }

    public static void main(String[] args) {
        JFrame buyerWindow = new MainWindow();
    }
}
