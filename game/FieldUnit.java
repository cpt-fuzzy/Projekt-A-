package game;

import gui.SchiebeGameGUI;

public class FieldUnit {
	
	public byte x;
	public byte y;
	public boolean hasTokenOnIt;
	
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
}
