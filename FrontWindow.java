/**
 *  Front Window
 *  An abstract class that describes the dimensions for buyer, seller, and admin
 *
 */

package C212Amazon;

import javax.swing.*;

public class FrontWindow extends JFrame{

    // parameters
    protected final int FRAME_WIDTH = 1000;
    protected final int FRAME_HEIGHT = 600;
    protected JPanel mainPanel = new JPanel();

    // constructor
    public FrontWindow(String windowTitle) {

        super(windowTitle);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setResizable(false);
        setLocation(450,250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
