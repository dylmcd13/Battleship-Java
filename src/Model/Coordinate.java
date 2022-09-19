package Model;

public class Coordinate {
  /** X coordinate */
  private int x;

  /** Y coordinate */
  private int y;

  /**
   * @return X coordinate
   */
  public int getXCoordinate(){
    return x;
  }

  /**
   * @return Y coordinate
   */
  public int getY() {
    return y;
  }

  /** Change X Coordinate */
  public void setX(int x) {
    this.x = x;
  }

  /** Change Y Coordinate */
  public void setY(int y) {
    this.y = y;
  }

}