package nba_statComparator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class gui extends NBABaseFrame {

		public gui(String title) {
			super(title);
		}

		@Override
		protected void addGuiComponents() {

			JLabel welcomeLabel = new JLabel("Welcome to the NBA Stat Comparator!");
			welcomeLabel.setFont(new Font("Dialog", Font.BOLD, 24));
			welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			welcomeLabel.setBounds(0, 20, getWidth(), 30);
			add(welcomeLabel);

		 /*
			player 1
         */

			JLabel user1 = new JLabel("Enter player one:");
			user1.setBounds(20, 80, 200, 24);
			user1.setFont(new Font("Dialog", Font.PLAIN, 20));
			add(user1);

			/*
				text field for player one
			 */
			JTextField playerOne = new JTextField();
			playerOne.setBounds(20, 110, 200, 30);
			add(playerOne);


			/*
			Player two
			 */
			JLabel user2 = new JLabel("Enter player two:");
			user2.setBounds(20, 160, 200, 24);
			user2.setFont(new Font("Dialog", Font.PLAIN, 20));
			add(user2);

			/*
			text field for player 2
			 */
			JTextField playerTwo = new JTextField();
			playerTwo.setBounds(20, 190, 200, 30);
			add(playerTwo);


			/*
			enter button to generate sql
			 */

			JButton enter = new JButton("Enter");
			enter.setBounds(20, 240, 100, 30);
			add(enter);
			enter.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String NBAP1 = playerOne.getText().trim();
					String NBAP2 = playerTwo.getText().trim();
					if (!jdbc.serverDown()) {

						boolean validatePlayerOne = jdbc.checkPlayerExist(NBAP1);
						boolean validatePlayerTwo = jdbc.checkPlayerExist(NBAP2);

						if (!validatePlayerOne || !validatePlayerTwo) {
							JOptionPane.showMessageDialog(gui.this,
									"One or both players are incorrect. Please try again!");
						} else {
							Player player1 = new Player(NBAP1, jdbc.getTeam(NBAP1),
									jdbc.getPoints(NBAP1), jdbc.getAssists(NBAP1), jdbc.getRebounds(NBAP1));

							Player player2 = new Player(NBAP2, jdbc.getTeam(NBAP2),
									jdbc.getPoints(NBAP2), jdbc.getAssists(NBAP2), jdbc.getRebounds(NBAP2));
//						System.out.println("Player1: " + NBAP1 + ", Team: " + jdbc.getTeam(NBAP1));
//						System.out.println("Player2: " + NBAP2 + ", Team: " + jdbc.getTeam(NBAP2));
//						System.out.println("Player1: " + NBAP1 + ", points + rebounds: " + jdbc.getPoints(NBAP1) + "," + jdbc.getRebounds(NBAP1));
//						System.out.println("Player2: " + NBAP2 + ", points + rebounds: " + jdbc.getPoints(NBAP2) + "," + jdbc.getRebounds(NBAP2));


							gui.this.dispose();
							new showPlayerGui(player1, player2).setVisible(true);
//						Player player1 = new Player(NBAP1, jdbc.getTeam(NBAP1),
//								jdbc.getPoints(NBAP1), jdbc.getAssists(NBAP1), jdbc.getRebounds(NBAP1));
//
//						Player player2 = new Player(NBAP2, jdbc.getTeam(NBAP2),
//								jdbc.getPoints(NBAP2), jdbc.getAssists(NBAP2), jdbc.getRebounds(NBAP2));
//
//						System.out.println("Player1 Created: " + player1.getName() + " | Team: " + player1.getTeam());
//						System.out.println("Player2 Created: " + player2.getName() + " | Team: " + player2.getTeam());
//
//						new showPlayerGui(player1, player2).setVisible(true);
						}

					}
					else{
						JOptionPane.showMessageDialog(null, "Server is temporarily down");
					}
				}

			});


		}

}
