import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 2001);
            new Reader(socket.getInputStream()).start();
            new Writer(socket.getOutputStream()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
