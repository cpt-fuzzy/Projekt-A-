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
		char axis = scanner.next().charAt(0);
		if (axis == 'y') {
			System.out.print("Which one?[1-5] ");
			byte whichAxis = scanner.nextByte();
			System.out.print("Direction?[-1 = up, 1 = down] ");
			byte vectorY = scanner.nextByte();
			byte vectorX = 0;
			if (vectorY == 1)
				{
				for (byte i = determineStartpointYPos(whichAxis); i >= 0; i--) 
				{
				
					if(Game.playBoard.playField[i][whichAxis].getHasTokenOnIt())
					{
						Game.playBoard.playField[i][whichAxis].token.moveTokenTowards(vectorY, vectorX, schiebeGameGUI);
						if (!Game.playBoard.playField[i-1][whichAxis].getHasTokenOnIt())
							break;
					}
				}
			}	
			else if (vectorY ==-1) 
				{
					for (byte i = determineStartpointYNeg(whichAxis); i <= Game.playBoard.getBase()+1; i++) 
					{
						if(Game.playBoard.playField[i][whichAxis].getHasTokenOnIt()) 
						{
							Game.playBoard.playField[i][whichAxis].token.moveTokenTowards(vectorY, vectorX, schiebeGameGUI);
							if (!Game.playBoard.playField[i+1][whichAxis].getHasTokenOnIt())
								break;
						}
					}				
				}

			}
		else if (axis=='x') {
			System.out.print("Which one?[1-5] ");
			byte whichAxis = scanner.nextByte();
			System.out.print("Direction? [-1 = left, 1 = right] ");
			byte vectorX= scanner.nextByte();
			byte vectorY = 0;
			if (vectorX == 1)
			{
				for (byte i = determineStartpointXPos(whichAxis); i >= 0; i--) {
				
					if(Game.playBoard.playField[whichAxis][i].getHasTokenOnIt()) {
						Game.playBoard.playField[whichAxis][i].token.moveTokenTowards(vectorY, vectorX, schiebeGameGUI);
					
					}
				}
		
			}	
			else if (vectorX ==-1) 
			{
				for (byte i = determineStartpointXNeg(whichAxis); i <= Game.playBoard.getBase()+1; i++)
				{
				
					if(Game.playBoard.playField[whichAxis][i].getHasTokenOnIt())
					{
						Game.playBoard.playField[whichAxis][i].token.moveTokenTowards(vectorY, vectorX, schiebeGameGUI);
						if (!Game.playBoard.playField[whichAxis][i+1].getHasTokenOnIt())
							break;
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
	private byte determineStartpointXNeg(byte whichAxis)
	{
		byte startMovingAt = (byte)(Game.playBoard.getBase()+1);
		while (startMovingAt >= 0)
		{
			if ( Game.playBoard.playField[whichAxis][startMovingAt].getHasTokenOnIt() == true && Game.playBoard.playField[whichAxis][startMovingAt-1].getHasTokenOnIt() == false)
			{
				break;
			}
			startMovingAt--; 
		}
		return startMovingAt;
	}
	private byte determineStartpointXPos(byte whichAxis)
	{
		byte startMovingAt = 0;
		while (startMovingAt <= Game.playBoard.getBase()+1)
		{
			if ( Game.playBoard.playField[whichAxis][startMovingAt].getHasTokenOnIt() == true && Game.playBoard.playField[whichAxis][startMovingAt+1].getHasTokenOnIt() == false)
			{
				break;
			}
			startMovingAt++; 
		}
		return startMovingAt;
	}
	private byte determineStartpointYPos(byte whichAxis)
	{
		byte startMovingAt = 0;
		while (startMovingAt <= Game.playBoard.getBase()+1)
		{
			if ( Game.playBoard.playField[startMovingAt][whichAxis].getHasTokenOnIt() == true && Game.playBoard.playField[startMovingAt+1][whichAxis].getHasTokenOnIt() == false)
			{
				break;
			}
			startMovingAt++; 
		}
		return startMovingAt;
	}
	private byte determineStartpointYNeg(byte whichAxis)
	{
		byte startMovingAt = (byte) (Game.playBoard.getBase()+1);
		while (startMovingAt >= 0)
		{
			if ( Game.playBoard.playField[startMovingAt][whichAxis].getHasTokenOnIt() == true && Game.playBoard.playField[startMovingAt-1][whichAxis].getHasTokenOnIt() == false)
			{
				break;
			}
			startMovingAt--; 
		}
		return startMovingAt;
	}
}
