package org.rahib.nba;

public class Player {
	private String name;
	private String team;
	private double pointsPerGame;
	private double assistsPerGame;
	private double reboundsPerGame;

	public Player(String name, String team, double pointsPerGame, double assistsPerGame, double reboundsPerGame) {
		this.name = name;
		this.team = team;
		this.pointsPerGame = pointsPerGame;
		this.assistsPerGame = assistsPerGame;
		this.reboundsPerGame = reboundsPerGame;
	}

	public String getName() {
		return name;
	}

	public String getTeam() {
		return team;
	}

	public double getPointsPerGame() {
		return pointsPerGame;
	}

	public double getAssistsPerGame() {
		return assistsPerGame;
	}

	public double getReboundsPerGame() {
		return reboundsPerGame;
	}

	@Override
	public String toString() {
		return "Player" +
				"name ='" + name + '\'' +
				", team='" + team + '\'' +
				", pointsPerGame=" + pointsPerGame +
				", assistsPerGame=" + assistsPerGame +
				", reboundsPerGame=" + reboundsPerGame;
	}
}
