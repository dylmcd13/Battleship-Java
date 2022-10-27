package Model;

public class Battleship {
  
  
  /** If ship is destroyed */
	private boolean destroyed = false;

  /** length of ship */
	private final int lengthOfShip = 4;
  
  /** Name of Ship */
	private final String shipName = "Battleship";


  private Space[] placedOn = new Space[lengthOfShip];
  
  /** Must be length 4 */
  Battleship(Space[] space){
    placedOn = space;
  }

  public Space[] getPlacedOn(){ return placedOn; }

  public int getLengthOfShip(){ return lengthOfShip; }

  public String getShipName(){ return shipName; }

  public boolean getDestroyed(){ return destroyed; }
}
