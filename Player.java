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
	
	public void initializeMove(byte vectorX, byte vectorY,byte x, byte y) {
		while(vectorX != 0 || vectorY != 0)
		{
			System.out.println(name + " ist am Zug: Token eingeben: ");
		vectorX = scanner.nextByte();
		vectorY = scanner.nextByte();
		x	= scanner.nextByte();
		y	= scanner.nextByte();
		
		Game.tokens[x][y].moveTokenTowards(vectorX, vectorY); // müsste noch als eine schleife umgeschrieben werden, an alle TOken die betroffen sind
		}
	}
	
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
