package Model;
import java.util.ArrayList;
public class ShipBoard {
  private ArrayList<Coordinate> hitLocations;


  private ArrayList<Coordinate> missLocations;


  public ArrayList<Coordinate> getHitLocations() {
    return hitLocations;
  }


  public ArrayList<Coordinate> getMissLocations() {
    return missLocations;
  }


  public void addHitLocation(Coordinate c){
    hitLocations.add(c);
  }


  public void addMissLocation(Coordinate c){
    missLocations.add(c);
  }
}
