package C212Amazon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Gui for a buyer's history
 */
public class BuyerHistoryWindow extends FrontWindow{

    private PurchaseHistoryDataReader historyReader = new PurchaseHistoryDataReader();

    private JPanel historyPanel = new JPanel();
    private JList historyList = new JList();

    public BuyerHistoryWindow(int buyerID){

        super("History");

        ArrayList<String> history = null;

        DefaultListModel<String> historyStrings = new DefaultListModel<>();

//        for(String record: history) {
  //          historyStrings.addElement(record);
    //    }

        historyList.setModel(historyStrings);

        for(int i = 0; i < historyStrings.size(); i++) {
            historyList.ensureIndexIsVisible(i);
        }
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JPanel(), BorderLayout.NORTH);
        mainPanel.add(new JPanel(), BorderLayout.SOUTH);
        mainPanel.add(new JPanel(), BorderLayout.EAST);
        mainPanel.add(new JPanel(), BorderLayout.WEST);
        mainPanel.add(historyList, BorderLayout.CENTER);

        add(mainPanel);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
