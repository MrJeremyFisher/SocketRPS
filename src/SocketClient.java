import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
    public static final InetAddress host;

    static {
        try {
            host = InetAddress.getByName("10.1.2.221");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public static final int port = 7777;


    public static void exec() throws IOException {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
                System.in));
        Socket clientSocket = new Socket(SocketClient.host, SocketClient.port);
        DataOutputStream outToServer = new DataOutputStream(
                clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));
        System.out.println("Successfully connected");
        System.out.println("Input move");
        String input = inFromUser.readLine();
        if (Moves.contains(input)) {
            System.out.println("Bad move, try again");
            input = inFromUser.readLine();
        }


        // Transmit
        outToServer.writeBytes(input + "\n");

        // Display responses
        String line;
        StringBuilder output = new StringBuilder();
        while ((line = inFromServer.readLine()) != null) { // No better way to do this
            output.append(line).append(System.getProperty("line.separator"));
        }

        System.out.println(output);
        // Close socket
        clientSocket.close();
    }
}
