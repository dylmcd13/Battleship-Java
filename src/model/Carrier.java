

public class Carrier implements Ship{
  
  
  /** If ship is destroyed */
	private boolean destroyed;

  /** length of ship */
	private final int lengthOfShip = 5;
  
  /** Name of Ship */
	private final String shipName = "Carrier";

	/** Spaces where ship is placed */
  private Space[] placedOn = new Space[lengthOfShip];
  
  /** Health of Ship */
  private int hitPoints = lengthOfShip;
  
  /**
   * Default constructor sets destroyed to false
   */
  Carrier(){
    destroyed = false;
  }

  /**
   * Creates Destroyer at specified Space
   * @param space Array of Spaces where ship is placed (must be length 5)
   */
  Carrier(Space[] space){
    placedOn = space;
  }

  
  public Space[] getPlacedOn(){ return placedOn; }

  public String getShipName(){ return shipName; }

  public int getLengthOfShip(){ return lengthOfShip; }

  public boolean getDestroyed(){ return destroyed; }
  
  public int getHitPoints() { return hitPoints; }
  
  public void shotTaken() {
  	hitPoints--;
  }
  
  public void setPlacedOn(Space[] placedOn) {
  	this.placedOn = placedOn;
  }
  
  public void printPlacedAt() {
  	System.out.println("Printing Where Carrier is Placed At!");
  	for(Space s: placedOn) {
  		Coordinate c = s.getCoordinate();
  		c.printCoordinate();
  		System.out.println("");
  	}
  }
}
