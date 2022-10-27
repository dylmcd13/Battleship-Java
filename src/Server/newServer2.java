import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class newServer2 {
    public static void main(String[] args) throws IOException {
        // don't need to specify a hostname, it will be the current machine
        Scanner keyboard = new Scanner(System.in);
        while (true) {
        String attack;
        ServerSocket ss = new ServerSocket(5000);
        Socket socket = ss.accept(); 
        System.out.println("Awaiting attack from opponent 1... ");
        InputStream inputStream = socket.getInputStream();
      
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        // read the message from the socket
        String message = dataInputStream.readUTF();
        System.out.println("Opponent 1 attacked: " + message);

        System.out.println("Enter attack to send to opponent 1: ");
        attack = keyboard.nextLine();
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(attack);
        //would have an if statement here for hit/miss. H for hit, M for miss. 
        //We simply have to pass strings through the network, and then use them to 
        //manipulate the data model.
        ss.close();
        socket.close();
        }
    }
}
