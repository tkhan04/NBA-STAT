package nba_statComparator;

public class Player {

	private final String name;
	public String getName() {
		return name;
	}

	private final String team;
	public String getTeam() {
		return team;
	}

	private final double rpg;
	public double getRpg() {
		return rpg;
	}

	private final double ppg;
	public double getPpg() {
		return ppg;
	}

	private final double apg;
	public double getApg() {
		return apg;
	}





	public Player(String player, String nbaTeam, double ppg, double apg, double rpg){
        this.name = player;
        this.team = nbaTeam;
        this.ppg = ppg;
        this.apg = apg;
        this.rpg = rpg;
    }

}
