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
		for (byte i = (byte)0; i< playField.length; i++) 
		{
			for(byte j = (byte) 0;j<playField[i].length; j++)
			{
				if((i ==(byte) 0 || i == base+(byte)1)&&(j ==(byte) 0 || j == base+(byte)1))
				{
					FieldUnit notPlayableField = new FieldUnit(i, j, schiebeGameGUI);
					playField[i][j] = notPlayableField;
				}
				else if ((i <= (byte)1 && i >= base )&&(j<= (byte)1 && i >= base)) 
				{
					FieldUnit mainField = new FieldUnit(i,j, schiebeGameGUI);
					playField[i][j] = mainField;
                                }

				else 
				{
					FieldUnit borderField = new FieldUnit (i,j, schiebeGameGUI);
					playField[i][j] = borderField;
				}
				System.out.println("go");
			}
		}
	}
	
	public boolean emptyFieldFrom(byte x,byte y,byte vectorX,byte vectorY) 
	{
		while(x <= base+(byte)1 && x>=(byte) 0 && y <= base+(byte)1 && y>= (byte) 0)
		{
			if(playField[x][y].getHasTokenOnIt()) return true;
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
		return Game.tokens[x][y];
	}
}


