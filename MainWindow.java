package C212Amazon;

import javax.swing.*;

import java.awt.*;

/**
 *
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

    public MainWindow() {

        super("Market 46");
        setSize(FRAME_WIDTH,FRAME_HEIGHT);

        mainPanel.setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.add(buyerSignInButton, BorderLayout.WEST);

        buyerSignInButton.addActionListener(e -> {
            dispose();
            new BuyerLogInWindow();
        });

        southPanel.add(sellerSignInButton, BorderLayout.CENTER);
        southPanel.add(adminSignInButton, BorderLayout.EAST);

        sellerSignInButton.addActionListener(e -> {
            dispose();
            new SellerLogInWindow();
        });

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrame buyerWindow = new MainWindow();
    }
}
