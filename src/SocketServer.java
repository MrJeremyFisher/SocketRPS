import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

        // don't need to specify a hostname, it will be the current machine
        public static void start(int port) throws IOException{
            ServerSocket ss = new ServerSocket(port);
            System.out.println("ServerSocket awaiting connections...");
            Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
            System.out.println("Connection from " + socket + "!");
        }


        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        // create a DataInputStream so we can read data from it.
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        // read the message from the socket
        String message = dataInputStream.readUTF();
        System.out.println("The message sent from the socket was: " + message);

        System.out.println("Closing sockets.");
        ss.close();
        socket.close();
    }
