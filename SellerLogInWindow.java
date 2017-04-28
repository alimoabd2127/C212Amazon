package C212Amazon;

import javax.swing.JOptionPane;

/**
 * GUI for seller's log in window.
 * @author Syed Turab Ali Jafri
 * 4/27/2017
 */
public class SellerLogInWindow extends LogInWindow{

    SellerDataReader sellerdatareader = new SellerDataReader();

    /**
     * Constructor to initialize remaining components of LogInWindow.
     */
    public SellerLogInWindow() {

      setLoginButton();

      setSignUpButton();

    }

    /**
     * Method to add action listener to log in button so that it verifies the user and then logs in.
     */
    private void setLoginButton() {
        loginButton.addActionListener(e -> {
            if(sellerdatareader.verify("seller",usernameTextField.getText(), passwordTextField.getText())) {
                dispose();
                new SellerFrontWindow(sellerdatareader.getSeller("seller", usernameTextField.getText()));
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
            new SellerSignUpWindow();
        });
    }

}
