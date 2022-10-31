
import java.util.Scanner;
public class Player {
  
  Carrier carrierShip = new Carrier();

  Battleship battleShip = new Battleship();

  Cruiser cruiserShip = new Cruiser();

  Submarine submarineShip = new Submarine();

  Destroyer destroyerShip = new Destroyer();

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
  public void placeCarrier(int x1, int y1, int x2, int y2, boolean horizontal){
  	Space[] placeAt = new Space[carrierShip.getLengthOfShip()];
  	Scanner sc = new Scanner(System.in);
    
    if(horizontal == true) {
	    placeAt[0] = shipBoard.getSpace(x1, y1);
	    placeAt[1] = shipBoard.getSpace(x1+1, y1);
	    placeAt[2] = shipBoard.getSpace(x1+2, y1);
	    placeAt[3] = shipBoard.getSpace(x1+3, y1);
	    placeAt[4] = shipBoard.getSpace(x2, y2);
	    
	    int lengthMinusOne = carrierShip.getLengthOfShip()-1;
	    
	    while(x2 - x1 != lengthMinusOne || y1 != y2 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || shipBoard.checkOverlap(placeAt) == true) { //while ship is not on same horizontal line or wrong length???
	    	System.out.println("Error: Ship overlap or out of bounds. Enter coordinates again.");
	    	Coordinate carrierShipCoordinatesFront = getCoordinates("1",sc);
	    	Coordinate battleshipCoordinatesBack = getCoordinates("2",sc);
	    	
	    	
	    	x1 = carrierShipCoordinatesFront.getX();
	    	y1 = carrierShipCoordinatesFront.getY();
	    	
	    	x2 = battleshipCoordinatesBack.getX();
	    	y2 = battleshipCoordinatesBack.getY();
	    	placeAt[0] = shipBoard.getSpace(carrierShipCoordinatesFront.getX(), carrierShipCoordinatesFront.getY());
	    	placeAt[1] = shipBoard.getSpace(x1+1, y1);
		    placeAt[2] = shipBoard.getSpace(x1+2, y1);
		    placeAt[3] = shipBoard.getSpace(x1+3, y1);
	      placeAt[4] = shipBoard.getSpace(battleshipCoordinatesBack.getX(), battleshipCoordinatesBack.getY());
	    }
	    placeAt[1] = shipBoard.getSpace(x1+1, y1);
	    placeAt[2] = shipBoard.getSpace(x1+2, y1);
    }else {
    	placeAt[0] = shipBoard.getSpace(x1, y1);
    	placeAt[1] = shipBoard.getSpace(x1, y1+1);
	    placeAt[2] = shipBoard.getSpace(x1, y1+2);
	    placeAt[3] = shipBoard.getSpace(x2, y2);
	    //while(x2 - x1 != lengthMinusOne || y1 != y2 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || shipBoard.checkOverlap(placeAt) == true)
	    while(y2 - y1 != carrierShip.getLengthOfShip()-1 || x1 != x2 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || shipBoard.checkOverlap(placeAt)) { //while ship is not on same horizontal line or wrong length???
	    	System.out.println("Needs to be "+carrierShip.getLengthOfShip()+" Spaces apart.");
	    	Coordinate carrierShipCoordinatesFront = getCoordinates("1",sc);
	    	Coordinate battleshipCoordinatesBack = getCoordinates("2",sc);
	    	x1 = carrierShipCoordinatesFront.getX();
	    	y1 = carrierShipCoordinatesFront.getY();
	    	
	    	x2 = battleshipCoordinatesBack.getX();
	    	y2 = battleshipCoordinatesBack.getY();
	    	placeAt[0] = shipBoard.getSpace(carrierShipCoordinatesFront.getX(), carrierShipCoordinatesFront.getY());
	    	placeAt[1] = shipBoard.getSpace(x1, y1+1);
		    placeAt[2] = shipBoard.getSpace(x1, y1+2);
	      placeAt[3] = shipBoard.getSpace(battleshipCoordinatesBack.getX(), battleshipCoordinatesBack.getY());
	    }
	    placeAt[1] = shipBoard.getSpace(x1, y1+1);
	    placeAt[2] = shipBoard.getSpace(x1, y1+2);
    }
    placeAt[0].setShipHere();
    placeAt[1].setShipHere();
    placeAt[2].setShipHere();
    placeAt[3].setShipHere();
    placeAt[4].setShipHere();
    carrierShip.setPlacedOn(placeAt);
  }
  
