package model;

public class Cruiser {
  
  
  /** If ship is destroyed */
	private boolean destroyed = false;

  /** length of ship */
	private final int lengthOfShip = 3;
  
  /** Name of Ship */
	private final String shipName = "Cruiser";

	/** Spaces where ship is placed */
  private Space[] placedOn = new Space[lengthOfShip];
  
  /** Health of Ship */
  private int hitPoints = lengthOfShip;
  
  Cruiser(){
    
  }

  /** Must be length 3 */
  Cruiser(Space[] space){
    placedOn = space;
  }

  public Space[] getPlacedOn(){ return placedOn; }

  public int getLengthOfShip(){ return lengthOfShip; }

  public String getShipName(){ return shipName; }

  public boolean getDestroyed(){ return destroyed; }
  
  /** For when a ship gets hit, it loses 1 hitPoint */
  public void shotTaken() { 
  	hitPoints--; 
  }
  
  /** Sets where ship is placed */
  public void setPlacedOn(Space[] placedOn) {
  	this.placedOn = placedOn;
  }
}
