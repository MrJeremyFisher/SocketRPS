import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
    Socket socket;
    public static void open(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    public void write(String data) throws IOException {
        // get the output stream from the socket.
        OutputStream outputStream = socket.getOutputStream();
        // create a data output stream from the output stream so we can send data through it
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        // write the message we want to send
        dataOutputStream.writeUTF(data);
        dataOutputStream.flush(); // send the message
        dataOutputStream.close(); // close the output stream when we're done.
    }

    public void close() throws IOException {
        socket.close();
    }
}
