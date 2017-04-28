package C212Amazon;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Turab on 4/28/2017.
 */
public class AdminEditInfoWindow extends EditInfoWindow {

    private AdminDataWriter admindatawriter = new AdminDataWriter();
    private AdminDataReader admindatareader = new AdminDataReader();
    private Admin admin = null;

    private JLabel headerLabel = new JLabel("Account Information");
    private JPanel centerPanel = new JPanel();

    public AdminEditInfoWindow(Admin admin) {

        this.admin = admin;

        actualUsernameLabel.setText(admin.getUserName());
        actualEmailLabel.setText(admin.getEmailAddress());

        setTitle("Edit ");

        mainPanel.setLayout(new BorderLayout());
        headerLabel.setHorizontalAlignment(0);
        headerLabel.setFont(new Font(Font.SERIF,Font.BOLD, 40));
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        centerPanel.setLayout(new GridLayout(5,3));

        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());

        usernameButton.addActionListener(e -> {
            JOptionPane jop = new JOptionPane();
            String usern = "" + jop.showInputDialog(null, "Enter new username:");

            if(usern.equals(actualUsernameLabel.getText())){

            }
            else if(usern.length() < 4) {
                jop.showMessageDialog(null, "Username should be at least 4 characters long."
                ,"Error",JOptionPane.ERROR_MESSAGE);
            }
            else if (admindatareader.verifyNewUsername("admin", usern)) {
                jop.showMessageDialog(null, "Username already exists","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                admindatawriter.setDb("admin", "username", admin.getUniqueID(), usern);
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
                admindatawriter.setDb("seller", "password", admin.getUniqueID(), password);
                jop.showMessageDialog(null, "Password changed successfully."
                , "Success", JOptionPane.INFORMATION_MESSAGE);
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
                admindatawriter.setDb("seller", "email", admin.getUniqueID(), emailn);
                jop.showMessageDialog(null, "Email address changed to " + emailn + " successfully."
                , "Success", JOptionPane.INFORMATION_MESSAGE);
                actualEmailLabel.setText(emailn);
            }

        });

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

    public static void main(String[] args) {
        JFrame jf = new AdminEditInfoWindow(new Admin(2, "3" , "3", "4"));
    }
}

