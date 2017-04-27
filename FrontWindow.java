package C212Amazon;

import javax.swing.*;

/**
 * Created by Turab on 4/22/2017.
 */
public class FrontWindow extends JFrame{

    protected final int FRAME_WIDTH = 1000;
    protected final int FRAME_HEIGHT = 700;
    protected JPanel mainPanel = new JPanel();

    public FrontWindow() {

        super("TEST");
        add(mainPanel);
        setVisible(true);


    }
}
