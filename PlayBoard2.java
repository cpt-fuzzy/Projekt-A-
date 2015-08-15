public class PlayBoard {

	byte base;
	FieldUnit playBoard[][];
	byte tokenCounters[]; // Die tokenCounters Lösung ist aus meiine Sicht etwas suboptimal, vielleicht sollte die Idee eines Counters für die Token mit affinität besser in der Player Klasse stehen...
	Token tokens[][];

	public Playboard(byte base) {
		this.base = base;
		tokenCounters = new byte[11];
		playBoard = new FieldUnit[base+2][base+2];
		
	}
	public void generateToken() {
		for(int i = 0;i<=11;i++)
		{
			tokens[0][i] = new NeutralToken(((byte)0,(byte)0,1,false)); 
		}
		for(int i = 0;i <=7 ;i++)
		{
			switch(i) {
			case 0: case 1:{
				tokens[1][i] = 	new CircleToken((byte)0,(byte)0,3,game.player1);
				break;
			}
			case 2: case 3:{
				tokens[1][i] = 	new SquareToken((byte)0,(byte)0,3,game.player1);
				break;
			}
			case 4: case 5:{
				tokens[1][i] = 	new CircleToken((byte)0,(byte)0,3,game.player1);
				break;
			}
			case 6:{
				tokens[1][i] = 	new StarToken((byte)0,(byte)0,3,player1);
				break;
			}
			}
		}
		for(int i  = 0;i <=7 ;i++)
		{
			switch(i) {
			case 0: case 1:{
				tokens[2][i] = 	new CircleToken((byte)0,(byte)0,3,game.player2);
				break;
			}
			case 2: case 3:{
				tokens[2][i] = 	new SquareToken((byte)0,(byte)0,3,game.player2);
				break;
			}
			case 4: case 5:{
				tokens[2][i] = 	new CircleToken((byte)0,(byte)0,3,game.player2);
				break;
			}
			case 6:{
				tokens[2][i] = 	new StarToken((byte)0,(byte)0,3,game.player2);
				break;
			}
		}
	}
	
	public void generateField() {
		for (int i = 0; i< playBoard.length; i++) 
		{
			for(int j = 0;i<playBoard[i].length; j++)
			{
				if((i == 0 || i == base+1)&&(j == 0 || j == base+1))
				{
					FieldUnit notPlayableField = new FieldUnit(i,j,false);
					playBoard[i][j] = notPlayableField;
				}
				else if  (((i == 2 || i == (playBoard.length - 3)) && (j >= 2 && j <= (playBoard.length - 3))) || (i == (playBoard.length - 4) && i > 1 && (j == 2 || j == (playBoard.length - 3))))
				{
					FieldUnit hiddenField = new FieldUnit(i,j,true);
					playBoard[i][j] = hiddenField;
				}
				else 
				{
					FieldUnit normalField = new FieldUnit (i,j, false);
					playBoard[i][j] = normalField;
				}
			}
		}
	}

	public byte getBase() 
	{
		return base;
	}

	public void setBase(byte base) 
	{
		this.base = base;
	}

	public byte getTokenCounter(int i) 
	{
		return tokenCounters[i];
	}

	public void setTokenCounter(int i, int change) 
	{
		tokenCounters[i] += tokenCounters[i];
	}
	
	public Token getTokenOn(int x, int y)
	{
		return playBoard[x][y].getToken();
	}
}
