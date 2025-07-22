package nba_statComparator;

import crypto_proj.loginGui;
import crypto_proj.registerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class showPlayerGui extends NBABaseFrame {

    Player player1;
    Player player2;

    showPlayerGui(Player p1, Player p2) {
        super("NBA Player Stat Display");



        this.player1 = p1;
        this.player2 = p2;
        setSize(880,320);

        addGuiComponents();
    }

    public double getAvg(Player player){
        return (jdbc.getPoints(player.getName())+ jdbc.getAssists(player.getName())+ jdbc.getRebounds(player.getName()))/3;
    }

    public HashMap<String, String> teams() {
        HashMap<String, String> nbaTeams = new HashMap<>();

        nbaTeams.put("Phi", "Philadelphia 76ers");
        nbaTeams.put("Nyk", "New York Knicks");
        nbaTeams.put("Mil", "Milwaukee Bucks");
        nbaTeams.put("Okc", "Oklahoma City Thunder");
        nbaTeams.put("Cle", "Cleveland Cavaliers");
        nbaTeams.put("Dal", "Dallas Mavericks");
        nbaTeams.put("Den", "Denver Nuggets");
        nbaTeams.put("Lal", "Los Angeles Lakers");
        nbaTeams.put("Min", "Minnesota Timberwolves");
        nbaTeams.put("Pho", "Phoenix Suns");
        nbaTeams.put("Orl", "Orlando Magic");
        nbaTeams.put("Bos", "Boston Celtics");
        nbaTeams.put("Mia", "Miami Heat");
        nbaTeams.put("Ind", "Indiana Pacers");
        nbaTeams.put("Lac", "Los Angeles Clippers");
        nbaTeams.put("Nor", "New Orleans Pelicans");

        return nbaTeams;
    }
    @Override
    protected void addGuiComponents() {
        if (player1 == null || player2 == null) {
//            JOptionPane.showMessageDialog(this, "Error: One or both players are null!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Player 1 display
        JLabel play1 = new JLabel(player1.getName() + " (" + jdbc.getPosition(player1.getName()) + ")");
        play1.setFont(new Font("Dialog", Font.BOLD, 24));
        play1.setBounds(10, 10, 400, 40);
        add(play1);

// Player 1 table
        String[] headers = {"Team", "PPG", "APG", "RPG"};
        Object[][] data = {
                {teams().get(jdbc.getTeam(player1.getName())), jdbc.getPoints(player1.getName()),
                        jdbc.getAssists(player1.getName()), jdbc.getRebounds(player1.getName())}
        };
        JTable tableOne = new JTable(data, headers);
        tableOne.setDefaultEditor(Object.class, null);
        JScrollPane scrollPaneOne = new JScrollPane(tableOne);
        scrollPaneOne.setBounds(10, 60, 400, 100);
        add(scrollPaneOne);

// Player 2 display
        JLabel play2 = new JLabel(player2.getName() + " (" + jdbc.getPosition(player2.getName()) + ")");
        play2.setFont(new Font("Dialog", Font.BOLD, 24));
        play2.setBounds(450, 10, 400, 40);
        add(play2);

// Player 2 table
        String[] headers2 = {"Team", "PPG", "APG", "RPG"};
        Object[][] data2 = {
                {teams().get(jdbc.getTeam(player2.getName())), jdbc.getPoints(player2.getName()),
                        jdbc.getAssists(player2.getName()), jdbc.getRebounds(player2.getName())}
        };

        JTable tableTwo = new JTable(data2, headers2);
        tableTwo.setDefaultEditor(Object.class, null);
        JScrollPane scrollPaneTwo = new JScrollPane(tableTwo);
        scrollPaneTwo.setBounds(450, 60, 400, 100); // Corrected the variable usage
        add(scrollPaneTwo);

        String betterText = (getAvg(player1) > getAvg(player2))
                ? player1.getName() +" is the better overall player."
                : player2.getName()+" is the better overall player.";

//        System.out.print(getAvg(player1));
//        System.out.print(getAvg(player2));

        JLabel better = new JLabel("<html>" + betterText + "</html>");
        better.setFont(new Font("Dialog", Font.BOLD, 18));
        better.setBounds(250, 180, 450, 60);
        add(better);


        JLabel returnText = new JLabel("<html><a href=\"#\"> Want to compare new players? Click Here! </a></html>");
        returnText.setFont(new Font("Dialog", Font.BOLD, 18));
        returnText.setBounds(200, 220, 450, 60);
        returnText.setHorizontalAlignment(SwingConstants.CENTER);

        returnText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPlayerGui.this.dispose();

                gui newGui = new gui("NBA Stat Comparator");
                newGui.setSize(900, 450);
                newGui.setVisible(true);
            }
        });

        add(returnText);

    }
}
