package Model;

public class Board extends Player{
  
  private Space[][] grid;

  /** Default Contructor puts corresponding coordinate into grid */
  Board() {
    grid = new Space[10][10];
    for(int i=0;i<10;i++){
      for(int j=0;j<10;j++){
        Coordinate c = new Coordinate(i,j);
        grid[i][j] = new Space(c);
      }
    }
  }

}
