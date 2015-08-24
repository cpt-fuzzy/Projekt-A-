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
	
	public void initializeMove () {
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("x")) {
			byte x = scanner.nextByte();
			byte vectorX = scanner.nextByte();
			byte vectorY = (byte) 0;
			for (int i = 0; i < Game.playBoard.getBase() + 2; i++) 
				Game.tokens[x][i].moveTokenTowards(vectorX, vectorY);
			
		}
		else {
			byte y = scanner.nextByte();
			byte vectorY= scanner.nextByte();
			byte vectorX = 0;
			for (int i = 0; i < Game.playBoard.getBase() + 2; i++) 
				Game.tokens[i][y].moveTokenTowards(vectorX, vectorY);
			
		}
		
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
