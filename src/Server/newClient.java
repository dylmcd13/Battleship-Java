import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.util.Scanner;

public class newClient extends JFrame{

   private JTextField enterField; // enters information from user
   private JTextArea displayArea; // display information to user
   private ObjectOutputStream output; // output stream to server
   private ObjectInputStream input; // input stream from server
   private String message = ""; // message from server
   private String chatServer; // host server for this application
   private Socket client; // socket to communicate with server
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        String choice;
        // need host and port, we want to connect to the ServerSocket at port 7777
        while (true) {
        Socket socket = new Socket("IP Address of Server", 5000);
       
        OutputStream outputStream = socket.getOutputStream(); //create output stream to send data to Server
        // create a data output stream from the output stream so we can send attack data through it
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        
        System.out.println("Where do you want to attack? (Row and column)");
        choice = keyboard.nextLine();
        // write the message we want to send
        dataOutputStream.writeUTF(choice);// send the message
        // close the output stream when we're done.
        System.out.println("Awaiting attack from opponent 2...: ");
        DataInputStream dis = new DataInputStream(socket.getInputStream()); //for reading message from Server
        String message = dis.readUTF();
        System.out.println("Opponent 2 attacked:  " + message);
         
        //We would have a few if statements here for getting info about hit/mis. Simply return letter H for hit for M for miss
       

        }
    }
}  
