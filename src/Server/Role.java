package Server;
import Model.GameData;

public interface Role {
  public void setUp();

  public void sendData();

  public GameData receiveData();
}
