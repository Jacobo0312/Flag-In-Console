package thread;

import java.io.IOException;
import model.Flag;

public class FlagThread extends Thread {

    private Flag flag;

    public FlagThread(int color, int sleepTime) {

        flag = new Flag(color, sleepTime);
    }

    public void run() {
        try {
            flag.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
