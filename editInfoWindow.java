package C212Amazon;

import javax.swing.*;
/**
 * Created by Turab on 4/24/2017.
 */
public class editInfoWindow extends JFrame {


    protected JPanel mainPanel = new JPanel();
    protected int FRAME_WIDTH = 800;
    protected int FRAME_HEIGHT = 700;

    protected JLabel usernameLabel = new JLabel("Username: ");
    protected String username = "turab1996";
    protected JLabel actualUsernameLabel = new JLabel(username);
    protected JButton usernameButton = new JButton("Edit");

    protected JLabel passwordLabel = new JLabel("Password: ");
    protected JLabel actualPasswordLabel = new JLabel("********");
    protected JButton passwordButton = new JButton("Edit");

    protected JLabel emailLabel = new JLabel("Email: ");
    protected String email = "turab1996.tj@gmail.com";
    protected JLabel actualEmailLabel = new JLabel(email);
    protected JButton emailButton = new JButton("Edit");



}
