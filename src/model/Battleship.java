package model;

public class Battleship {
  
  
  /** If ship is destroyed */
	private boolean destroyed;

  /** length of ship */
	private final int lengthOfShip = 4;
  
  /** Name of Ship */
	private final String shipName = "Battleship";

	/** Spaces where ship is placed */
  private Space[] placedOn = new Space[lengthOfShip];
  
  /** Health of Ship */
  private int hitPoints = lengthOfShip;
  
  /**
   * Default constructor sets destroyed to false
   */
  Battleship() {
  	destroyed = false;
  }
  
  /**
   * Creates Battleship at specified Space
   * @param space Array of Spaces where ship is placed (must be length 4)
   */
  Battleship(Space[] space){
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
  
  public void printPlacedAt() {
  	System.out.println("Printing Where Battleship is PLaced At!");
  	for(Space s: placedOn) {
  		Coordinate c = s.getCoordinate();
  		c.printCoordinate();
  		System.out.println("");
  	}
  }
}