  public boolean isInBounds(Ship ship) {
  	Space[] placedOn = ship.getPlacedOn();
  	for(Space s : placedOn) {
  		//Check if space out of bounds
  	}
  	return true;
  }

  public void placeBattleship(int x1, int y1, int x2, int y2, boolean horizontal){
  	Space[] placeAt = new Space[battleShip.getLengthOfShip()];
  	Scanner sc = new Scanner(System.in);
    
    if(horizontal == true) {
	    placeAt[0] = shipBoard.getSpace(x1, y1);
	    placeAt[1] = shipBoard.getSpace(x1+1, y1);
	    placeAt[2] = shipBoard.getSpace(x1+2, y1);
	    placeAt[3] = shipBoard.getSpace(x2, y2);
	    
	    int lengthMinusOne = battleShip.getLengthOfShip()-1;
	    
	    while(x2 - x1 != lengthMinusOne || y1 != y2 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || shipBoard.checkOverlap(placeAt) == true) { //while ship is not on same horizontal line or wrong length???
	    	System.out.println("Error: Ship overlap or out of bounds. Enter coordinates again.");
	    	Coordinate battleshipCoordinatesFront = getCoordinates("1",sc);
	    	Coordinate carrierShipCoordinatesBack = getCoordinates("2",sc);
	    	
	    	
	    	x1 = battleshipCoordinatesFront.getX();
	    	y1 = battleshipCoordinatesFront.getY();
	    	
	    	x2 = carrierShipCoordinatesBack.getX();
	    	y2 = carrierShipCoordinatesBack.getY();
	    	placeAt[0] = shipBoard.getSpace(battleshipCoordinatesFront.getX(), battleshipCoordinatesFront.getY());
	    	placeAt[1] = shipBoard.getSpace(x1+1, y1);
		    placeAt[2] = shipBoard.getSpace(x1+2, y1);
	      placeAt[3] = shipBoard.getSpace(carrierShipCoordinatesBack.getX(), carrierShipCoordinatesBack.getY());
	    }
	    placeAt[1] = shipBoard.getSpace(x1+1, y1);
	    placeAt[2] = shipBoard.getSpace(x1+2, y1);
    }else {
    	placeAt[0] = shipBoard.getSpace(x1, y1);
    	placeAt[1] = shipBoard.getSpace(x1, y1+1);
	    placeAt[2] = shipBoard.getSpace(x1, y1+2);
	    placeAt[3] = shipBoard.getSpace(x2, y2);
	    //while(x2 - x1 != lengthMinusOne || y1 != y2 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || shipBoard.checkOverlap(placeAt) == true)
	    while(y2 - y1 != battleShip.getLengthOfShip()-1 || x1 != x2 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || shipBoard.checkOverlap(placeAt)) { //while ship is not on same horizontal line or wrong length???
	    	System.out.println("Needs to be "+battleShip.getLengthOfShip()+" Spaces apart.");
	    	Coordinate battleshipCoordinatesFront = getCoordinates("1",sc);
	    	Coordinate carrierShipCoordinatesBack = getCoordinates("2",sc);
	    	x1 = battleshipCoordinatesFront.getX();
	    	y1 = battleshipCoordinatesFront.getY();
	    	
	    	x2 = carrierShipCoordinatesBack.getX();
	    	y2 = carrierShipCoordinatesBack.getY();
	    	placeAt[0] = shipBoard.getSpace(battleshipCoordinatesFront.getX(), battleshipCoordinatesFront.getY());
	    	placeAt[1] = shipBoard.getSpace(x1, y1+1);
		    placeAt[2] = shipBoard.getSpace(x1, y1+2);
	      placeAt[3] = shipBoard.getSpace(carrierShipCoordinatesBack.getX(), carrierShipCoordinatesBack.getY());
	    }
	    placeAt[1] = shipBoard.getSpace(x1, y1+1);
	    placeAt[2] = shipBoard.getSpace(x1, y1+2);
    }
    placeAt[0].setShipHere();
    placeAt[1].setShipHere();
    placeAt[2].setShipHere();
    placeAt[3].setShipHere();
    battleShip.setPlacedOn(placeAt);
  	
  }

