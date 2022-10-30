package model;
import java.util.Scanner;
public class Player {
  
  Carrier carrierShip = new Carrier();

  Battleship battleShip = new Battleship();

  Cruiser cruiserShip = new Cruiser();

  Submarine submarineShip = new Submarine();

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
  public void placeCarrier(int x1, int y1, int x2, int y2, boolean horizontal){
    Space[] placeAt = new Space[carrierShip.getLengthOfShip()];
    Scanner sc = new Scanner(System.in);
    
    if(horizontal == true) {
	    placeAt[0] = shipBoard.getSpace(x1, y1);
	    placeAt[4] = shipBoard.getSpace(x2, y2);
	    
	    int lengthMinusOne = carrierShip.getLengthOfShip()-1;

	    while(x2 - x1 != lengthMinusOne || y1 != y2) { //while ship is not on same horizontal line or wrong length???
	    	System.out.println("Needs to be "+carrierShip.getLengthOfShip()+" Spaces apart.");
	    	Coordinate carrierCoordinatesFront = getCoordinates("1",sc);
	    	Coordinate carrierCoordinatesBack = getCoordinates("2",sc);
	    	
	    	
	    	x1 = carrierCoordinatesFront.getX();
	    	y1 = carrierCoordinatesFront.getY();
	    	
	    	x2 = carrierCoordinatesBack.getX();
	    	y2 = carrierCoordinatesBack.getY();
	    	placeAt[0] = shipBoard.getSpace(carrierCoordinatesFront.getX(), carrierCoordinatesFront.getY());
	      placeAt[4] = shipBoard.getSpace(carrierCoordinatesBack.getX(), carrierCoordinatesBack.getY());
	    }
	    placeAt[1] = shipBoard.getSpace(x1+1, y1);
	    placeAt[2] = shipBoard.getSpace(x1+2, y1);
	    placeAt[3] = shipBoard.getSpace(x1+3, y1);
    }else {
    	placeAt[0] = shipBoard.getSpace(x1, y1);
	    placeAt[4] = shipBoard.getSpace(x2, y2);
	    while(y2 - y1 != carrierShip.getLengthOfShip()-1 || x1 != x2) { //while ship is not on same horizontal line or wrong length???
	    	System.out.println("Needs to be "+carrierShip.getLengthOfShip()+" Spaces apart.");
	    	Coordinate carrierCoordinatesFront = getCoordinates("1",sc);
	    	Coordinate carrierCoordinatesBack = getCoordinates("2",sc);
	    	x1 = carrierCoordinatesFront.getX();
	    	y1 = carrierCoordinatesFront.getY();
	    	
	    	x2 = carrierCoordinatesBack.getX();
	    	y2 = carrierCoordinatesBack.getY();
	    	placeAt[0] = shipBoard.getSpace(carrierCoordinatesFront.getX(), carrierCoordinatesFront.getY());
	      placeAt[4] = shipBoard.getSpace(carrierCoordinatesBack.getX(), carrierCoordinatesBack.getY());
	    }
	    placeAt[1] = shipBoard.getSpace(x1, y1+1);
	    placeAt[2] = shipBoard.getSpace(x1, y1+2);
	    placeAt[3] = shipBoard.getSpace(x1, y1+3);
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
	    	Coordinate battleshipCoordinatesBack = getCoordinates("2",sc);
	    	
	    	
	    	x1 = battleshipCoordinatesFront.getX();
	    	y1 = battleshipCoordinatesFront.getY();
	    	
	    	x2 = battleshipCoordinatesBack.getX();
	    	y2 = battleshipCoordinatesBack.getY();
	    	placeAt[0] = shipBoard.getSpace(battleshipCoordinatesFront.getX(), battleshipCoordinatesFront.getY());
	    	placeAt[1] = shipBoard.getSpace(x1+1, y1);
		    placeAt[2] = shipBoard.getSpace(x1+2, y1);
	      placeAt[3] = shipBoard.getSpace(battleshipCoordinatesBack.getX(), battleshipCoordinatesBack.getY());
	    }
	    placeAt[1] = shipBoard.getSpace(x1+1, y1);
	    placeAt[2] = shipBoard.getSpace(x1+2, y1);
    }else {
    	placeAt[0] = shipBoard.getSpace(x1, y1);
	    placeAt[3] = shipBoard.getSpace(x2, y2);
	    while(y2 - y1 != battleShip.getLengthOfShip()-1 || x1 != x2) { //while ship is not on same horizontal line or wrong length???
	    	System.out.println("Needs to be "+battleShip.getLengthOfShip()+" Spaces apart.");
	    	Coordinate battleshipCoordinatesFront = getCoordinates("1",sc);
	    	Coordinate battleshipCoordinatesBack = getCoordinates("2",sc);
	    	x1 = battleshipCoordinatesFront.getX();
	    	y1 = battleshipCoordinatesFront.getY();
	    	
	    	x2 = battleshipCoordinatesBack.getX();
	    	y2 = battleshipCoordinatesBack.getY();
	    	placeAt[0] = shipBoard.getSpace(battleshipCoordinatesFront.getX(), battleshipCoordinatesFront.getY());
	      placeAt[3] = shipBoard.getSpace(battleshipCoordinatesBack.getX(), battleshipCoordinatesBack.getY());
	    }
	    placeAt[1] = shipBoard.getSpace(x1, y1+1);
	    placeAt[2] = shipBoard.getSpace(x1, y1+2);
    }
    placeAt[0].setShipHere();
    placeAt[1].setShipHere();
    placeAt[2].setShipHere();
    placeAt[3].setShipHere();
    battleShip.setPlacedOn(placeAt);
  	
  	
  	/*
  	placeAt[0] = shipBoard.getSpace(x, y);
  	placeAt[0].setShipHere();
  	placeAt[1] = shipBoard.getSpace(x, y+1);
  	placeAt[1].setShipHere();
  	placeAt[2] = shipBoard.getSpace(x, y+2);
  	placeAt[2].setShipHere();
  	placeAt[3] = shipBoard.getSpace(x, y+3);
  	placeAt[3].setShipHere();
    battleShip.setPlacedOn(placeAt);
    */
  }

  public void placeCruiser(int x, int y){
  	Space[] placeAt = new Space[cruiserShip.getLengthOfShip()];
  	placeAt[0] = shipBoard.getSpace(x, y);
  	placeAt[1] = shipBoard.getSpace(x, y+1);
  	placeAt[2] = shipBoard.getSpace(x, y+2);
  	placeAt[3] = shipBoard.getSpace(x, y+3);
  	placeAt[4] = shipBoard.getSpace(x, y+4);
    placeAt[5] = shipBoard.getSpace(x, y+5);
    placeAt[0].setShipHere();
    placeAt[1].setShipHere();
    placeAt[2].setShipHere();
    placeAt[3].setShipHere();
    placeAt[4].setShipHere();
    placeAt[5].setShipHere();
    cruiserShip.setPlacedOn(placeAt);
  }

  public void placeSubmarine(int x, int y){
  	Space[] placeAt = new Space[submarineShip.getLengthOfShip()];
  	placeAt[0] = shipBoard.getSpace(x, y);
  	placeAt[1] = shipBoard.getSpace(x, y+1);
  	placeAt[2] = shipBoard.getSpace(x, y+2);
  	placeAt[0].setShipHere();
    placeAt[1].setShipHere();
    placeAt[2].setShipHere();
    submarineShip.setPlacedOn(placeAt);
  }
  
  public void placeDestroyer(int x, int y){
  	Space[] placeAt = new Space[destroyerShip.getLengthOfShip()];
    placeAt[0] = shipBoard.getSpace(x, y);
    placeAt[1] = shipBoard.getSpace(x, y+1);
    placeAt[0].setShipHere();
    placeAt[1].setShipHere();
    destroyerShip.setPlacedOn(placeAt);
	}
  
  
  public void placeShips() {
  	Scanner sc = new Scanner(System.in);
  	
  	boolean horizontal = checkHorizontal();
  	System.out.println("Where to place Carrier?");
  	Coordinate carrierCoordinatesFront = getCoordinates("1",sc);
  	Coordinate carrierCoordinatesBack = getCoordinates("2",sc);
  	placeCarrier(carrierCoordinatesFront.getX(),carrierCoordinatesFront.getY(),carrierCoordinatesBack.getX(),carrierCoordinatesBack.getY(),horizontal);
  	
  	horizontal = checkHorizontal();
  	System.out.println("Where to place Battleship?");
  	Coordinate battleshipCoordinatesFront = getCoordinates("1",sc);
  	Coordinate battleshipCoordinatesBack = getCoordinates("2",sc);
  	placeBattleship(battleshipCoordinatesFront.getX(),battleshipCoordinatesFront.getY(),battleshipCoordinatesBack.getX(),battleshipCoordinatesBack.getY(),horizontal);
  	/*
  	System.out.println("Where to place Cruiser?");
  	Coordinate cruiserCoordinates = getCoordinates(sc);
  	placeCarrier(cruiserCoordinates.getX(),cruiserCoordinates.getY());
  	
  	System.out.println("Where to place Sub?");
  	Coordinate submarineCoordinates = getCoordinates(sc);
  	placeCarrier(submarineCoordinates.getX(),submarineCoordinates.getY());
  	
  	System.out.println("Where to place Destroyer?");
  	Coordinate destroyerCoordinates = getCoordinates(sc);
  	placeCarrier(destroyerCoordinates.getX(),destroyerCoordinates.getY());
  	*/
  	
  	sc.close();
  }
  
  public Coordinate getCoordinates(String s,Scanner sc) {
  	System.out.print("x"+s+"-coordinate: ");
  	int x = sc.nextInt();
  	System.out.print("\ny"+s+"-coordinate: ");
  	int y = sc.nextInt();
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
