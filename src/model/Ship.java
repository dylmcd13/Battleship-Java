package model;

public interface Ship {
	/** Returns name of ship */
  public String getShipName();

  /** Returns length of ship */
  public int getLengthOfShip();

  /** 
   * @returns Array of Spaces where the ship is placed 
   */
	public Space[] getPlacedOn();

  /** 
   * @returns true or false depending if ship is destroyed 
   */ 
  public boolean getDestroyed();
  
  /**
   * Sets where ship is placed 
   * @param placedOn Array of Spaces where ship should be placed
   */
  public void setPlacedOn(Space[] placedOn);
  
  /** 
   * For when a ship gets hit, it loses 1 hitPoint 
   */
  public void shotTaken();
  
  /**
   * @return amount of HP ship has
   */
  public int getHitPoints();
  
 
}
