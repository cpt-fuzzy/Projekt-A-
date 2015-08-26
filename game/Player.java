package game;

import java.util.Scanner;

public class Player {
	
	private String name;
	private int score;
	protected boolean onTurn;
	Scanner scanner = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.score = 0;
		onTurn = false;
	}
	
	public void initializeMove (SchiebeGameGUI schiebeGameGUI) {
		System.out.print(name + " ist am Zug:\nReihe [r] oder Spalte [c] bewegen? ");
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("x")) {
			byte x = scanner.nextByte();
			System.out.print("In welche Richtung? [-1 = unten, 1 = oben] ");
			byte vectorX = scanner.nextByte();
			byte vectorY = (byte) 0;
			for (int i = 0; i < Game.playBoard.getBase() + 2; i++) {
				if(Game.playBoard.playField[x][i].getHasTokenOnIt())
					Game.tokens[x][i].moveTokenTowards(vectorX, vectorY, schiebeGameGUI);
			}
		}
		else {
			System.out.print("Welche Spalte? [1-5] ");
			byte y = scanner.nextByte();
			System.out.print("In welche Richtung? [-1 = links, 1 = rechts] ");
			byte vectorY= scanner.nextByte();
			byte vectorX = 0;
			for (int i = 0; i < Game.playBoard.getBase() + 2; i++) {
				if(Game.playBoard.playField[i][y].getHasTokenOnIt())
					Game.tokens[i][y].moveTokenTowards(vectorX, vectorY, schiebeGameGUI);
			}
		}
		
		schiebeGameGUI.setVisible(true);
		
	}
	
	public void endTurn() {
		onTurn = false;
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
}
