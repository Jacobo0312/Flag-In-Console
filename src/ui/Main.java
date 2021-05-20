package ui;

import thread.FlagThread;

public class Main {
    public final static String ESC = "\u001b[";
    public final static String CLEAR = ESC + "2J";
    private static FlagThread yellow;
    private static FlagThread blue;
    private static FlagThread red;

    public static void main(String[] args) throws Exception {

        System.out.print(CLEAR);

        yellow = new FlagThread(43, 5);
        blue = new FlagThread(44, 30);
        red = new FlagThread(41, 50);
        yellow.start();
        blue.start();
        red.start();
        yellow.join();
        blue.join();
        red.join();
        //Clean background 
        System.out.println(ESC + 0 + "m");

    }

}