package Model;

public class Submarine {
  private Coordinate[] placedOn;
  
  /** Must be length 3 */
  Submarine(Coordinate[] c){
    placedOn = c;
  }

  public Coordinate[] getPlacedOn(){
    return placedOn;
  }
}
