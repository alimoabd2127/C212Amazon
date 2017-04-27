package C212Amazon;

import javax.swing.*;

/**
 * GUI for a buyer's log in window
 * @author Syed Turab Ali jafri
 * 4/25/2017
 */
public class BuyerLogInWindow extends LogInWindow{

    BuyerDataReader buyerDataReader = new BuyerDataReader();

    public BuyerLogInWindow() {
        loginButton.addActionListener(e -> {
            if(buyerDataReader.verifyBuyer(usernameTextField.getText(), passwordTextField.getText())) {
                dispose();
                new BuyerFrontWindow(buyerDataReader.getBuyer(usernameTextField.getText()));
            }
            else {
                new JOptionPane().showMessageDialog(null, "ID or Password does not match", "Login error",JOptionPane.ERROR_MESSAGE);
            }
        });

        signupButton.addActionListener(e -> {
            new BuyerSignUpWindow();
        });
    }

}
