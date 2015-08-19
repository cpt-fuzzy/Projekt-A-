package game;
import java.util.Random;

public abstract class Token {

	protected byte x;
	protected byte y;
	protected int points;
	protected boolean isVisible;
	protected boolean inGame;
	Random random = new Random();
	
	Token(int points,boolean isVisible)
	{
		this.points = points;
		this.isVisible = isVisible;
		inGame = true;
	}
	
	protected abstract boolean moveAllowed (byte vectorX, byte vectorY);
	protected abstract Token getAffinity();
	
	public void moveTokenTowards (byte vectorX, byte vectorY) {
		if (moveAllowed(vectorX,vectorY) && inGame == true){
			//muss die Bewegung in den beiden Achsen nicht in aufgeteilt werden? Also erst die eine,
			//dann prüfen, ob das erlaubt ist und dann die andere? und das auch in variabler Reihenfolge
			//der Spieler bewegt ja nicht immer zuerst die Reihe und dann die Spalte, sondern auch mal andersrum
			//und wenn man jetzt beide verschiebungen als eine sieht, dann werden ja kills oder so was übersehen
			this.x += vectorX;
			this.y += vectorY;
			if (this.x < 0 || this.y <0 || this.x > Game.playBoard.getBase() + 2 ||  this.y > Game.playBoard.getBase() + 2  ) {
				inGame = false;
				if (Game.playBoard.getTokenOn(x-vectorX, y-vectorY)instanceof ShapedToken)
						Game.playBoard.getTokenOn(x-vectorX, y-vectorY).getAffinity().increaseScore(points);
			}
				
			
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
			byte randomX = random.nextInt(5)+1;
			byte randomY = random.nextInt(5)+1;
			if (PlayBoard.FieldUnit[randomX][randomY].hasTokenOnIt == false) {
				x = randomX;
				y = randomY;
				PlayBoard.FieldUnit[x][y].hasTokenOnIt == true;
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

package game;

public class NeutralToken extends Token {
	NeutralToken(byte x, byte y,int points,boolean isVisible) {
		super(x,y, points, isVisible);
	}
	
	protected boolean moveAllowed (byte vectorX, byte vectorY) {
		if (Game.playBoard.emptyFieldFrom(x, y, vectorX, vectorY))
			return true;
		
		else if	((vectorX == 1 && x == Game.playBoard.getBase()+1)||
			 	  (vectorX == -1 && x == 0)||
				   (vectorY == 1 && y == Game.playBoard.getBase()+1)||
				    (vectorY == -1&& y == 0)) 
			if(!(Game.playBoard.getTokenOn(x-vectorX,y-vectorY) instanceof NeutralToken))
				return false;
			else 
				return true;
			

		else return true;
		}
		
	}

package game;

public abstract class ShapedToken extends Token {
	protected Player affinity;
	
	ShapedToken(byte x, byte y, int points, boolean isVisible, Player affinity){
		super(x,y,points,isVisible);
		this.affinity= affinity;
	}
	
	protected abstract boolean moveAllowed(byte vectorX, byte vectorY);
		
	/*	if (playboard.emptyFieldFrom(x, y, vectorX, vectorY))
			return true;
		
		else if	(vectorX == 1 && x == playField.getBase()+1||
			 (vectorX == -1 && x == 0 )||
			  (vectorY == 1 && y == playField.getBase()+1)||
			   (vectorY == -1&& y == 0)) 
			if (!(playField.getTokenOn(x-vectorX,y-vectorY) instanceof this.getClass())||
				this.affinity.equals(playField.getTokenOn(x-vectorX, y-vectorY).affinity)
			 	return false;

		else return true;
	*/
	public Player getAffinity() {
		return affinity;
	}
}
package game;

public class TriangleToken extends ShapedToken {
	
	public TriangleToken (byte x, byte y, int points, boolean isVisible, Player affinity) {
		super( x,  y,  points,  isVisible,  affinity);
	}
	protected boolean moveAllowed (byte vectorX, byte vectorY) {
		
		if	 (Game.playBoard.emptyFieldFrom(x, y, vectorX, vectorY))
			return true;
		
		else if	((vectorX == 1 && x == Game.playBoard.getBase()+1)||
		 	  (vectorX == -1 && x == 0)||
			   (vectorY == 1 && y == Game.playBoard.getBase()+1)||
			    (vectorY == -1&& y == 0)) 
			if(!(Game.playBoard.getTokenOn(x-vectorX,y-vectorY) instanceof TriangleToken)||
				this.affinity.equals(Game.playBoard.getTokenOn(x-vectorX, y-vectorY).getAffinity()))
				return false;
			else return true;
	
		else return true;
	
	}
}


package game;

public class CircleToken extends ShapedToken {
	
	public CircleToken(byte x, byte y, int points, boolean isVisible, Player affinity) {
		super( x,  y,  points,  isVisible,  affinity);
	}
	protected boolean moveAllowed (byte vectorX, byte vectorY) {
			
		if	(Game.playBoard.emptyFieldFrom(x, y, vectorX, vectorY))
			return true;
		
		else if	((vectorX == 1 && x == Game.playBoard.getBase()+1)||
		 	  (vectorX == -1 && x == 0)||
			   (vectorY == 1 && y == Game.playBoard.getBase()+1)||
			    (vectorY == -1&& y == 0)) 
			if(!(Game.playBoard.getTokenOn(x-vectorX,y-vectorY) instanceof CircleToken)||
				this.affinity.equals(Game.playBoard.getTokenOn(x-vectorX, y-vectorY).getAffinity()))
				return false;
			else return true;
			

		else return true;
	
	}
}



package game;

public class SquareToken extends ShapedToken {

	public SquareToken (byte x, byte y, int points, boolean isVisible, Player affinity) {
		super( x,  y,  points,  isVisible,  affinity);
	}
	protected boolean moveAllowed (byte vectorX, byte vectorY) {
			
		if 	(Game.playBoard.emptyFieldFrom(x, y, vectorX, vectorY))
			return true;
		
		else if	((vectorX == 1 && x == Game.playBoard.getBase()+1)||
		 	  (vectorX == -1 && x == 0)||
			   (vectorY == 1 && y == Game.playBoard.getBase()+1)||
			    (vectorY == -1&& y == 0)) 
			if(!(Game.playBoard.getTokenOn(x-vectorX,y-vectorY) instanceof SquareToken)||
				this.affinity.equals(Game.playBoard.getTokenOn(x-vectorX, y-vectorY).getAffinity()))
				return false;
			else return true;
			

		else return true;
	
	}
}



package game;

public class StarToken extends ShapedToken {

	public StarToken(byte x, byte y, int points, boolean isVisible, Player affinity) {
		super( x,  y,  points,  isVisible,  affinity);
	}
	protected boolean moveAllowed (byte vectorX, byte vectorY) {
			
		if	(Game.playBoard.emptyFieldFrom(x, y, vectorX, vectorY))
			return true;
		
		else if	((vectorX == 1 && x == Game.playBoard.getBase()+1)||
		 	  (vectorX == -1 && x == 0)||
			   (vectorY == 1 && y == Game.playBoard.getBase()+1)||
			    (vectorY == -1&& y == 0)) 
			if(!(Game.playBoard.getTokenOn(x-vectorX,y-vectorY) instanceof ShapedToken)||
				this.affinity.equals(Game.playBoard.getTokenOn(x-vectorX, y-vectorY).getAffinity()))
				return false;
			else return true;
			

		else return false;
	
	}
}
