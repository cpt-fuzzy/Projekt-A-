package game;
import java.util.Random;
import gui.SchiebeGameGUI;

public abstract class Token {

	protected byte x;
	protected byte y;
	protected int points;
	protected boolean isVisible;
	protected boolean inGame;
	protected Player affinity;
	
	Random random = new Random();
	
	Token(int points,boolean isVisible)
	{
		this.points = points;
		this.isVisible = isVisible;
		inGame = true;
	}
	
	protected abstract boolean moveAllowed (byte vectorX, byte vectorY) throws Exception;
	
	public void moveTokenTowards (byte vectorX, byte vectorY, SchiebeGameGUI schiebeGameGUI) {
		if (moveAllowed(vectorX,vectorY) && inGame == true)
		{
			Game.playBoard.playField[x][y].token = null;
			schiebeGameGUI.setButtonEmpty(x,y);
			this.x += vectorX;
			this.y += vectorY;
		}
			if (this.x < (byte)0 || this.y <(byte)0 || this.x > Game.playBoard.getBase() +2 ||  this.y > Game.playBoard.getBase() + 2  ) 
			{
				Game.playBoard.getTokenOn((byte)(x-vectorX),(byte)(y-vectorY)).getAffinity().addScore(points);
				inGame = false;
			}
			else 
			{
				Game.playBoard.playField[x][y].token = this;
				schiebeGameGUI.setButton(x,y, this);
			}
				
	}

	
	public byte getX() {
		return x;
	}

	public byte getY() {
		return y;
	}
	
	public void setXandY(SchiebeGameGUI schiebeGameGUI) {
		while (true){
			byte randomX = (byte) (random.nextInt(5)+1);
			byte randomY = (byte) (random.nextInt(5)+1);
			if (Game.playBoard.playField[randomX][randomY].getHasTokenOnIt() == false) {
				x = randomX;
				y = randomY;
				Game.playBoard.playField[x][y].token = this;
				schiebeGameGUI.setButton(x,y,this);
				break;
			}
		}
	}

	boolean getVisibility() {
		return isVisible;
	}
	
	boolean getInGame() {
		return inGame;
	}
	public Player getAffinity() {
		return Game.player[0];
}
}
