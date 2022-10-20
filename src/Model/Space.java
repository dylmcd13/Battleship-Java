package Model;

@SuppressWarnings("unused")
public class Space {
  private Coordinate coordinate;
  private Ship ship;
  private Pegs peg;
  
  public Space(Coordinate c) {
	  ship = null;
	  peg = null;
	  coordinate = c;
  }
  
  public Coordinate getCoordinate() {
	  return coordinate;
  }
}