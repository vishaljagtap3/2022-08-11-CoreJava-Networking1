import java.io.IOException;
import java.io.InputStream;

public class Reader extends Thread {
    private InputStream in;
    private boolean flag = true;

    public Reader(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        byte [] data = new byte[1024];
        int count = 0;
        while (flag) {
            try {
                if(in.available() > 0) {
                    count = in.read(data);
                    System.out.println(new String(data, 0, count));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopThread() {
        flag = false;
    }
}
