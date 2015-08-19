import java.util.Random();					

public class Game {
	
	static Token tokens[][];
	static PlayBoard playBoard;
	static Player player[]; 
	protected int turnCount;
	private boolean gameOn = true;				
	Random rn = new Random();			
						
	/*public void determineTurnStart() {
		int coin = rn.nextInt(2);
		
			if(coin == 0) {
				player1.onTurn = true;
			}
			
			else if(coin == 1) {
				player2.onTurn = true;
			}
	}*/
	
	public static void run() {
	PlayBoard playBoard = new PlayBoard((byte)5);
	Player player[] = {new Player("Neutral"),new Player("Player1"), new Player("Player2")};
	playBoard.generateField();
	generateToken();
	
	while(gameOn == true) { 
	player[1].initializeMove((byte)0,(byte)0,(byte)0,(byte)0); 
	player[1].initializeMove((byte)0,(byte)0,(byte)0,(byte)0); 
	player[1].endTurn();
	turnCount ++;
	player[2].initializeMove((byte)0,(byte)0,(byte)0,(byte)0); 
	player[2].initializeMove((byte)0,(byte)0,(byte)0,(byte)0); 
	player[2].endTurn();
	turnCount ++;
		}
	}
	public static void generateToken() {
		for(int z = 0;z<=2;z++){
			if(z==0){
				for(int i = 0;i<=11;i++)
				{
					tokens[0][i] = new NeutralToken(1,false, player[z]); 
				}
			}
			else {
				for(int i = 0;i <=7 ;i++)
			{
					switch(i) {
						case 0: case 1:{
							tokens[z][i] = 	new CircleToken(3,false, player[z]);
							break;
						}
						case 2: case 3:{
							tokens[z][i] = 	new SquareToken(3,false, player[z]);
							break;
						}
						case 4: case 5:{
							tokens[z][i] = 	new Triangle(3,false, player[z]);
							break;
						}
						case 6:{
							tokens[z][i] = 	new StarToken(3,false, player[z]);
							break;
						}
					}
				}
			}
		}
	}
}
	
	
