/**
 *  Front Window
 *  An abstract class that describes the demensions for buyer, seller, and admin
 *
 */

package C212Amazon;
import javax.swing.*;

/**
 * Created by Turab on 4/22/2017.
 */
public class FrontWindow extends JFrame{

    // variables
    protected final int FRAME_WIDTH = 1000;
    protected final int FRAME_HEIGHT = 600;
    protected JPanel mainPanel = new JPanel();

    // constructor
    public FrontWindow() {

        super("TEST");
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        add(mainPanel);
        setResizable(false);
        setLocation(450,250);


    }
}