  public void placeCruiser(int x1, int y1, int x2, int y2, boolean horizontal){
  	Space[] placeAt = new Space[cruiserShip.getLengthOfShip()];
  	Scanner sc = new Scanner(System.in);
    
    if(horizontal == true) {
	    placeAt[0] = shipBoard.getSpace(x1, y1);
	    placeAt[1] = shipBoard.getSpace(x1+1, y1);
	    placeAt[2] = shipBoard.getSpace(x2, y2);
	    
	    int lengthMinusOne = cruiserShip.getLengthOfShip()-1;
	    
	    while(x2 - x1 != lengthMinusOne || y1 != y2 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || shipBoard.checkOverlap(placeAt) == true) { //while ship is not on same horizontal line or wrong length???
	    	System.out.println("EError: Ship overlap or out of bounds. Enter coordinates again.");
	    	Coordinate cruiserShipCoordinatesFront = getCoordinates("1",sc);
	    	Coordinate cruiserShipCoordinatesBack = getCoordinates("2",sc);
	    	
	    	
	    	x1 = cruiserShipCoordinatesFront.getX();
	    	y1 = cruiserShipCoordinatesFront.getY();
	    	
	    	x2 = cruiserShipCoordinatesBack.getX();
	    	y2 = cruiserShipCoordinatesBack.getY();
	    	placeAt[0] = shipBoard.getSpace(cruiserShipCoordinatesFront.getX(), cruiserShipCoordinatesFront.getY());
	    	placeAt[1] = shipBoard.getSpace(x1+1, y1);
	      placeAt[2] = shipBoard.getSpace(cruiserShipCoordinatesBack.getX(), cruiserShipCoordinatesBack.getY());
	    }
	    placeAt[1] = shipBoard.getSpace(x1+1, y1);
	    
    }else {
    	placeAt[0] = shipBoard.getSpace(x1, y1);
    	placeAt[1] = shipBoard.getSpace(x1, y1+1);
    	placeAt[2] = shipBoard.getSpace(x2, y2);
	    //while(x2 - x1 != lengthMinusOne || y1 != y2 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || shipBoard.checkOverlap(placeAt) == true)
	    while(y2 - y1 != cruiserShip.getLengthOfShip()-1 || x1 != x2 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || shipBoard.checkOverlap(placeAt)) { //while ship is not on same horizontal line or wrong length???
	    	System.out.println("Needs to be "+cruiserShip.getLengthOfShip()+" Spaces apart.");
	    	Coordinate cruiserShipCoordinatesFront = getCoordinates("1",sc);
	    	Coordinate cruiserShipCoordinatesBack = getCoordinates("2",sc);
	    	x1 = cruiserShipCoordinatesFront.getX();
	    	y1 = cruiserShipCoordinatesFront.getY();
	    	
	    	x2 = cruiserShipCoordinatesBack.getX();
	    	y2 = cruiserShipCoordinatesBack.getY();
	    	placeAt[0] = shipBoard.getSpace(cruiserShipCoordinatesFront.getX(), cruiserShipCoordinatesFront.getY());
	    	placeAt[1] = shipBoard.getSpace(x1, y1+1);
	    	placeAt[2] = shipBoard.getSpace(cruiserShipCoordinatesBack.getX(), cruiserShipCoordinatesBack.getY());
	      
	    }
	    placeAt[1] = shipBoard.getSpace(x1, y1+1);
    }
    placeAt[0].setShipHere();
    placeAt[1].setShipHere();
    placeAt[2].setShipHere();
    cruiserShip.setPlacedOn(placeAt);
  }

