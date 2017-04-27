/**
 * BuyerLoginWindow
 * GUI for a buyer's login window
 *
 * @author Syed Turab Ali jafri
 * 4/25/2017
 */

package C212Amazon;

import javax.swing.*;


public class BuyerLogInWindow extends LogInWindow{

    // parameters
    BuyerDataReader buyerDataReader = new BuyerDataReader();

    // constructor
    public BuyerLogInWindow() {

        super("Buyer Login");
        loginButton.addActionListener(e -> {
            if(buyerDataReader.verify("buyer",usernameTextField.getText(), passwordTextField.getText())) {
                dispose();
                new BuyerFrontWindow(buyerDataReader.getBuyer("table", usernameTextField.getText()));
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
