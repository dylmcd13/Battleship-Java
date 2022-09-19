package Model;

public class Ship {
	
  /** If ship is destroyed */
	private boolean isDestroyed;

  /** length of ship */
	private int lengthOfShip;
  
  /** Name of Ship */
	private String shipName;
	
  /** Default Constructor for Ship Class */
	public Ship() {
		isDestroyed = false;
		lengthOfShip = 0;
		shipName = "";
	}
	
  /**
   * @return True or False if ship is destroyed
   */
	public boolean getIsDestroyed() {
		return isDestroyed;
	}

  /**
   * @return The length of ship
   */
  public int getLengthOfShip() {
    return lengthOfShip;
  }

  /**
   * @return Name of ship
   */
  public String getShipName() {
    return shipName;
  }  

  /**
   * Set isDestroyed to true or false
   * @param isDestroyed : If ship is destroyed
   */
  public void setIsDestroyed(boolean isDestroyed){
    this.isDestroyed = isDestroyed;
  }

  /**
   * Set length of ship
   * @param lengthOfShip : length of ship
   */
  public void setLengthOfShip(int lengthOfShip) {
    this.lengthOfShip = lengthOfShip;
  }


  public void setNameOfShip(String shipName) {
    this.shipName = shipName;
  }
}
