package C212Amazon;

import javax.swing.*;
import java.awt.*;

/**
 * Window for a buyer to edit his info
 * @author Syed Turab Ali Jafri
 * 4/24/2017
 */
public class BuyerEditInfoWindow extends EditInfoWindow {

    private Buyer buyer = null;

    private JLabel firstNameLabel = new JLabel("First name: ");
    private String firstName = buyer.getFirstName();
    private JLabel actualFirstNameLabel = new JLabel(firstName);
    private JButton firstNameButton = new JButton("Edit");

    private JLabel lastNameLabel = new JLabel("Last name: ") ;
    private String lastname = buyer.getLastName();
    private JLabel actualLastNameLabel = new JLabel(lastname);
    private JButton lastNameButton = new JButton("Edit");

    private JLabel phoneLabel = new JLabel("Phone: ");
    private String phone = buyer.getPhone();
    private JLabel actualPhoneLabel = new JLabel(phone);
    private JButton phoneButton = new JButton("Edit");

    private JLabel headerLabel = new JLabel("Account Information");
    private JPanel centerPanel = new JPanel();

    public BuyerEditInfoWindow(Buyer buyer) {

        this.buyer = buyer;

        username = buyer.getUserName();
        email = buyer.getEmailAddress();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);
        setResizable(false);

        mainPanel.setLayout(new BorderLayout());
        headerLabel.setHorizontalAlignment(0);
        headerLabel.setFont(new Font(Font.SERIF,Font.BOLD, 40));
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        centerPanel.setLayout(new GridLayout(9,3));

        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());

        firstNameLabel.setHorizontalAlignment(JLabel.RIGHT);
        centerPanel.add(firstNameLabel);
        actualFirstNameLabel.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(actualFirstNameLabel);
        centerPanel.add(firstNameButton);

        firstNameButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();
            String firstn = jop.showInputDialog(null, "Enter new username:");
            firstName = firstn;
            actualFirstNameLabel.setText(firstName);
            jop.showMessageDialog(null, "First name changed to " + firstName + " successfully");
        });

        lastNameLabel.setHorizontalAlignment(JLabel.RIGHT);
        centerPanel.add(lastNameLabel);
        actualLastNameLabel.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(actualLastNameLabel);
        centerPanel.add(lastNameButton);

        usernameLabel.setHorizontalAlignment(JLabel.RIGHT);
        centerPanel.add(usernameLabel);
        actualUsernameLabel.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(actualUsernameLabel);
        centerPanel.add(usernameButton);

        passwordLabel.setHorizontalAlignment(JLabel.RIGHT);
        centerPanel.add(passwordLabel);
        actualPasswordLabel.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(actualPasswordLabel);
        centerPanel.add(passwordButton);

        phoneLabel.setHorizontalAlignment(JLabel.RIGHT);
        centerPanel.add(phoneLabel);
        actualPhoneLabel.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(actualPhoneLabel);
        centerPanel.add(phoneButton);


        emailLabel.setHorizontalAlignment(JLabel.RIGHT);
        centerPanel.add(emailLabel);
        actualEmailLabel.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(actualEmailLabel);
        centerPanel.add(emailButton);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(new JPanel(), BorderLayout.EAST);
        add(mainPanel);


    }

}
