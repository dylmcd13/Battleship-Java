package model;

public class Player {
  
  public static Carrier carrierShip = new Carrier();

  Battleship battleShip;

  Cruiser cruiserShip = new Cruiser();

  Submarine submarineShip;

  Destroyer destroyerShip;

  Board hitAndMissBoard = new HitAndMissBoard();
  Board shipBoard = new ShipBoard();

  /** True or false depending on if it's player turn */
  private boolean playerTurn;

  /** Coordinate where the players shot goes */
  private Coordinate shotLocation;



  /** Default Constructor for Player */
  public Player(){
    playerTurn = false;
    Coordinate c = new Coordinate(0, 0);
    shotLocation = c;
  }

  /**
   * @return Players turn
   */
  public boolean getPlayerTurn() {
    return playerTurn;
  }

  /**
   * @return Coordinate object of where the shot went
   */
  public Coordinate getShotLocation() {
    return shotLocation;
  }

  /**
   * Toggles the Players between true or false.
   */
  public void togglePlayerTurn() {
    if(playerTurn)
      playerTurn = false;
    else
      playerTurn = true;
  }

  /**
   * Sets the location of the shot
   * Might change params to just x and y like placeCarrier()
   * @param c New coordinate of shot
   */
  public void setShotLocation(Coordinate c) {
    shotLocation = c;
  }

  /** 
   * Places FRONT of carrier at this coordinate
   * Places carrier horizontally for now
   * Change to Space[] later on (maybe) and check if out of bounds or overlapping other ship
  */
  public void placeCarrier(int x, int y){
    
    Space[] placedOn = carrierShip.getPlacedOn();
    System.out.println(placedOn.length);
    placedOn[0] = shipBoard.getSpace(x, y);
    placedOn[1] = shipBoard.getSpace(x, y+1);
    placedOn[2] = shipBoard.getSpace(x, y+2);
    placedOn[3] = shipBoard.getSpace(x, y+3);
    placedOn[4] = shipBoard.getSpace(x, y+4);
    placedOn[5] = shipBoard.getSpace(x, y+5);
    carrierShip = new Carrier(placedOn);
  }

  // public void placeBattleship(int x, int y){

  // }

  // public void placeBattleship(int x, int y){

  // }

  // public void placeBattleship(int x, int y){

  // }

}
