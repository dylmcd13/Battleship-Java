package model;

@SuppressWarnings("unused")
public class Space {
  private Coordinate coordinate;
  private boolean shipHere;
  private Pegs peg;
  
  public Space(Coordinate c) {
	  shipHere = false;
	  peg = null;
	  coordinate = c;
  }
  
  public Coordinate getCoordinate() {
	  return coordinate;
  }

  public boolean isShipHere(){
    return shipHere;
  }
  
  public void setShipHere() {
  	shipHere = true;
  }
}