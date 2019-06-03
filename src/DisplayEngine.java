import javax.swing.*;
import java.awt.*;

public class DisplayEngine{
    private static int difficulty = 1;
    private static int score = 0;
    private static int tick = 3000;

    private static Dimension d;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private static JFrame frame;
    private static Canvas canvas;


    public DisplayEngine(){
        generateDisplay();
    }
    public static void run(){
        generateDisplay();
    }

    public static void generateDisplay(){
        frame = new JFrame("Type to Shoot");
        d = new Dimension(WIDTH,HEIGHT);
        frame.setPreferredSize(d);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(d);
        canvas.setMaximumSize(d);
        canvas.setMinimumSize(d);
        canvas.setFocusable(false); //?can only write/act on JFrame

        ImageIcon im = new ImageIcon("res/textures/Background1.jpg");
        //sets background here

        frame.add(canvas);
        frame.pack();//why do I have to pack here?
    }

    public static int getDifficulty() {
        return difficulty;
    }

    public static int getScore() {
        return score;
    }

    public static int getTick() {
        return tick;
    }

    public static Canvas getCanvas() {
        return canvas;
    }
    public static JFrame getFrame(){ return frame; }
    public static int getWIDTH(){
        return WIDTH;
    };
    public static int getHEIGHT(){
        return HEIGHT;
    }

}