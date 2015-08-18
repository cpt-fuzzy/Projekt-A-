import java.util.Random();					

public class Game {
	
	protected int turnCount;
	protected Player whoseTurn;				// whoseTurn ist eigentlich unnötig, wenn man den spielablauf in der run() methode korrekt ausgeführt wird, klar das stand im UML drin, kann aber gestrichen werden
	private boolean gameOn = true;				
	Playboard playboard = new Playboard();			// müsste statisch sein und in run initialisiert werden
	Player player1 = new Player("Player1", 0);		// wenn man für die Player ein Array verwendet kann man 
	Player player2 = new Player("Player2", 0);		//hier un da ein paar Zeilen Code in der Initialisierung der Token sparen
	Random rn = new Random();				//
								//würde hier auch noch die statischen Objekte playBoard und Token[] deklarieren und in run() initialisieren wie 
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
	playboard.generateField();
	playboard.generateToken();
	
	while(gameOn == true) {					// wenn man in der schleife eine break Bedingung einsetzt wenn einer der Spieler keine Token hat kann man sich gameOn sparen und damit Speicher 
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
	
	
