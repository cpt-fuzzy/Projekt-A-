package game;

import gui.SchiebeGameGUI;

public class FieldUnit {
	
	private byte x;
	private byte y;
	public Token token;
	
	FieldUnit(byte x, byte y,SchiebeGameGUI schiebeGameGUI) {
		this.x = x;
		this.y = y;
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
            return (!(token == null));
        }
}