  public void placeSubmarine(int x1, int y1, int x2, int y2, boolean horizontal){
  	Space[] placeAt = new Space[submarineShip.getLengthOfShip()];
  	Scanner sc = new Scanner(System.in);
    
    if(horizontal == true) {
	    placeAt[0] = shipBoard.getSpace(x1, y1);
	    placeAt[1] = shipBoard.getSpace(x1+1, y1);
	    placeAt[2] = shipBoard.getSpace(x2, y2);
	    
	    int lengthMinusOne = submarineShip.getLengthOfShip()-1;
	    
	    while(x2 - x1 != lengthMinusOne || y1 != y2 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || shipBoard.checkOverlap(placeAt) == true) { //while ship is not on same horizontal line or wrong length???
	    	System.out.println("Error: Ship overlap or out of bounds. Enter coordinates again.");
	    	Coordinate submarineShipCoordinatesFront = getCoordinates("1",sc);
	    	Coordinate submarineShipCoordinatesBack = getCoordinates("2",sc);
	    	
	    	
	    	x1 = submarineShipCoordinatesFront.getX();
	    	y1 = submarineShipCoordinatesFront.getY();
	    	
	    	x2 = submarineShipCoordinatesBack.getX();
	    	y2 = submarineShipCoordinatesBack.getY();
	    	placeAt[0] = shipBoard.getSpace(submarineShipCoordinatesFront.getX(), submarineShipCoordinatesFront.getY());
	    	placeAt[1] = shipBoard.getSpace(x1+1, y1);
	      placeAt[2] = shipBoard.getSpace(submarineShipCoordinatesBack.getX(), submarineShipCoordinatesBack.getY());
	    }
	    placeAt[1] = shipBoard.getSpace(x1+1, y1);
    }else {
    	placeAt[0] = shipBoard.getSpace(x1, y1);
    	placeAt[1] = shipBoard.getSpace(x1, y1+1);
	    placeAt[2] = shipBoard.getSpace(x2, y2);
	    //while(x2 - x1 != lengthMinusOne || y1 != y2 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || shipBoard.checkOverlap(placeAt) == true)
	    while(y2 - y1 != submarineShip.getLengthOfShip()-1 || x1 != x2 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || shipBoard.checkOverlap(placeAt)) { //while ship is not on same horizontal line or wrong length???
	    	System.out.println("EError: Ship overlap or out of bounds. Enter coordinates again.");
	    	Coordinate submarineShipCoordinatesFront = getCoordinates("1",sc);
	    	Coordinate submarineShipCoordinatesBack = getCoordinates("2",sc);
	    	x1 = submarineShipCoordinatesFront.getX();
	    	y1 = submarineShipCoordinatesFront.getY();
	    	
	    	x2 = submarineShipCoordinatesBack.getX();
	    	y2 = submarineShipCoordinatesBack.getY();
	    	placeAt[0] = shipBoard.getSpace(submarineShipCoordinatesFront.getX(), submarineShipCoordinatesFront.getY());
	    	placeAt[1] = shipBoard.getSpace(x1, y1+1);
	      placeAt[2] = shipBoard.getSpace(submarineShipCoordinatesBack.getX(), submarineShipCoordinatesBack.getY());
	    }
	    placeAt[1] = shipBoard.getSpace(x1, y1+1);
	    
    }
    placeAt[0].setShipHere();
    placeAt[1].setShipHere();
    placeAt[2].setShipHere();
    submarineShip.setPlacedOn(placeAt);
  }
  
