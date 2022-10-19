package Model;

public class Cruiser {
  private Space placedOn;
  
  /** If ship is destroyed */
	private boolean destroyed = false;

  /** length of ship */
	private final int lengthOfShip = 3;
  
  /** Name of Ship */
	private final String shipName = "Cruiser";
  
  /** Must be length 3 */
  Cruiser(Space space){
    placedOn = space;
  }

  public Space getPlacedOn(){ return placedOn; }

  public int getLengthOfShip(){ return lengthOfShip; }

  public String getShipName(){ return shipName; }

  public boolean getDestroyed(){ return destroyed; }
}
