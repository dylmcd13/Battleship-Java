package model;

/** Coordinate class */
public class Coordinate {
  /** X coordinate */
  private int x;

  /** Y coordinate */
  private int y;

  /**
   * Constructor to set x and y
   * @param x : x-coordinate
   * @param y : y-coordinate
   */
  public Coordinate(int x, int y){
    this.x = x;
    this.y = y;
  }

  /**
   * @return X coordinate
   */
  public int getX(){
    return x;
  }

  /**
   * @return Y coordinate
   */
  public int getY() {
    return y;
  }

  /**
   * Print this coordinate to the screen for testing
   */
  public void printCoordinate() {
  	System.out.println("X-COORDINATE: "+x+"\nY-COORDINATE: "+y);
  }

}