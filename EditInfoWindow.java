package C212Amazon;

import javax.swing.*;
/**
 * Created by Turab on 4/24/2017.
 */
public class EditInfoWindow extends JFrame {


    protected JPanel mainPanel = new JPanel();
    protected int FRAME_WIDTH = 800;
    protected int FRAME_HEIGHT = 700;

    protected JLabel usernameLabel = new JLabel("Username: ");
    protected JLabel actualUsernameLabel = new JLabel();
    protected JButton usernameButton = new JButton("Edit");

    protected JLabel passwordLabel = new JLabel("Password: ");
    protected JLabel actualPasswordLabel = new JLabel("********");
    protected JButton passwordButton = new JButton("Edit");

    protected JLabel emailLabel = new JLabel("Email: ");
    protected JLabel actualEmailLabel = new JLabel();
    protected JButton emailButton = new JButton("Edit");

    public EditInfoWindow() {
        setResizable(false);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        add(mainPanel);
    }


}
