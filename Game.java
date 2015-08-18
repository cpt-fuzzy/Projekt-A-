import java.util.Random();

public class Game {
	
	protected int turnCount;
	protected Player whoseTurn;
	private boolean gameOn = true;
	Playboard playboard = new Playboard();
	Player player1 = new Player("Player1", 0);
	Player player2 = new Player("Player2", 0);
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
	
	public void initializeGame() {
	playboard.generateField();
	playboard.generateToken();
	
	while(gameOn == true) {
	player1.initializeMove();
	player1.initializeMove();
	player1.endTurn();
	turnCount ++;
	player2.initializeMove();
	player2.initializeMove();
	player2.endTurn();
	turnCount ++;
	}
	}
}
	
	
