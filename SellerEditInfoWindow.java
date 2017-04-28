package C212Amazon;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Turab on 4/28/2017.
 */
public class SellerEditInfoWindow extends EditInfoWindow {

    private SellerDataWriter sellerdatawriter = new SellerDataWriter();
    private SellerDataReader sellerdatareader = new SellerDataReader();
    private Seller seller = null;

    private JLabel nameLabel = new JLabel("Name: ") ;
    private JLabel actualNameLabel = new JLabel();
    private JButton nameButton = new JButton("Edit");

    private JLabel phoneLabel = new JLabel("Phone: ");
    private JLabel actualPhoneLabel = new JLabel();
    private JButton phoneButton = new JButton("Edit");

    private JLabel headerLabel = new JLabel("Account Information");
    private JPanel centerPanel = new JPanel();

    public SellerEditInfoWindow(Seller seller) {

        this.seller = seller;

        actualUsernameLabel.setText(seller.getUserName());
        actualNameLabel.setText(seller.getName());
        actualPhoneLabel.setText(seller.getPhone());
        actualEmailLabel.setText(seller.getEmailAddress());

        setTitle("Edit ");

        mainPanel.setLayout(new BorderLayout());
        headerLabel.setHorizontalAlignment(0);
        headerLabel.setFont(new Font(Font.SERIF,Font.BOLD, 40));
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        centerPanel.setLayout(new GridLayout(8,3));

        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());

        nameButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();
            String nname = "" + jop.showInputDialog(null, "Enter new name:");

            if(nname.equals(nameLabel.getText())){

            }
            else if(nname.length() < 4) {
                jop.showMessageDialog(null, "Name should be at least 4 characters long."
                ,"Error",JOptionPane.ERROR_MESSAGE);
            }
            else {
                sellerdatawriter.setDb("seller", "name", seller.getUniqueID(), nname);
                jop.showMessageDialog(null, "Name changed to " + nname + " successfully."
                , "Success", JOptionPane.INFORMATION_MESSAGE);
                actualNameLabel.setText(nname);
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
            else if (sellerdatareader.verifyNewUsername("seller", usern)) {
                jop.showMessageDialog(null, "Username already exists","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                sellerdatawriter.setDb("seller", "username", seller.getUniqueID(), usern);
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
                sellerdatawriter.setDb("seller", "password", seller.getUniqueID(), password);
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
                sellerdatawriter.setDb("seller", "phone", seller.getUniqueID(), newphone);
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
                sellerdatawriter.setDb("seller", "email", seller.getUniqueID(), emailn);
                jop.showMessageDialog(null, "Email address changed to " + emailn + " successfully."
                , "Success", JOptionPane.INFORMATION_MESSAGE);
                actualEmailLabel.setText(emailn);
            }

        });

        nameLabel.setHorizontalAlignment(JLabel.RIGHT);
        centerPanel.add(nameLabel);
        actualNameLabel.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(actualNameLabel);
        centerPanel.add(nameButton);

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

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
