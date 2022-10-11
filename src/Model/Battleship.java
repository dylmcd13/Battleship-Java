package Model;

public class Battleship {
  private Coordinate[] placedOn;
  
  /** Must be length 4 */
  Battleship(Coordinate[] c){
    placedOn = c;
  }

  public Coordinate[] getPlacedOn(){
    return placedOn;
  }
}
