package org.rahib.nba;

import java.util.ArrayList;
import java.util.List;


public class temp {
    public static List<Player> getPlayers() {
    	
        List<Player> players = new ArrayList<>();
        players.add(new Player("LeBron James", "Lakers", 25.0, 7.8, 7.9));
        players.add(new Player("Kevin Durant", "Suns", 27.0, 5.2, 7.1));
        players.add(new Player("Stephen Curry", "Warriors", 29.5, 6.0, 5.5));
        players.add(new Player("Jayson Tatum", "Celtics", 26.9, 4.9	, 8.1));
        players.add(new Player("Jalen Brunson", "Knicks", 28.7, 6.7, 3.6));
        players.add(new Player("Kristaps Porzingis", "Celtics",20.1, 7.2, 2 ));
        return players;
    }
}
