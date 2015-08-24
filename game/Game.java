package game;

import java.util.Random;					

public class Game {
	
	static Token tokens[][];
	static PlayBoard playBoard;
	static Player player[]; 			
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
	
	while(true) { 
	player[1].initializeMove(); 
	player[1].initializeMove(); 
	player[1].endTurn();

	player[2].initializeMove(); 
	player[2].initializeMove(); 
	player[2].endTurn();

		}
	}
	public static void generateToken() {
		for(byte z = 0;z<=2;z++){
			if(z==0){
				for(byte i = 0;i<=11;i++)
				{
					tokens[0][i] = new NeutralToken(1,false); 
				}
			}
			else {
				for(byte i = 0;i <=7 ;i++)
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
							tokens[z][i] = 	new TriangleToken(3,false, player[z]);
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
	
	
