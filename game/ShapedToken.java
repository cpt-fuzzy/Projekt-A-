package game;

public abstract class ShapedToken extends Token {
	protected Player affinity;
	
	ShapedToken(int points, boolean isVisible, Player affinity){
		super(points,isVisible);
		this.affinity = affinity;
	}
	
	protected abstract boolean moveAllowed(byte vectorX, byte vectorY) throws Exception;
		
	/*	if (playboard.emptyFieldFrom(x, y, vectorX, vectorY))
			return true;
		
		else if	(vectorX == 1 && x == playField.getBase()+1||
			 (vectorX == -1 && x == 0 )||
			  (vectorY == 1 && y == playField.getBase()+1)||
			   (vectorY == -1&& y == 0)) 
			if (!(Game.playBoard.getTokenOn(x-vectorX,y-vectorY) instanceof this.getClass())||
				this.affinity.equals(Game.playBoard.getTokenOn(x-vectorX, y-vectorY).affinity)
			 	return false;

		else return true;
	*/
	@Override	public Player getAffinity() {
		return affinity;
	}
}
