import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class SocketServer {
    private static final int port = 7777;
    static final Map<String, String> losingCombinations = MoveUtils.map();

    public static void exec() throws IOException {
        ServerSocket ServerSocket = new ServerSocket(port);
        System.out.println("Launched");

        Socket client1 = ServerSocket.accept(); // blocking call, this will wait until a connection is attempted on this port.
        if (client1.isConnected()) {
            System.out.println("client1 connected");

        }
        InputStream client1InputStream = client1.getInputStream();
        BufferedReader client1DataInputStream = new BufferedReader(new InputStreamReader(client1InputStream));
        DataOutputStream client1DataOutputStream = new DataOutputStream(client1.getOutputStream());


        Socket client2 = ServerSocket.accept(); // blocking call, this will wait until a connection is attempted on this port.
        if (client2.isConnected()) {
            System.out.println("client2 connected");
        }


        InputStream client2InputStream = client2.getInputStream();
        BufferedReader client2DataInputStream = new BufferedReader(new InputStreamReader(client2InputStream));
        DataOutputStream client2DataOutputStream = new DataOutputStream(client2.getOutputStream());


        String client1Move = client1DataInputStream.readLine();
        String client2Move = client2DataInputStream.readLine();


        String client1Out = String.format("You played %s. Your opponent played %s\n", client1Move, client2Move);
        String client2Out = String.format("You played %s. Your opponent played %s\n", client2Move, client1Move);

        // Notify users of game status after moving
        if (Moves.contains(client1Move) || Moves.contains(client2Move)) {
            client1Out += "Bad move, try again";
            client2Out += "Bad move, try again";
        } else if (Utils.tie(client1Move, client2Move)) {
            client1Out += "You tied!\n";
            client2Out += "You tied!\n";
        } else {
            client1Out += String.format("You %s", Utils.win(client1Move, client2Move, losingCombinations) ? "Win!\n" : "Lose!\n");
            client2Out += String.format("You %s", Utils.win(client2Move, client1Move, losingCombinations) ? "Win!\n" : "Lose!\n");
        }

        client1DataOutputStream.writeBytes(client1Out);
        client2DataOutputStream.writeBytes(client2Out);

        client1.close();
        client2.close();
    }
}
