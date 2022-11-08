import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Writer extends Thread {
    private OutputStream out;
    private boolean flag = true;

    public Writer(OutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            try {
                out.write(
                        scanner.nextLine().getBytes()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopThread() {
        flag = false;
    }
}
