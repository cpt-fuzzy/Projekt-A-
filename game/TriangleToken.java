package game;

public class TriangleToken extends ShapedToken {
	
	public TriangleToken (int points, boolean isVisible, Player affinity) {
		super(points,  isVisible,  affinity);
	}
	protected boolean moveAllowed (byte vectorX, byte vectorY) throws Exception {
		
		if	 (Game.playBoard.emptyFieldFrom(x, y, vectorX, vectorY))
		{
			return true;
		}
		else if	((vectorX == 1 && x == Game.playBoard.getBase()+1)||
		 	  (vectorX == -1 && x == 0)||
			   (vectorY == 1 && y == Game.playBoard.getBase()+1)||
			    (vectorY == -1&& y == 0)) 
		{
			if((Game.playBoard.getTokenOn((byte)(x-vectorX),(byte)(y-vectorY)) instanceof TriangleToken||
				Game.playBoard.getTokenOn((byte)(x-vectorX),(byte)(y-vectorY)) instanceof StarToken)&&
					!(this.affinity.equals(Game.playBoard.getTokenOn((byte)(x-vectorX),(byte)(y-vectorY)).getAffinity())))
			{
			return true;
			}
			
			else 
			{
				throw new Exception();
			}
		}
		
		else return true;
	
	}
}
