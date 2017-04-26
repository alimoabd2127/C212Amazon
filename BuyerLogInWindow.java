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
            if(usernameTextField.getText().equals("turab1996") && passwordTextField.getText().equals("123123")) {
                dispose();
               // new BuyerFrontWindow(new Buyer());
            }
            else {
                new JOptionPane().showMessageDialog(null, "Not idd");
            }
        });

        signupButton.addActionListener(e -> {
            new BuyerSignUpWindow();
        });
    }

    private Buyer getBuyerInfo(String username, String password) {

        String uniqueID = "";
        String fName = "";
        String lName = "";
        String contact = "";
        String email = "";

        return new Buyer(uniqueID, username, password,fName, lName, contact, email);
    }


}
