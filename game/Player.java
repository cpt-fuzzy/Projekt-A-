package game;

import gui.SchiebeGameGUI;

public class Player {
	
	private String name;
	private int score;
	protected boolean onTurn;
	
	public Player(String name) {
		this.name = name;
		this.score = 0;
		onTurn = false;
	}
	
	public void initializeMove (char axis, byte whichAxis, byte vector, SchiebeGameGUI schiebeGameGUI)
	{
		byte vectorY = axis == 'y'?vector:0;
		byte vectorX = axis == 'x'?vector:0;
		
		for (byte i = determineFirstToken(axis,whichAxis, vector); vector==1?i >= 0:i <= Game.playBoard.getBase()+1; i += vector==1?-1:+1) 
		{
		
			if(Game.playBoard.playField[axis=='y'?i:whichAxis][axis == 'x'?	i: whichAxis].getHasTokenOnIt())
			{
				try
				{
					Game.playBoard.playField[axis=='y'?i:whichAxis][axis=='x'?i:whichAxis].token.moveTokenTowards(vectorY, vectorX, schiebeGameGUI);		// Eigentliche Bewegung der Steine
					if ((i ==0 && vector == 1)||(i == Game.playBoard.getBase()+1 && vector == -1)||
						(!Game.playBoard.playField[axis=='y'?i-vector:whichAxis][axis=='x'?i-vector:whichAxis].getHasTokenOnIt()))// Falls dies der letzte zu bewegende Token ist, abbrechen 
						break;	
				}
				catch ( Exception moveNotAllowed) {
					System.out.print("Move not Allowed");
					break;
				}
			}
		}
	}				

	private byte determineFirstToken(char axis, byte whichAxis, byte vector)
	{
		byte startMovingAt = vector==1?0:(byte) (Game.playBoard.getBase()+1);
		
		while (vector==1?	startMovingAt <= Game.playBoard.getBase()+1:	startMovingAt >= 0)
		{
			if ((startMovingAt == 0 && vector == -1)||(startMovingAt == Game.playBoard.getBase()+1 && vector ==1)  ||( Game.playBoard.playField[	axis=='y'?	startMovingAt:			whichAxis][axis=='x'?	startMovingAt:whichAxis].getHasTokenOnIt() == true &&
					Game.playBoard.playField[axis=='y'?	startMovingAt+vector:	whichAxis][axis=='x'?	startMovingAt+vector:	whichAxis].getHasTokenOnIt() == false))
			{
				break;
			}
			startMovingAt += vector; 
		}
		return startMovingAt;
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
