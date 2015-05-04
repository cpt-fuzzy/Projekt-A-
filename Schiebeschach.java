import java.util.*;

public class Schiebeschach {
	public static void main (String [] args) {
		
		Scanner scanner = new Scanner (System.in);
		String [][] spielfelder = new String [6][5];
		String [][] versteckteSpielfelder = new String [6][5];
		String [][] cache = new String [1][1];
		
		//Füllen mit Spielfeldhaltern
		for (int row = 0; row < spielfelder.length; row++) {
			for (int col = 0; col < spielfelder[row].length; col++) {
				spielfelder[row][col] = "[ ]";
			}
		}
		for (int row = 0; row < versteckteSpielfelder.length; row++) {
			for (int col = 0; col < versteckteSpielfelder[row].length; col++) {
				versteckteSpielfelder[row][col] = "[x]";
			}
		}
		System.out.println("\n");
		//Ausgabe
		for (int row = 0; row < spielfelder.length; row++) {
			for (int col = 0; col < spielfelder[row].length; col++) {
				if (row == 0 ) {
					if (col == 0) {
						System.out.print("   ");
					}
					System.out.print(" " + (col + 1) + ".");
				}
				else {
					if (col == 0 ) {
						System.out.print((row) + ". ");
					}
					System.out.print(spielfelder[row][col]);
				}
			}
			System.out.println();
		}
		
		
		//move 1. Zeile nach rechts
		
		
		//Ausgabe des bewegten Array
		for (int row = 0; row < spielfelder.length; row++) {
			for (int col = 0; col < spielfelder[row].length; col++) {
				if (row == 0 ) {
					if (col == 0) {
						System.out.print("   ");
					}
					System.out.print(" " + (col + 1) + ".");
				}
				else {
					if (col == 0 ) {
						System.out.print((row) + ". ");
					}
					System.out.print(spielfelder[row][col]);
				}
			}
			System.out.println();
		}
		
	}
}