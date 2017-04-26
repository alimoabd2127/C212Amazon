package guis;

import javax.swing.*;
import ProjectSkeleton.*;

import java.awt.*;

/**
 * Created by Turab on 4/25/2017.
 */
public class MainWindow extends JFrame{

    private Market market = new Market();
    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 400;
    private JPanel mainPanel = new JPanel();
    private JButton buyerSignInButton = new JButton("Buyer");
    private JButton sellerSignInButton = new JButton("Seller");
    private JButton adminSignInButton = new JButton("Admin");
    private JButton signUpButton = new JButton("Sign up");

    public MainWindow() {

        super("Group 46");
        setSize(FRAME_WIDTH,FRAME_HEIGHT);

        mainPanel.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(signUpButton, BorderLayout.EAST);

        mainPanel.add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.add(buyerSignInButton, BorderLayout.WEST);
        buyerSignInButton.addActionListener(e -> {
            dispose();
            new BuyerLogInWindow();
                });
        southPanel.add(sellerSignInButton, BorderLayout.CENTER);
        southPanel.add(adminSignInButton, BorderLayout.EAST);

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame buyerWindow = new MainWindow();
    }
}
