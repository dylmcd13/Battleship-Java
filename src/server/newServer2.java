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
        String rowChoice, columnChoice;
        Board b = new Board();
        Player player1 = new Player();
        player1.placeShips();
        player1.carrierShip.printPlacedAt();
        
        String [][] updatedBoard =  new String[10][10];
        String [][] HitOrMissBoard = new String[10][10];
	    updatedBoard = player1.shipBoard.displayBoard();
        HitOrMissBoard = b.HitOrMissBoard();
        
        String HorMfromClient = "";
        String HorM = "";
        
        ServerSocket ss = new ServerSocket(5000);
        Socket socket = ss.accept();
        int count = 0;

        while (count < 17) {
        System.out.println("Awaiting attack from opponent 1... ");
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        String opponentRow = dataInputStream.readUTF();
        System.out.println("Opponent 1 attacked row: " + opponentRow);
        String opponentColumn = dataInputStream.readUTF();
        System.out.println("Opponent 1 attacked column: " + opponentColumn);
       // HorMfromClient = player1.shipBoard.checkHitMiss(updatedBoard, opponentRow, opponentColumn);
       // dataInputStream.readUTF();
        HorM = player1.shipBoard.checkHitMiss(updatedBoard, opponentRow, opponentColumn);
        dos.writeUTF(HorM);
        System.out.println("Enter row attack to send to opponent 1: ");
        rowChoice = keyboard.nextLine();
        dos.writeUTF(rowChoice);
        System.out.println("Enter column attack to send to opponent 1: ");
        columnChoice = keyboard.nextLine();
        dos.writeUTF(columnChoice);
        HorMfromClient = dataInputStream.readUTF();
        if (HorMfromClient.equals("H"))
        {
            count++;
            System.out.println(count);
        }
        System.out.println("Your Attack was a: " + HorMfromClient);
        ss.close();
        socket.close();
        ss = new ServerSocket(5000);
        socket = ss.accept();
        HitOrMissBoard = b.HitOrMissBoard(HitOrMissBoard, rowChoice, columnChoice, HorMfromClient);
        updatedBoard = player1.shipBoard.displayBoard(updatedBoard, opponentRow, opponentColumn);
        }
        
        System.out.println("GAME OVER! YOU WIN");
    }
}