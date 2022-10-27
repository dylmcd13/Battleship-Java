package Model;

public class Carrier implements Ship{
  
  
  /** If ship is destroyed */
	private boolean destroyed = false;

  /** length of ship */
	private final int lengthOfShip = 5;
  
  /** Name of Ship */
	private final String shipName = "Carrier";


  public Space[] placedOn = new Space[lengthOfShip];

  Carrier(){
    
  }

  /** Must be length 5 */
  Carrier(Space[] space){
    placedOn = space;
  }

  public Space[] getPlacedOn(){
    return placedOn;
  }

  public String getShipName(){ return shipName; }

  public int getLengthOfShip(){ return lengthOfShip; }

  public boolean getDestroyed(){ return destroyed; }
}
