package nba_statComparator;

import javax.swing.*;

public abstract class NBABaseFrame extends JFrame {

    public NBABaseFrame(String title) {
        initialize(title);
    }

    protected Player player1;
    protected Player player2;

    public NBABaseFrame(String title, Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        initialize(title);
    }


    private void initialize(String title) {

        setTitle(title);

        setSize(900, 900);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);

        setResizable(false);
        setLocationRelativeTo(null);

        addGuiComponents();


    }

    protected abstract void addGuiComponents();


}
