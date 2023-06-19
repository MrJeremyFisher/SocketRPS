import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        if (args != null && args.length > 0) {
            String option = args[0];

            if (option.equals("client")) {
                new SocketClient();
                SocketClient.exec();
            } else if (option.equals("server")) {
                new SocketServer();
                SocketServer.exec();
            }
        }
    }
}

