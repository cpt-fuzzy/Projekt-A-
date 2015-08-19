package game;

public class PlayBoard {

	public byte base;
	public FieldUnit playField[][];


	public PlayBoard(byte base) {
		this.base = base;
//		tokenCounters = new byte[11];
		playField = new FieldUnit[base+2][base+2];	
	}

	public void generateField() {
		for (int i = 0; i< playField.length; i++) 
		{
			for(int j = 0;i<playField[i].length; j++)
			{
				if((i == 0 || i == base+1)&&(j == 0 || j == base+1))
				{
					FieldUnit notPlayableField = new FieldUnit(i,j, false);
					playField[i][j] = notPlayableField;
				}
				else if ((i <= 1 && i >= base )&&(j<= 1 && i >= base)) 
				{
					FieldUnit mainField = new FieldUnit(i,j, true);
					playField[i][j] = mainField;
				}
//				else if  (((i == 2 || i == (playField.length - 3)) && (j >= 2 && j <= (playField.length - 3))) || (i == (playField.length - 4) && i > 1 && (j == 2 || j == (playField.length - 3))))
//				{
//					FieldUnit hiddenField = new FieldUnit(i,j);
//					playField[i][j] = hiddenField;
//				}
				else 
				{
					FieldUnit borderField = new FieldUnit (i,j,false);
					playField[i][j] = borderField;
				}
			}
		}
	}
	
	public boolean emptyFieldFrom(byte x,byte y,byte vectorX,byte vectorY) 
	{
		while(x <= base+1 && x>= 0 && y <= base+1 && y>= 0)
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

	
	public Token getTokenOn(int x, int y)
	{
		return tokens[x][y];
	}
}


