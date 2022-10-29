package model;

public class Board{
  
  private Space[][] grid;

  private Ship[] ships;
  
  /** Default Constructor puts corresponding coordinate into grid */
  Board() {
    grid = new Space[10][10];
    for(int i=0;i<10;i++){
      for(int j=0;j<10;j++){
        Coordinate c = new Coordinate(i,j);
        grid[i][j] = new Space(c);
      }
    }
    
    ships = new Ship[5];
    
  }

  
  public Space getSpace(int x, int y){
    return grid[x][y];
  }

  public Space[][] getGrid(){
	  return grid;
  }
  
  public Ship[] getShips() {
  	return ships;
  }
  
  
  /**
   * Prolly make it so each Space has a square to display instead of doing this
   * 
   */
  public void displayBoard() {
  	
	  System.out.println("IM DISPLAY BOARD &*$&#($&#($*&");
	  StringBuilder sb = new StringBuilder();
	  // sb.append("---------------------------------------------------\n");
	  // sb.append("|    |    |    |    |    |    |    |    |    |    |\n");
	  // sb.append("---------------------------------------------------\n");
	  // sb.append("|    |    |    |    |    |    |    |    |    |    |\n");
	  // sb.append("---------------------------------------------------\n");
	  // sb.append("|    |    |    |    |    |    |    |    |    |    |\n");
	  // sb.append("---------------------------------------------------\n");
	  // sb.append("|    |    |    |    |    |    |    |    |    |    |\n");
	  // sb.append("---------------------------------------------------\n");
	  // sb.append("|    |    |    |    |    |    |    |    |    |    |\n");
	  // sb.append("---------------------------------------------------\n");
	  // sb.append("|    |    |    |    |    |    |    |    |    |    |\n");
	  // sb.append("---------------------------------------------------\n");
	  // sb.append("|    |    |    |    |    |    |    |    |    |    |\n");
	  // sb.append("---------------------------------------------------\n");
	  // sb.append("|    |    |    |    |    |    |    |    |    |    |\n");
	  // sb.append("---------------------------------------------------\n");
	  // sb.append("|    |    |    |    |    |    |    |    |    |    |\n");
	  // sb.append("---------------------------------------------------\n");
	  // sb.append("|    |    |    |    |    |    |    |    |    |    |\n");
	  // sb.append("---------------------------------------------------\n");
	  // System.out.println(sb.toString());

    for(int i=0;i<10;i++){
      for(int j=0;j<10;j++){
        Space currentSpace = grid[i][j];
        if(!currentSpace.isShipHere() && j != 9){ //If no ship at space and not end of grid
          sb.append(" □ ");
        }else if(!currentSpace.isShipHere() && j == 9){ //If no ship at space but is end of grid
          sb.append(" □ \n");
        }
      }
    }
  
  
  }	
  
  public boolean checkOverlap(Ship ship) {
  	Space[] placedOn = ship.getPlacedOn();
  	for(Space s : placedOn) {
  		if(s.isShipHere() == true)
  			return false;
  	}
  	return true;
  }
  
  public boolean checkOutOfBounds(Ship ship) {
  	return false;
  }

}
