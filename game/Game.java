package game;

import java.util.Random;
import gui.SchiebeGameGUI;

public class Game {
	
	static Token tokens[][]	={{null,null,null,null,null,null,null,null,null,null, null},
	{null,null,null,null,null,null,null},{null,null,null,null,null,null,null}}; 
	static PlayBoard playBoard = new PlayBoard(5);
	static Player player[] = {new Player("Neutral"),new Player("Player1"), new Player("Player2")};  			
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
	
	public static void run(SchiebeGameGUI schiebeGameGUI) {
	playBoard.generateField(schiebeGameGUI);
	generateToken();
	tokens[0][0].setXandY(schiebeGameGUI);
	tokens[0][1].setXandY(schiebeGameGUI);
	tokens[0][2].setXandY(schiebeGameGUI);
	tokens[0][3].setXandY(schiebeGameGUI);
	tokens[0][4].setXandY(schiebeGameGUI);
	tokens[0][5].setXandY(schiebeGameGUI);
	tokens[0][6].setXandY(schiebeGameGUI);
	tokens[0][7].setXandY(schiebeGameGUI);
	tokens[0][8].setXandY(schiebeGameGUI);
	tokens[0][9].setXandY(schiebeGameGUI);
	tokens[0][10].setXandY(schiebeGameGUI);
	tokens[1][0].setXandY(schiebeGameGUI);
	tokens[1][1].setXandY(schiebeGameGUI);
	tokens[1][2].setXandY(schiebeGameGUI);
	tokens[1][3].setXandY(schiebeGameGUI);
	tokens[1][4].setXandY(schiebeGameGUI);
	tokens[1][5].setXandY(schiebeGameGUI);
	tokens[1][6].setXandY(schiebeGameGUI);
	tokens[2][0].setXandY(schiebeGameGUI);
	tokens[2][1].setXandY(schiebeGameGUI);
	tokens[2][2].setXandY(schiebeGameGUI);
	tokens[2][3].setXandY(schiebeGameGUI);
	tokens[2][4].setXandY(schiebeGameGUI);
	tokens[2][5].setXandY(schiebeGameGUI);
	tokens[2][6].setXandY(schiebeGameGUI);
	
	/*for(Token[] token:tokens )
	{
		for(Token tokenSingleton : token)
		{
			tokenSingleton.setXandY(schiebeGameGUI);
		}
	}*/
	
	schiebeGameGUI.setVisible(true);
	
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
				for(byte i = 0;i < 11;i++)
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
	
	
