

public class Cruiser {
  
  
  /** If ship is destroyed */
	private boolean destroyed;

  /** length of ship */
	private final int lengthOfShip = 3;
  
  /** Name of Ship */
	private final String shipName = "Cruiser";

	/** Spaces where ship is placed */
  private Space[] placedOn = new Space[lengthOfShip];
  
  /** Health of Ship */
  private int hitPoints = lengthOfShip;
  
  Cruiser(){
    destroyed = false;
  }

  /**
   * Creates Cruiser at specified Space
   * @param space Array of Spaces where ship is placed (must be length 3)
   */
  Cruiser(Space[] space){
    placedOn = space;
  }

  public Space[] getPlacedOn(){ return placedOn; }

  public int getLengthOfShip(){ return lengthOfShip; }

  public String getShipName(){ return shipName; }

  public boolean getDestroyed(){ return destroyed; }
  
  public void shotTaken() { 
  	hitPoints--; 
  }
  
  public void setPlacedOn(Space[] placedOn) {
  	this.placedOn = placedOn;
  }
}
