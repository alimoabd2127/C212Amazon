package C212Amazon;

import javax.swing.*;

/**
 * Sign in window for a seller
 * @author Syed Turab Ali Jafri
 * 4/27/2017
 */
public class SellerLogInWindow extends LogInWindow{

    SellerDataReader sellerdatareader = new SellerDataReader();

    // constructor
    public SellerLogInWindow() {

        loginButton.addActionListener(e -> {
            if(sellerdatareader.verify("seller",usernameTextField.getText(), passwordTextField.getText())) {
                dispose();
                new SellerFrontWindow(sellerdatareader.getSeller("seller", usernameTextField.getText()));
            }
            else {
                new JOptionPane().showMessageDialog(null, "ID or Password does not match", "Login error",JOptionPane.ERROR_MESSAGE);
            }
        });

        signupButton.addActionListener(e -> {
            new SellerSignUpWindow();
        });
    }

}
