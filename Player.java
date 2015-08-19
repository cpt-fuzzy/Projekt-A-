import java.util.Scanner;

public class Player {
	
	private String name;
	private int score;
	protected boolean onTurn;
	Scanner scanner = new Scanner(System.in);
	
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
		onTurn = false;
	}
	
	public void initializeMove () {
		System.out.print(name + " ist am Zug:\nReihe [r] oder Spalte [c] bewegen? ");
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("r")) {
			System.out.print("Welche Reihe? [1-5] ");
			x = scanner.nextByte();
			System.out.print("In welche Richtung? [-1 = links, 1 = rechts] ");
			vectorX = scanner.nextByte();
			vectorY = 0;
			for (int i = 0; i < PlayBoard.base + 2; i++) {
				Game.tokens[x][i].moveTokenTowards(vectorX, vectorY);
			}
		}
		else {
			System.out.print("Welche Spalte? [1-5] ");
			y = scanner.nextByte();
			System.out.print("In welche Richtung? [-1 = links, 1 = rechts] ");
			vectorY= scanner.nextByte();
			vectorX = 0;
			for (int i = 0; i < PlayBoard.base + 2; i++) {
				Game.tokens[i][y].moveTokenTowards(vectorX, vectorY);
			}
		}
		
	}
	/*public void initializeMove(byte vectorX, byte vectorY,byte x, byte y) {
		while(vectorX != 0 || vectorY != 0)
		{
			System.out.println(name + " ist am Zug: Token eingeben: ");
		vectorX = scanner.nextByte();
		vectorY = scanner.nextByte();
		x	= scanner.nextByte();
		y	= scanner.nextByte();
		
		Game.tokens[x][y].moveTokenTowards(vectorX, vectorY); // müsste noch als eine schleife umgeschrieben werden, an alle TOken die betroffen sind
		}
	}*/
	
	public void endTurn() {
		onTurn = false;
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
}
