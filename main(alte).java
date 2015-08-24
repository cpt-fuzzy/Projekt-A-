public class main {
	public static void main(String[]args) {
		
		
		// Generate PlayBoard 
		FieldUnit playBoard[][] = new FieldUnit[7][7];
		
		for(byte i = 0; i<playBoard.length; i++){
			for(byte j = 0; j<playBoard[i].length;j++) {
				
				if((j == 0 && i == 0) ||(j == 0 && i == 6) ||(j == 6 && i == 0) ||(j == 6 && i == 6))
				{
					FieldUnit corner = new FieldUnit(i, j, false, false, false);
					System.out.print("   ");
				}
				
				else if ((i == 2 && j == 2) || (i == 2 && j == 3) || (i == 2 && j == 4) ||
				(i == 3 && j == 2) || (i == 3 && j == 4) ||
				(i == 4 && j == 2) || (i == 4 && j == 3) || (i == 4 && j == 4)) {
					
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
