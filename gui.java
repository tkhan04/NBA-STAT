package org.rahib.nba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class gui {

	private JFrame frame;
	private JComboBox<String> playerComboBox;
	private JTextArea playerDetailsTextArea;
	private List<Player> players;

	public gui(List<Player> players) {
		this.players = players;
		initialize();
	}

	private void initialize() {
		frame = new JFrame("NBA Stats Viewer");
		frame.setSize(400, 300);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel for player selection
		JPanel selectionPanel = new JPanel();
		selectionPanel.setLayout(new FlowLayout());
		JLabel selectionLabel = new JLabel("Select a player:");
		playerComboBox = new JComboBox<>();
		playerComboBox.addItem("Select a player");
		for (Player player : players) {
			playerComboBox.addItem(player.getName());
		}
		playerComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updatePlayerDetails();
			}
		});

		selectionPanel.add(selectionLabel);
		selectionPanel.add(playerComboBox);

		JPanel detailsPanel = new JPanel();
		detailsPanel.setLayout(new BorderLayout());
		JLabel detailsLabel = new JLabel("Player Details:");
		playerDetailsTextArea = new JTextArea(10, 30);
		playerDetailsTextArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(playerDetailsTextArea);

		detailsPanel.add(detailsLabel, BorderLayout.NORTH);
		detailsPanel.add(scrollPane, BorderLayout.CENTER);

		frame.add(selectionPanel, BorderLayout.NORTH);
		frame.add(detailsPanel, BorderLayout.CENTER);

		frame.setVisible(true);
	}

	private void updatePlayerDetails() {
		String selectedPlayerName = (String) playerComboBox.getSelectedItem();
		if (selectedPlayerName != null && !selectedPlayerName.equals("Select a player")) {
			Player selectedPlayer = getPlayerByName(selectedPlayerName);
			if (selectedPlayer != null) {
				playerDetailsTextArea.setText(selectedPlayer.toString());
			}
		} else {
			playerDetailsTextArea.setText("");
		}
	}

	private Player getPlayerByName(String name) {
		for (Player player : players) {
			if (player.getName().equals(name)) {
				return player;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		List<Player> players = temp.getPlayers();

		// Create the GUI
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new gui(players);
			}
		});
	}


}
