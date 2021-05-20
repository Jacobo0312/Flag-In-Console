package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Flag {
    public final static  String ESC = "\u001b[";
	public final static String UP    = ESC+"A";
	public final static String DOWN  = ESC+"B";
	public final static String RIGHT = ESC+"C";
	public final static String LEFT  = ESC+"D";
	public final static String NXLN  = ESC+"1E";
    

    //Positions
    public final static int YELLOW = 1;
    public final static int BLUE = 11;
    public final static int RED = 16;

    private int color;
    private int sleep;
    private int count=1;
    private char line = ' ';
    private int position;
    private int witdh=5;
    private BufferedWriter bf;
    

    public Flag(int color,int sleep) {
        this.color = color;
        this.sleep=sleep;
        this.position=getPosition(color);
        bf =new BufferedWriter(new OutputStreamWriter(System.out));

    }


    public void start() throws InterruptedException, IOException {
        bf.write(ESC+position+";"+0+"f");

        while (count<=100) {
            
             
            for (int i = 0; i < witdh; i++) {  
                bf.write(ESC+color+"m"+line);
                bf.flush();
                Thread.sleep(sleep);
                int test=position+i;
                bf.write(ESC+test+";"+count+"f");
            }
            bf.write(ESC+color+"m"+line);
            bf.flush();
            count++; 
            bf.write(ESC+position+";"+count+"f");
            
             
        }
        
    }

    
    private int getPosition(int color) {
        int position;

        if (color==41){
            position=RED;
        }else if (color==44){
            position=BLUE;
        }else{
            position=YELLOW;
            witdh+=5;
        }

        return position;
    }



}
