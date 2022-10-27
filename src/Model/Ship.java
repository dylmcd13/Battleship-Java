package Model;

public interface Ship {
	/** Returns name of ship */
  public String getShipName();

  /** Returns length of ship */
  public int getLengthOfShip();

  /** Returns array of spaces where the ship is placed */
	public Space[] getPlacedOn();

  /** Returns if ship is destroyed */ 
  public boolean getDestroyed();
}
