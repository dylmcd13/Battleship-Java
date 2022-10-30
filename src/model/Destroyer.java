

public class Destroyer {
  
  
  /** If ship is destroyed */
	private boolean destroyed;

  /** length of ship */
	private final int lengthOfShip = 2;
  
  /** Name of Ship */
	private final String shipName = "Destroyer";

	/** Spaces where ship is placed */
  private Space[] placedOn = new Space[lengthOfShip];
  
  /** Health of Ship */
  private int hitPoints = lengthOfShip;
  
  /**
   * Default constructor. Sets destroyed to false
   */
  Destroyer(){
  	destroyed = false;
  }
  
  /**
   * Creates Destroyer at specified Space
   * @param space Array of Spaces where ship is placed (must be length 2)
   */
  Destroyer(Space[] space){
    placedOn = space;
  }

  public Space[] getPlacedOn(){ return placedOn; }


  public int getLengthOfShip(){ return lengthOfShip; }


  public String getShipName(){ return shipName; }


  public boolean getDestroyed(){ return destroyed; }
  

  public void shotTaken() { 
  	hitPoints--; 
  }
  
  /**
   * Sets where ship is placed 
   * @param placedOn Array of Spaces where ship should be placed
   */
  public void setPlacedOn(Space[] placedOn) {
  	this.placedOn = placedOn;
  }
}
