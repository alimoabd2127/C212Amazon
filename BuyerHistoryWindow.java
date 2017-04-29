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
    private JList<String> historyList = new JList<>();

    public BuyerHistoryWindow(int buyerID){

        super("History");

        ArrayList<String> history = historyReader.getPurchaseHistory("purchasehistory", buyerID);

        DefaultListModel<String> historyStrings = new DefaultListModel<>();

        if(history.size() == 0) {
            historyStrings.addElement("No History Found!");
        }

        else {

            for (String record : history) {
                historyStrings.addElement(record);
            }

            historyList.setModel(historyStrings);

            for (int i = 0; i < historyStrings.size(); i++) {
                historyList.ensureIndexIsVisible(i);
            }
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
