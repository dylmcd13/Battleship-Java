
@SuppressWarnings("unused")
public class Space {
	/** Coordinate for this Space */
  private Coordinate coordinate;
  
  /** boolean to check if ship is here or not */
  private boolean shipHere;
  
  /** peg to denote a hit or miss */
  private Pegs peg;
  
  /**
   * Constructor that sets coordinate
   * @param c Coordinate to set initially
   */
  public Space(Coordinate c) {
	  shipHere = false;
	  peg = null;
	  coordinate = c;
  }
  
  /**
   * Might use this in gui, to display the coordinate or something
   * @return Coordinate of this Space
   */
  public Coordinate getCoordinate() {
	  return coordinate;
  }

  /**
   * Check if a ship is at this Space
   * @return true if ship is here, false otherwise
   */
  public boolean isShipHere(){
    return shipHere;
  }
  /** 
   * Set shipHere to true to denote that a ship is at this location
   */
  public void setShipHere() {
  	shipHere = true;
  }
  
  
  /**
   * Place peg at this space
   * @param peg : Peg to place here
   */
  public void placePeg(Pegs peg) {
  	this.peg = peg;
  }
}