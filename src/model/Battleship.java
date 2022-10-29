package model;

public class Battleship {
  
  
  /** If ship is destroyed */
	private boolean destroyed;

  /** length of ship */
	private final int lengthOfShip = 4;
  
  /** Name of Ship */
	private final String shipName = "Battleship";

	/** Spaces where ship is placed */
  private Space[] placedOn = new Space[lengthOfShip];
  
  /** Health of Ship */
  private int hitPoints = lengthOfShip;
  
  
  Battleship() {
  	destroyed = false;
  }
  
  /** Must be length 4 */
  Battleship(Space[] space){
    placedOn = space;
  }

  /** @return Spaces where ship is placed */
  public Space[] getPlacedOn(){ return placedOn; }

  /** @return length of ship (4) */
  public int getLengthOfShip(){ return lengthOfShip; }

  /** @Returns ship name */
  public String getShipName(){ return shipName; }

  /** Return if ship is destroyed */
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
