package Model;

public interface Ship {
	
  public String getShipName();
  public int getLengthOfShip();
	public Space getPlacedOn();
  public boolean getDestroyed();
}
