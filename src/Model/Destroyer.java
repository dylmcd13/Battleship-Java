package Model;

public class Destroyer {
  private Coordinate[] placedOn;
  
  /** Must be length 2 */
  Destroyer(Coordinate[] c){
    placedOn = c;
  }

  public Coordinate[] getPlacedOn(){
    return placedOn;
  }

}
