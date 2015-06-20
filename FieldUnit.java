public class FieldUnit {
	
	byte x;
	byte y;
	boolean partOfPlayboard;				
	boolean hasTokenOnIt;					//Zeigt an ob ein Spielstein auf dem FieldUnit ist
	boolean willHideToken;
	
	FieldUnit(byte x, byte y, boolean partOfPlayboard, boolean hasTokenOnIt, boolean willHideToken) {
		
		this.partOfPlayboard = partOfPlayboard;
		this.hasTokenOnIt = hasTokenOnIt;
		this.willHideToken = willHideToken;
		
	}
	
}
