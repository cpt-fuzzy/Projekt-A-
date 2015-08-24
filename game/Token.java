package game;
import java.util.Random;

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
	
	protected abstract boolean moveAllowed (byte vectorX, byte vectorY);
	protected abstract Player getAffinity();
	
	public void moveTokenTowards (byte vectorX, byte vectorY) {
		if (moveAllowed(vectorX,vectorY) && inGame == true){
			this.x += vectorX;
			this.y += vectorY;
			if (this.x < (byte)0 || this.y <(byte)0 || this.x > Game.playBoard.getBase() +2 ||  this.y > Game.playBoard.getBase() + 2  ) {
				Game.playBoard.getTokenOn((byte)(x-vectorX),(byte)(y-vectorY)).getAffinity().addScore(points);
			}	inGame = false;
				
			
		}
		else{
			System.out.print("Move not allowed");
		}
	}

	
	public byte getX() {
		return x;
	}

	public byte getY() {
		return y;
	}
	
	public void setXandY() {
		while (true){
			byte randomX = (byte) (random.nextInt(5)+1);
			byte randomY = (byte) (random.nextInt(5)+1);
			if (Game.playBoard.playField[randomX][randomY].hasTokenOnIt == false) {
				x = randomX;
				y = randomY;
	//			gui.SchiebeGameGUI.setName(x,y,this);
				Game.playBoard.playField[x][y].hasTokenOnIt = true;
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

	
}
