

public class Pegs {
  
  private String color;

  private Coordinate location;

  private boolean isHit;

  public String getColor(){
    return color;
  }


  public Coordinate getLocation(){
    return location;
  }


  public boolean getIsHit(){
    return isHit;
  }


  public void setColor(String color){
    this.color = color;
  }


  public void setLocation(Coordinate l){
    location = l;
  }


  public void setIsHit(boolean i){
    isHit = i;
  }
}
