package Model;

public class Cruiser {
  private Coordinate[] placedOn;
  
  /** Must be length 3 */
  Cruiser(Coordinate[] c){
    placedOn = c;
  }

  public Coordinate[] getPlacedOn(){
    return placedOn;
  }
}
