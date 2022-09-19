package Model;

public class Player {
  
  /** True or false depending on if it's player turn */
  private boolean playerTurn;

  /** Coordinate where the players shot goes */
  private Coordinate shotLocation;

  /** Default Constructor for Player */
  public Player(){
    playerTurn = false;
    shotLocation.setX(0);
    shotLocation.setY(0);
  }

  /**
   * @return Players turn
   */
  public boolean getPlayerTurn() {
    return playerTurn;
  }

  /**
   * @return Coordinate object of where the shot went
   */
  public Coordinate getShotLocation() {
    return shotLocation;
  }

  /**
   * Sets the Players turn to true or false.
   * Probably want to change this method to changePlayerTurn() to toggle the players turn****************
   * @param p : True or False depending on if it is the players turn
   */
  public void setPlayerTurn(boolean p) {
    playerTurn = p;
  }

  /**
   * Sets the location of the shot
   * @param c New coordinate of shot
   */
  public void setShotLocation(Coordinate c) {
    shotLocation = c;
  }


}
