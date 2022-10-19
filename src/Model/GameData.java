package Model;
import java.util.Observer;
import java.util.Observable;

public class GameData {
    Ship ships;
    Pegs peg;
    boolean playerTurn;

    public Pegs getHit()
    {
        return peg;            
    }   

    public Ship getShips()
    {
        return ships;
    }

    public boolean getPlayerTurn()
    {
        return playerTurn;
    }

}
