package Model;

public class Carrier {
  private Space[] placedOn;
  
  /** Must be length 5 */
  Carrier(Space[] c){
    placedOn = c;
  }

  public Space[] getPlacedOn(){
    return placedOn;
  }
}
