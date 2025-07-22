package nba_statComparator;

import nba_statComparator.gui;
import nba_statComparator.showPlayerGui;
import javax.swing.*;

public class Main {




    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui frame = new gui("NBA Stat Comparator");
                frame.setSize(900, 450);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);


            }
        });
    }


}
