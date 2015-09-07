public class PlattendriftMain {
	public static void main(String[]args) {
		
		PlayBoard playBoard = new PlayBoard(8, 8);
		playBoard.generatePlayBoard();
		playBoard.generateCoins(11);
		playBoard.generateRedToken(1, 2, 2, 2);
		playBoard.generateBlueToken(1, 2, 2, 2);
		playBoard.showPlayBoard();
		
		PlayBoard playBoard2 = new PlayBoard(7,7);
		playBoard2.generatePlayBoard();
		playBoard2.generateCoins(8);
		playBoard2.generateRedToken(1, 1, 1, 1);
		playBoard2.generateBlueToken(1, 1, 1, 1);
		playBoard2.showPlayBoard();
		
		PlayBoard playBoard3 = new PlayBoard(6,6);
		playBoard3.generatePlayBoard();
		playBoard3.generateCoins(5);
		playBoard3.generateRedToken(0, 1, 0, 1);
		playBoard3.generateBlueToken(0, 1, 1, 0);
		playBoard3.showPlayBoard();
		
		PlayBoard playBoard4 = new PlayBoard(5,5);
		playBoard4.generatePlayBoard();
		playBoard4.generateCoins(0);
		playBoard4.generateRedToken(0, 1, 0, 1);
		playBoard4.generateBlueToken(0, 1, 1, 0);
		playBoard4.showPlayBoard();
		
		
	}
}
