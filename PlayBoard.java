import java.util.Random;

public class PlayBoard {
	
	public int width;
	public int height;
	FieldUnit playBoard [] [];
	public String sign;
	private Random random;
	
	PlayBoard (int width, int height) {
		this.width = width;
		this.height = height;
		playBoard = new FieldUnit [width][height];
		random = new Random();
	}
	
	void generatePlayBoard () {
		for (int i = 0; i < playBoard.length; i++) {
			for (int j = 0; j < playBoard[i].length; j++) {
				//Erstellen der Feldbezeichner in ersten Reihe und ersten Spalte
				if (i == 0 && (j >= 2 && j <= 6)) {				
					FieldUnit signField = new FieldUnit (i, j, " " + (j-1) + " ", false);
					playBoard[i][j] = signField;
				}
				else if (j == 0 && (i >= 2 && i <= 6)) {
					FieldUnit signField = new FieldUnit (i, j, " " + (i-1) + " ", false);
					playBoard[i][j] = signField;
				}
				
				//Erstellen der unspielbaren Felder
				else if ((i <= 1 && (j <= 1 || j >= 6)) || (i >= 7 && (j <= 1 || j >= 6))) {
					FieldUnit notPlayableField = new FieldUnit (i, j, " - ", false);
					playBoard[i][j] = notPlayableField;
				} 
				
				//Erstellen der versteckten Felder
				else if (((i == 3 || i == 5) && (j >= 3 && j <= 5)) ||(i == 4 && (j == 3 || j == 5))) {
					FieldUnit hiddenField = new FieldUnit (i, j, " x ", true);
					playBoard[i][j] = hiddenField;
				}
				
				//die restlichen Spielfelder
				else {
					FieldUnit mainField = new FieldUnit (i, j, " x ", false);
					playBoard[i][j] = mainField;
				}
			}
		}
	}
	
	void showPlayBoard () {
		System.out.println("\n");		
		for (int i = 0; i < playBoard.length; i++) {
			for (int j = 0; j < playBoard[i].length; j++) {
				if (playBoard[i][j].willHideToken == true) {
					System.out.print("   ");
				}
				else {
					System.out.print(playBoard[i][j]);
				}
				
			}
			System.out.println();
		}
	}
	
	void generateCoins(int coins) {
		while (coins > 0) {
			int randomX = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			int randomY = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			if (playBoard[randomX][randomY].token.equals(" x ")) {
				playBoard[randomX][randomY].token = " C ";
				coins--;
			}
		}		
	}
	
	void generateRedToken (int star, int square, int triangle, int circle) {
		while (star > 0) {
			int randomX = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			int randomY = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			if (playBoard[randomX][randomY].token.equals(" x ")) {
				playBoard[randomX][randomY].token = " *r";
				star--;
			} 
		}
		
		while (square > 0) {
			int randomX = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			int randomY = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			if (playBoard[randomX][randomY].token.equals(" x ")) {
				playBoard[randomX][randomY].token = " Sr";
			} 
			square--;
		}
		
		while (triangle > 0) {
			int randomX = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			int randomY = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			if (playBoard[randomX][randomY].token.equals(" x ")) {
				playBoard[randomX][randomY].token = " Tr";
				triangle--;
			} 
		}
		
		while (circle > 0) {
			int randomX = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			int randomY = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			if (playBoard[randomX][randomY].token.equals(" x ")) {
				playBoard[randomX][randomY].token = " Or";
				circle--;
			} 
		}
	}
	
	void generateBlueToken (int star, int square, int triangle, int circle) {
		while (star > 0) {
			int randomX = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			int randomY = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			if (playBoard[randomX][randomY].token.equals(" x ")) {
				playBoard[randomX][randomY].token = " *b";
				star--;
			} 
		}
		
		while (square > 0) {
			int randomX = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			int randomY = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			if (playBoard[randomX][randomY].token.equals(" x ")) {
				playBoard[randomX][randomY].token = " Sb";
				square--;
			} 
			
		}
		
		while (triangle > 0) {
			int randomX = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			int randomY = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			if (playBoard[randomX][randomY].token.equals(" x ")) {
				playBoard[randomX][randomY].token = " Tb";
				triangle--;
			} 
		}
		
		while (circle > 0) {
			int randomX = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			int randomY = random.nextInt(5) + 2; //+2, weil nur in den Feldern 1-5 Einheiten starten
			if (playBoard[randomX][randomY].token.equals(" x ")) {
				playBoard[randomX][randomY].token = " Ob";
				circle--;
			} 
		}
	}
}
