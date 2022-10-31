import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.InputStreamReader;

public class newClient{
 // display information to user
   private ObjectOutputStream output; // output stream to server
   private ObjectInputStream input; // input stream from server
   private String message = ""; // message from server
   private String chatServer; // host server for this application
   private Socket client; // socket to communicate with server
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // need host and port, we want toconnect to the ServerSocket at port 7777\
        String rowChoice ="", columnChoice = "", HitOrMiss = "";
        Player player1 = new Player();
        Board b = new Board();
        player1.placeShips();
        player1.carrierShip.printPlacedAt();
        /* 
        Space[][] spaces = b.getGrid();
        Coordinate c = spaces[1][0].getCoordinate();
        System.out.println(c.getY());
        */
        
        String [][] updatedBoard =  new String[10][10];
	    updatedBoard = player1.shipBoard.displayBoard();
        String [][] HitOrMissBoard = new String[10][10];
        HitOrMissBoard = b.HitOrMissBoard();
        /* 
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++) {
                System.out.print(updatedBoard[i][j]);
            }
            System.out.println("");
        }
        */
        String HorM = "";
        String HorMfromServer = "";
        //player1.shipBoard.checkHitMiss(rowChoice, columnChoice);
        Socket socket = new Socket("localhost", 5000);
        int count = 0;
        while (count < 17) {

        OutputStream outputStream = socket.getOutputStream(); //create output stream to send data to Server
        // create a data output stream from the output stream so we can send attack data through it
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        System.out.println("Which row do you want to attack?");
        rowChoice = sc.nextLine();
        dataOutputStream.writeUTF(rowChoice);
        System.out.println("Which column do you want to attack?");
        columnChoice = sc.nextLine();
        DataInputStream dis = new DataInputStream(socket.getInputStream()); //for reading message from Server
        dataOutputStream.writeUTF(columnChoice);
        HorMfromServer = dis.readUTF();
        if (HorMfromServer.equals("H"))
        {
            count++;
            if (count == 5)
            {
                System.out.println("Carrier has been sunk!");
            } else if (count == 9)
            {
                System.out.println("Battleship has been sunk!");
            } else if (count == 12)
            {
                System.out.println("Cruiser has been sunk!");
            } else if (count == 15)
            {
                System.out.println("Submarine has been sunk!");
            } else if (count == 17)
            {
                System.out.println("Destroyer has been sunk!");
            }
        }
        System.out.println("Your attack was a: " + HorMfromServer);
        HitOrMissBoard = b.HitOrMissBoard(HitOrMissBoard, rowChoice, columnChoice, HorMfromServer);
       // HorM = dis.readUTF();
       // System.out.println("Your attack was a: " + HorM);
        // write the message we want to send
        // close the output stream when we're done.
        System.out.println("Awaiting attack from opponent 2...: ");
        String opponentRow = dis.readUTF();
        System.out.println("Opponent 1 attacked row: " + opponentRow);
        String opponentColumn = dis.readUTF();
        System.out.println("Opponent 1 attacked column: " + opponentColumn);
        HorM = player1.shipBoard.checkHitMiss(updatedBoard, opponentRow, opponentColumn);
        dataOutputStream.writeUTF(HorM);
        //We would have a few if statements here for getting info about hit/mis. Simply return letter H for hit for M for miss
        updatedBoard = player1.shipBoard.displayBoard(updatedBoard, opponentRow, opponentColumn);
        socket = new Socket("localhost", 5000);
        }
        System.out.println("GAME OVER! YOU WIN");
        
    }
}  