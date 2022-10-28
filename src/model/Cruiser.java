package model;

public class Cruiser {
  
  
  /** If ship is destroyed */
	private boolean destroyed = false;

  /** length of ship */
	private final int lengthOfShip = 3;
  
  /** Name of Ship */
	private final String shipName = "Cruiser";


  private Space[] placedOn = new Space[lengthOfShip];
  
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
}
