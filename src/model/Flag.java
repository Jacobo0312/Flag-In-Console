package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Flag {
    public final static String ESC = "\u001b[";

    // Initial positions
    public final static int YELLOW = 1;
    public final static int BLUE = 11;
    public final static int RED = 16;

    private int color;
    private int sleep;
    private int height = 1;
    private char line = ' ';
    private int initialPosition;
    private int witdh = 5;
    private BufferedWriter bf;

    public Flag(int color, int sleep) {
        this.color = color;
        this.sleep = sleep;
        this.initialPosition = getPosition(color);
        bf = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void start() throws InterruptedException, IOException {
        bf.write(ESC + initialPosition + ";" + 0 + "f");

        while (height <= 100) {

            for (int i = 0; i < witdh; i++) {
                bf.write(ESC + color + "m" + line);
                bf.flush();
                Thread.sleep(sleep);
                int y = initialPosition + i;
                bf.write(ESC + y + ";" + height + "f");
            }
            bf.write(ESC + color + "m" + line);
            bf.flush();
            height++;
            bf.write(ESC + initialPosition + ";" + height + "f");

        }

    }

    private int getPosition(int color) {
        int position;

        if (color == 41) {
            position = RED;
        } else if (color == 44) {
            position = BLUE;
        } else {
            position = YELLOW;
            witdh += 5;
        }

        return position;
    }

}
