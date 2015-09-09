package game;

import gui.SchiebeGameGUI;

public class PlayBoard {

	private byte base;
	public FieldUnit playField[][];


	public PlayBoard(byte base) {
		this.base = base;
		playField = new FieldUnit[base+2][base+2];	
	}

	public void generateField(SchiebeGameGUI schiebeGameGUI) {
		for (byte x = (byte)0; x< playField.length; x++) 
		{
			for(byte y = (byte) 0;y<playField[x].length; y++)
			{
				if((x ==(byte) 0 || x == base+(byte)1)&&(y ==(byte) 0 || y == base+(byte)1))
				{
					FieldUnit notPlayableField = new FieldUnit(x, y, schiebeGameGUI);
					playField[x][y] = notPlayableField;
				}
				else if ((x <= (byte)1 && x >= base )&&(y<= (byte)1 && y >= base)) 
				{
					FieldUnit mainField = new FieldUnit(x,y, schiebeGameGUI);
					playField[x][y] = mainField;
                                }

				else 
				{
					FieldUnit borderField = new FieldUnit (x,y, schiebeGameGUI);
					playField[x][y] = borderField;
				}
			}
		}
	}
	
	public boolean emptyFieldFrom(byte x,byte y,byte vectorX,byte vectorY) 
	{
		while(x <= base+(byte)1 && x>=(byte) 0 && y <= base+(byte)1 && y>= (byte) 0)
		{
			if(!playField[x][y].getHasTokenOnIt()) return true;
			x+=vectorX;
			y+=vectorY; 
		}
			return false;
	}

	public byte getBase() 
	{
		return base;
	}

	public void setBase(byte base) 
	{
		this.base = base;
	}

	
	public Token getTokenOn(byte x, byte y)
	{
		return playField[x][y].token;
	}
}


