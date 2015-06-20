public class main {
	public static void main(String[]args) {
		
		
		// Generate PlayBoard 
		FieldUnit playBoard[][] = new FieldUnit[9][9];
		
		for(byte i = 0; i<playBoard.length; i++){
			for(byte j = 0; j<playBoard[i].length;j++) {
				
				if((j == 0 && i == 0) ||(j == 0 && i == 1) ||(j == 0 && i == 7) ||(j == 0 && i == 8) ||
				(j == 1 && i == 0) ||(j == 1 && i == 1) ||(j == 1 && i == 7) ||(j == 1 && i == 8) ||
				(j == 7 && i == 0) ||(j == 7 && i == 1) ||(j == 7 && i == 7) ||(j == 7 && i == 8) ||
				(j == 8 && i == 0) ||(j == 8 && i == 1) ||(j == 8 && i == 7) ||(j == 8 && i == 8)){
					
					FieldUnit corner = new FieldUnit(i, j, false, false, false);
					System.out.print("   ");
				}
				
				else if ((i == 3 && j == 3) || (i == 3 && j == 4) || (i == 3 && j == 5) ||
				(i == 4 && j == 3) || (i == 4 && j == 5) ||
				(i == 5 && j == 3) || (i == 5 && j == 4) || (i == 5 && j == 5)) {
					
					FieldUnit hideField = new FieldUnit (i, j, true, false, true);
					System.out.print("[x]");
				}
				else {
					FieldUnit mainField  = new FieldUnit(i,j, true, false, false);
					System.out.print("[ ]");
				}
			}
			System.out.println("");
		}
	}
}
