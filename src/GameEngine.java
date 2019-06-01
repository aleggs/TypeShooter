import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameEngine implements Runnable{

    private boolean sentinel = true;
    private BufferStrategy bs;
    private Graphics g;
    private DisplayEngine display;

    private int width;
    private int height;

    public GameEngine(){
        width = DisplayEngine.getWIDTH();
        height = DisplayEngine.getHEIGHT();

    }

    public void run() {

        init();

        while(sentinel){
            update();
            render();
        }
    }

    public void init(){
        display = new DisplayEngine();
//        display.run();
    }

    public void update(){
        System.out.println("One tick has passed.");
    }
    public void render(){
        System.out.println("Starting to render.");
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();

        //start drawing
        ImageIcon im = new ImageIcon("Background1.jpg");
        g.drawImage(im.getImage(), 0,0, null);
        ImageIcon enemy1 = new ImageIcon("Red Starship 3.png");
        g.drawImage(enemy1.getImage(), 00,00,null);

        //stop drawing?
        bs.show();
        g.dispose();

    }


    public void stop(){
        sentinel = false;
    }
}