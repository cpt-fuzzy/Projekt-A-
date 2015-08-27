package game;

import gui.SchiebeGameGUI;

public class FieldUnit {
	
	private byte x;
	private byte y;
	private boolean hasTokenOnIt;
	public Token token;
	
	FieldUnit(byte x, byte y, boolean hasTokenOnIt,SchiebeGameGUI schiebeGameGUI) {
		this.x = x;
		this.y = y;
		this.hasTokenOnIt = hasTokenOnIt;
		schiebeGameGUI.setUpField(x,y);
	}
	
	public byte getX () {
		return x;
	}
	
	public byte getY () {
		return y;
	}
        
        public boolean getHasTokenOnIt() 
        {
            return hasTokenOnIt;
        }
        public void setHasTokenOnIt(boolean hasTokenOnIt) 
	{
    		this.hasTokenOnIt = hasTokenOnIt;
    	}
}
