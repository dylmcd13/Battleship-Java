package Model;

public class Board extends Player{
  
  private Coordinate[][] grid;

  /** Default Contructor */
  public Board() {
    grid = new Coordinate[10][10];
  }
}
