package Model;

public class Submarine implements Ship{
  private Space[] placedOn;
  
  /** If ship is destroyed */
	private boolean isDestroyed;

  /** length of ship */
	private final int lengthOfShip = 3;
  
  /** Name of Ship */
	private final String shipName = "Submarine";
  
  /** Must be length 3 */
  Submarine(Space[] c){
    placedOn = c;
  }

  public Space[] getPlacedOn(){
    return placedOn;
  }

  public int getLengthOfShip(){ return lengthOfShip; }
}
