import javax.swing.*;
import java.awt.*;

public class DisplayEngine implements Runnable{
    private int difficulty = 1;
    private int score = 0;
    private int tick = 3000;

    private Dimension d;
    private final int WIDTH = 500;
    private int HEIGHT = 500;

    private JFrame frame;
    private Canvas canvas;

    public void run(){
        generate();
    }

    public void generate(){
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

        ImageIcon im = new ImageIcon("Background1.jpg");
        //sets background here

        frame.add(canvas);
        frame.repaint();
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getScore() {
        return score;
    }

    public int getTick() {
        return tick;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}