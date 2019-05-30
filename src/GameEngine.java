import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameEngine implements Runnable{

    private boolean sentinel = true;
    private BufferStrategy bs;
    private Graphics g;
    private DisplayEngine display;

    public void run() {
        display = new DisplayEngine();
        display.run();
        launch();
    }

    public void launch(){
        while(sentinel){
            update();
            render();
//            System.out.println("Kinney beans");
        }
    }

    public void update(){

    }
    public void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null)//{
            display.getCanvas().createBufferStrategy(2);
            //return;}
        bs.getDrawGraphics();

        //start drawing
        g.fillRect(0,0,100,100);

//        ImageIcon im = new ImageIcon("Background1.jpg");
//        g.drawImage(im.getImage(), 0,0, null);

        //stop drawing

        bs.show();
        bs.dispose();

    }


    public void stop(){
        sentinel = false;
    }
}