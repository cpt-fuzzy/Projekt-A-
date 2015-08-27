package game;

import java.util.Scanner;
import gui.SchiebeGameGUI;

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
		System.out.print(name + ":\n Move X-Axis or Y-Axis?[x,y] ");
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("y")) {
			System.out.print("Which one?[1-5] ");
			byte xAxis = scanner.nextByte();
			System.out.print("Direction?[-1 = up, 1 = down] ");
			byte vectorX = scanner.nextByte();
			byte vectorY = 0;
			if (vectorX == 1)
				{
				for (byte i = (byte)(Game.playBoard.getBase()+1); i >= 0; i--) 
				{
				
					if(Game.playBoard.playField[i][xAxis].getHasTokenOnIt())
					{
						Game.playBoard.playField[i][xAxis].token.moveTokenTowards(vectorX, vectorY, schiebeGameGUI);
					}
				}
			}	
			else if (vectorX ==-1) 
				{
					for (byte i = 0; i <= Game.playBoard.getBase()+1; i++) 
					{
						if(Game.playBoard.playField[i][xAxis].getHasTokenOnIt()) 
						{
							Game.playBoard.playField[i][xAxis].token.moveTokenTowards(vectorX, vectorY, schiebeGameGUI);
						}
					}				
				}

			}
		else if (choice.equalsIgnoreCase("x")) {
			System.out.print("Which one?[1-5] ");
			byte yAxis = scanner.nextByte();
			System.out.print("Direction? [-1 = left, 1 = right] ");
			byte vectorY= scanner.nextByte();
			byte vectorX = 0;
			if (vectorY == 1)
			{
				for (byte i = (byte)(Game.playBoard.getBase()+1); i >= 0; i--) {
				
					if(Game.playBoard.playField[yAxis][i].getHasTokenOnIt()) {
						Game.playBoard.playField[yAxis][i].token.moveTokenTowards(vectorX, vectorY, schiebeGameGUI);
					
					}
				}
		
			}	
			else if (vectorY ==-1) 
			{
				for (byte i = 0; i <= Game.playBoard.getBase()+1; i++)
				{
				
					if(Game.playBoard.playField[yAxis][i].getHasTokenOnIt())
					{
						Game.playBoard.playField[yAxis][i].token.moveTokenTowards(vectorX, vectorY, schiebeGameGUI);
					
					}
				}				
			}	
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
