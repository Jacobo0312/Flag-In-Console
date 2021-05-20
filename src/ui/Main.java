package ui;


import thread.FlagThread;

public class Main {
    public final static  String ESC = "\u001b[";
    public final static String CLEAR  = ESC+"2J";

    public static void main(String[] args) throws Exception {

        System.out.print(CLEAR);


        FlagThread yellow = new FlagThread(43,5);
        FlagThread blue=new FlagThread(44,30);
        FlagThread red=new FlagThread(41, 50);
        yellow.start();
        blue.start();
        red.start();
        yellow.join();
        blue.join();
        red.join();
        System.out.println(ESC+0+"m");
        
    }
  

}