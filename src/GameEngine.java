import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameEngine implements Runnable{

    private boolean sentinel = true;
    private BufferStrategy bs;
    private Graphics g;
    private DisplayEngine display;

    private int width;
    private int height;
    private int y;
    final int FPS = 60;
    double timePerFrame = 1000000000 / FPS;
    double delta = 0;

    private State gameState;
    private State menuState;

    public GameEngine(){
        width = DisplayEngine.getWIDTH();
        height = DisplayEngine.getHEIGHT();

    }

    public void run() {

        init();


        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(sentinel){

            now = System.nanoTime();
            delta += (now - lastTime)/timePerFrame;
            timer += now - lastTime;
            lastTime = now;
            if (delta>=1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                System.out.println("Ticks and frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
    }

    public void init(){
        Assets.init();

        gameState = new GameState();
        menuState = new MenuState();

        State.setState(gameState);
        display = new DisplayEngine();
    }

    public void tick(){
        if (State.getCurrentState() != null)
            State.getCurrentState().tick();
    }


    public void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();

        //start drawing
        if (State.getCurrentState() != null)
            State.getCurrentState().render(g);
        //stop drawing?

        bs.show();
        g.dispose();
    }


    public void stop(){
        sentinel = false;
    }
}