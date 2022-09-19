package Model;

public class Ship {
	
	private boolean isDestroyed;
	private int lengthOfShip; //length
	private String shipName;
	
	public Ship() {
		isDestroyed = false;
		lengthOfShip = 0;
		shipName = "";
	}
	
	public boolean getIsDestroyed() {
		return isDestroyed;
	}
}
