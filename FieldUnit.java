public class FieldUnit {
	
	public int x;
	public int y;
	public String token;
	public boolean willHideToken;
	
	FieldUnit(int x, int y, String token, boolean willHideToken) {
		this.x = x;
		this.y = y;
		this.token = token;
		this.willHideToken = willHideToken;
	}
	
	public String toString () {
		return token;
	}
}
