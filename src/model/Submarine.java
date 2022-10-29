package model;

public class Submarine implements Ship{
  
  
  /** If ship is destroyed */
	private boolean destroyed;

  /** length of ship */
	private final int lengthOfShip = 3;
  
  /** Name of Ship */
	private final String shipName = "Submarine";

	/** Spaces where ship is placed */
  private Space[] placedOn = new Space[lengthOfShip];
  
  /** Health of Ship */
  private int hitPoints = lengthOfShip;
  
  /**
   * Default constructor.
   * Sets destroyed to false
   */
  Submarine(){
  	destroyed = false;
  }
  
  /** Must be length 3 */
  Submarine(Space[] space){
    placedOn = space;
  }

  
  public Space[] getPlacedOn(){
    return placedOn;
  }

 
  public int getLengthOfShip(){ return lengthOfShip; }

  public String getShipName(){ return shipName; }

  public boolean getDestroyed(){ return destroyed; }
  
  public int getHitPoints() { return hitPoints; }
  
  /** 
   * For when a ship gets hit, it loses 1 hitPoint
   */
  public void shotTaken() { 
  	hitPoints--; 
  }
  
  /** 
   * Sets where ship is placed 
   */
  public void setPlacedOn(Space[] placedOn) {
  	this.placedOn = placedOn;
  }
}
