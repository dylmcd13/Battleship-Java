package model;

public class Destroyer {
  
  
  /** If ship is destroyed */
	private boolean destroyed = false;

  /** length of ship */
	private final int lengthOfShip = 2;
  
  /** Name of Ship */
	private final String shipName = "Destroyer";


  private Space[] placedOn = new Space[lengthOfShip];
  
  /** Must be length 2 */
  Destroyer(Space[] space){
    placedOn = space;
  }

  public Space[] getPlacedOn(){ return placedOn; }

  public int getLengthOfShip(){ return lengthOfShip; }

  public String getShipName(){ return shipName; }

  public boolean getDestroyed(){ return destroyed; }
}
