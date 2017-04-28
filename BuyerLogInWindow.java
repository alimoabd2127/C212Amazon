package C212Amazon;

import javax.swing.JOptionPane;
/**
 * BuyerLoginWindow
 * GUI for a buyer's login window
 *
 * @author Syed Turab Ali jafri
 * 4/25/2017
 */
public class BuyerLogInWindow extends LogInWindow{

    // parameters
    BuyerDataReader buyerDataReader = new BuyerDataReader();

    /**
     * Constructor to initialize remaining components of LogInWindow
     */
    public BuyerLogInWindow() {

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
            if(buyerDataReader.verify("buyer",usernameTextField.getText(), passwordTextField.getText())) {
                dispose();
                new BuyerFrontWindow(buyerDataReader.getBuyer("buyer", usernameTextField.getText()));
            }
            else {
                new JOptionPane().showMessageDialog(null, "ID or Password does not match", "Login error",JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    /**
     * Method to set up the sign up button so that it launches the Buyer Sign Up Window.
     */
    private void setSignUpButton() {
        signupButton.addActionListener(e -> {
            new BuyerSignUpWindow();
        });
    }
}
