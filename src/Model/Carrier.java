package Model;

public class Carrier {
  private Coordinate[] placedOn;
  
  /** Must be length 5 */
  Carrier(Coordinate[] c){
    placedOn = c;
  }

  public Coordinate[] getPlacedOn(){
    return placedOn;
  }
}
