import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket =
                    new ServerSocket(2001, 100);

            Socket socket = serverSocket.accept();

            new Reader(socket.getInputStream()).start();
            new Writer(socket.getOutputStream()).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
