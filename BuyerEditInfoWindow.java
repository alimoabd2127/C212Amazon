package C212Amazon;

import javax.swing.*;
import java.awt.*;

/**
 * Window for a buyer to edit his info
 * @author Syed Turab Ali Jafri
 * 4/24/2017
 */
public class BuyerEditInfoWindow extends EditInfoWindow {

    private BuyerDataWriter buyerdatawriter = new BuyerDataWriter();
    private BuyerDataReader buyerdatareader = new BuyerDataReader();
    private Buyer buyer = null;

    private JLabel firstNameLabel = new JLabel("First name: ");
    private JLabel actualFirstNameLabel = new JLabel();
    private JButton firstNameButton = new JButton("Edit");

    private JLabel lastNameLabel = new JLabel("Last name: ") ;
    private JLabel actualLastNameLabel = new JLabel();
    private JButton lastNameButton = new JButton("Edit");

    private JLabel phoneLabel = new JLabel("Phone: ");
    private JLabel actualPhoneLabel = new JLabel();
    private JButton phoneButton = new JButton("Edit");

    private JLabel headerLabel = new JLabel("Account Information");
    private JPanel centerPanel = new JPanel();

    public BuyerEditInfoWindow(Buyer buyer) {

        this.buyer = buyer;

        actualUsernameLabel.setText(buyer.getUserName());
        actualFirstNameLabel.setText(buyer.getFirstName());
        actualLastNameLabel.setText(buyer.getLastName());
        actualPhoneLabel.setText(buyer.getPhone());
        actualEmailLabel.setText(buyer.getEmailAddress());

        setTitle("Edit Buyer");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
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
            String firstn = "" + jop.showInputDialog(null, "Enter new first name:");

            if(firstn.equals(actualFirstNameLabel.getText())){

            }
            else if(firstn.length() < 4) {
                jop.showMessageDialog(null, "First name should be at least 4 characters long."
                ,"Error",JOptionPane.ERROR_MESSAGE);
            }
            else {
                buyerdatawriter.setFirstName("buyer", buyer.getUniqueID(),firstn);
                jop.showMessageDialog(null, "First name changed to " + firstn + " successfully."
                , "Success", JOptionPane.INFORMATION_MESSAGE);
                actualFirstNameLabel.setText(firstn);
            }

        });

        lastNameButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();
            String lastn = "" + jop.showInputDialog(null, "Enter new last name:");

            if(lastn.equals(actualLastNameLabel.getText())){

            }
            else if(lastn.length() < 4) {
                jop.showMessageDialog(null, "Last name should be at least 4 characters long."
                ,"Error",JOptionPane.ERROR_MESSAGE);
            }
            else {
                buyerdatawriter.setLastName("buyer", buyer.getUniqueID(), lastn);
                jop.showMessageDialog(null, "Last name changed to " + lastn + " successfully."
                , "Success", JOptionPane.INFORMATION_MESSAGE);
                actualLastNameLabel.setText(lastn);
            }

        });

        usernameButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();
            String usern = "" + jop.showInputDialog(null, "Enter new username:");

            if(usern.equals(actualUsernameLabel.getText())){

            }
            else if(usern.length() < 4) {
                jop.showMessageDialog(null, "Username should be at least 4 characters long."
                ,"Error",JOptionPane.ERROR_MESSAGE);
            }
            else if (buyerdatareader.verifyNewUsername("buyer", usern)) {
                jop.showMessageDialog(null, "Username already exists","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                buyerdatawriter.setUserName("buyer", buyer.getUniqueID(), usern);
                jop.showMessageDialog(null, "Username changed to " + usern + " successfully."
                , "Success", JOptionPane.INFORMATION_MESSAGE);
                actualUsernameLabel.setText(usern);
            }

        });

        passwordButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();
            String password = "" + jop.showInputDialog(null, "Enter new password:");
            String confirmation = "" + jop.showInputDialog(null,"Confirm new password:");
            if(password.equals(actualPasswordLabel.getText()) && confirmation.equals(actualPasswordLabel.getText())){

            }
            else if(password.length() < 8) {
                jop.showMessageDialog(null, "Password should be at least 8 characters long."
                ,"Error",JOptionPane.ERROR_MESSAGE);
            }
            else if (!password.equals(confirmation)) {
                jop.showMessageDialog(null, "Passwords do not match.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                buyerdatawriter.setPassword("buyer", buyer.getUniqueID(), password);
                jop.showMessageDialog(null, "Password changed successfully."
                , "Success", JOptionPane.INFORMATION_MESSAGE);
            }

        });

        phoneButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();
            String newphone = "" + jop.showInputDialog(null, "Enter new phone number:");

            if(newphone.equals(actualPhoneLabel.getText())){

            }
            else if(newphone.length() < 10) {
                jop.showMessageDialog(null, "Phone number should be at least 10 characters long."
                ,"Error",JOptionPane.ERROR_MESSAGE);
            }
            else {
                buyerdatawriter.setPhone("buyer", buyer.getUniqueID(), newphone);
                jop.showMessageDialog(null, "Phone number changed to " + newphone + " successfully."
                , "Success", JOptionPane.INFORMATION_MESSAGE);
                actualPhoneLabel.setText(newphone);
            }

        });

        emailButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();
            String emailn = "" + jop.showInputDialog(null, "Enter new email address:");

            if(emailn.equals(actualEmailLabel.getText())){

            }
            else if(emailn.length() < 5) {
                jop.showMessageDialog(null, "Email address should be at least 5 characters long."
                ,"Error",JOptionPane.ERROR_MESSAGE);
            }
            else {
                buyerdatawriter.setEmail("buyer", buyer.getUniqueID(), emailn);
                jop.showMessageDialog(null, "Email address changed to " + emailn + " successfully."
                , "Success", JOptionPane.INFORMATION_MESSAGE);
                actualEmailLabel.setText(emailn);
            }

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

        setVisible(true);
    }

}