  public void placeDestroyer(int x1, int y1, int x2, int y2, boolean horizontal){
  	Space[] placeAt = new Space[destroyerShip.getLengthOfShip()];
  	Scanner sc = new Scanner(System.in);
    
    if(horizontal == true) {
	    placeAt[0] = shipBoard.getSpace(x1, y1);
	    placeAt[1] = shipBoard.getSpace(x2, y2);
	    
	    
	    int lengthMinusOne = destroyerShip.getLengthOfShip()-1;
	    
	    while(x2 - x1 != lengthMinusOne || y1 != y2 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || shipBoard.checkOverlap(placeAt) == true) { //while ship is not on same horizontal line or wrong length???
	    	System.out.println("Error: Ship overlap or out of bounds. Enter coordinates again.");
	    	Coordinate destroyerShipCoordinatesFront = getCoordinates("1",sc);
	    	Coordinate destroyerShipCoordinatesBack = getCoordinates("2",sc);
	    	
	    	
	    	x1 = destroyerShipCoordinatesFront.getX();
	    	y1 = destroyerShipCoordinatesFront.getY();
	    	
	    	x2 = destroyerShipCoordinatesBack.getX();
	    	y2 = destroyerShipCoordinatesBack.getY();
	    	placeAt[0] = shipBoard.getSpace(destroyerShipCoordinatesFront.getX(), destroyerShipCoordinatesFront.getY());
	    	placeAt[1] = shipBoard.getSpace(destroyerShipCoordinatesBack.getX(), destroyerShipCoordinatesBack.getY());
	      
	    }
    }else {
    	placeAt[0] = shipBoard.getSpace(x1, y1);
	    placeAt[1] = shipBoard.getSpace(x2, y2);
	    //while(x2 - x1 != lengthMinusOne || y1 != y2 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || shipBoard.checkOverlap(placeAt) == true)
	    while(y2 - y1 != destroyerShip.getLengthOfShip()-1 || x1 != x2 || y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9 || x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || shipBoard.checkOverlap(placeAt)) { //while ship is not on same horizontal line or wrong length???
	    	System.out.println("Error: Ship overlap or out of bounds. Enter coordinates again.");
	    	Coordinate destroyerShipCoordinatesFront = getCoordinates("1",sc);
	    	Coordinate destroyerShipCoordinatesBack = getCoordinates("2",sc);
	    	x1 = destroyerShipCoordinatesFront.getX();
	    	y1 = destroyerShipCoordinatesFront.getY();
	    	
	    	x2 = destroyerShipCoordinatesBack.getX();
	    	y2 = destroyerShipCoordinatesBack.getY();
	    	placeAt[0] = shipBoard.getSpace(destroyerShipCoordinatesFront.getX(), destroyerShipCoordinatesFront.getY());
	      placeAt[1] = shipBoard.getSpace(destroyerShipCoordinatesBack.getX(), destroyerShipCoordinatesBack.getY());
	    }
	    
	    
    }
    placeAt[0].setShipHere();
    placeAt[1].setShipHere();
    destroyerShip.setPlacedOn(placeAt);
	}
  
  
  public void placeShips() {
  	Scanner sc = new Scanner(System.in);
  	shipBoard.displayBoardPlaceShips();
  	boolean horizontal = checkHorizontal();
  	System.out.println("Where to place Carrier?");
  	Coordinate carrierCoordinatesFront = getCoordinates("1",sc);
  	Coordinate carrierCoordinatesBack = getCoordinates("2",sc);
  	placeCarrier(carrierCoordinatesFront.getX(),carrierCoordinatesFront.getY(),carrierCoordinatesBack.getX(),carrierCoordinatesBack.getY(),horizontal);
  	shipBoard.displayBoardPlaceShips();

  	horizontal = checkHorizontal();
  	System.out.println("Where to place Battleship?");
  	Coordinate battleshipCoordinatesFront = getCoordinates("1",sc);
  	Coordinate battleshipCoordinatesBack = getCoordinates("2",sc);
  	placeBattleship(battleshipCoordinatesFront.getX(),battleshipCoordinatesFront.getY(),battleshipCoordinatesBack.getX(),battleshipCoordinatesBack.getY(),horizontal);
  	shipBoard.displayBoardPlaceShips();

  	horizontal = checkHorizontal();
  	System.out.println("Where to place Cruiser?");
  	Coordinate cruiserCoordinatesFront = getCoordinates("1",sc);
  	Coordinate cruiserCoordinatesBack = getCoordinates("2",sc);
  	placeCruiser(cruiserCoordinatesFront.getX(),cruiserCoordinatesFront.getY(),cruiserCoordinatesBack.getX(),cruiserCoordinatesBack.getY(),horizontal);
  	shipBoard.displayBoardPlaceShips();
  	
  	horizontal = checkHorizontal();
  	System.out.println("Where to place Submarine?");
  	Coordinate submarineCoordinatesFront = getCoordinates("1",sc);
  	Coordinate submarineCoordinatesBack = getCoordinates("2",sc);
  	placeSubmarine(submarineCoordinatesFront.getX(),submarineCoordinatesFront.getY(),submarineCoordinatesBack.getX(),submarineCoordinatesBack.getY(),horizontal);
  	shipBoard.displayBoardPlaceShips();
  	
  	horizontal = checkHorizontal();
  	System.out.println("Where to place Destroyer?");
  	Coordinate destroyerCoordinatesFront = getCoordinates("1",sc);
  	Coordinate destroyerCoordinatesBack = getCoordinates("2",sc);
  	placeDestroyer(destroyerCoordinatesFront.getX(),destroyerCoordinatesFront.getY(),destroyerCoordinatesBack.getX(),destroyerCoordinatesBack.getY(),horizontal);
    shipBoard.displayBoardPlaceShips();
  }
  
  public Coordinate getCoordinates(String s,Scanner sc) {
  	System.out.print("x"+s+"-coordinate: ");
  	int x = sc.nextInt();
  	System.out.print("y"+s+"-coordinate: ");
  	int y = sc.nextInt();
    System.out.println();
  	return new Coordinate(x,y);
  }
  
  public boolean checkHorizontal() {
  	Scanner sc = new Scanner(System.in);
  	System.out.println("Do you want ship to be horizontal or vertical?\nEnter 'h' or 'v'.");
  	String s = sc.nextLine();
  	if(s.equalsIgnoreCase("horizontal") || s.equalsIgnoreCase("h"))
  		return true;
  	else
  		return false;
  }

}