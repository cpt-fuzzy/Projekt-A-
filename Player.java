import java.util.Scanner;

public class Player {
	
	private String name;
	private int score;
	private byte vectorx;
	private byte vectory;
	protected boolean onTurn;
	Scanner scanner = new Scanner(System.in);
	
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
		onTurn = false;
	}
	
	public void initializeMove(Token tokens[x][y]) {
		System.out.println(getName() + " ist am Zug: Token eingeben: ");
		vectorx = scanner.next();
		vectory = scanner.next();
		token.moveTokenTowards(vectorx, vectory);
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