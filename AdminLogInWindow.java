package C212Amazon;

import javax.swing.*;

/**
 * GUI for admin's login window.
 * @author Syed Turab Ali Jafri
 * 4/25/2017
 */
public class AdminLogInWindow extends LogInWindow {

    AdminDataReader admindatareader = new AdminDataReader();

    /**
     * Constructor to initialize remaining components of LogInWindow.
     */
    public AdminLogInWindow() {

        setLoginButton();

        setSignUpButton();

        setLocationRelativeTo(null);
        setVisible(true);

    }

    /**
     * Method to add action listener to log in button so that it verifies the user and then logs in.
     */
    private void setLoginButton() {
        loginButton.addActionListener(e -> {
            if(admindatareader.verify("admin",usernameTextField.getText(), passwordTextField.getText())) {
                dispose();
                new AdminFrontWindow(admindatareader.getAdmin("admin", usernameTextField.getText()));
            }
            else {
                new JOptionPane().showMessageDialog(null, "ID or Password does not match", "Login error",JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    /**
     * Method to set up the sign up button so that it launches the Seller Sign Up Window.
     */
    private void setSignUpButton() {
        signupButton.addActionListener(e -> {
            new AdminSignUpWindow();
        });
    }
}
