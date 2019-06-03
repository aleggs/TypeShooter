import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

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
    private double difficultyTimer = 2;

    private State gameState;
    private State menuState;

    private int enemiesKilled = 0;
    private int toNextLevel = 0;
    private int difficultyLevel = 1;

    private KeyboardInput keyboardInput;
    private MouseInput mouseInput;

    public GameEngine(){
        width = DisplayEngine.getWIDTH();
        height = DisplayEngine.getHEIGHT();
        keyboardInput = new KeyboardInput();
        mouseInput = new MouseInput(){};
    }

    public void run() {

        init();


        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long enemyTimer = 0;
        int ticks = 0;
        double bigTick = 0;

        while(sentinel){

            now = System.nanoTime();
            delta += (now - lastTime)/timePerFrame;
            timer += now - lastTime;
            enemyTimer += now - lastTime;
            lastTime = now;
            if (delta>=1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if (enemyTimer >= 1000000000/60){
                NPCManager.smallTick(g);
                enemyTimer = 0;
                bigTick+= 1.0/60;
            }
            if(timer >= 1000000000){
//                System.out.println("Ticks and frames: " + ticks);
                ticks = 0;
                timer = 0;
//                bigTick++;
            }
            if (bigTick >= difficultyTimer){
//                System.out.println("New enemy spawning.");
                NPCManager.tick(g);
                bigTick = 0;
            }
        }
    }

    public void init(){
        Assets.init();

        gameState = new GameState(this);
        menuState = new MenuState(this);

        State.setState(menuState);
        display = new DisplayEngine();
        display.getFrame().addKeyListener(keyboardInput);
        display.getFrame().addMouseListener(mouseInput);
        display.getCanvas().addMouseListener(mouseInput);
    }

    public void tick(){
        if (toNextLevel >= 5 * Math.sqrt(difficultyLevel)){
            difficultyLevel++;
            NPCManager.setModY(NPCManager.getModY() + (float) 0.1);
            difficultyTimer -= 0.3;
            toNextLevel = 0;

        }
        if (State.getCurrentState() != null) {
            keyboardInput.tick();
            State.getCurrentState().tick();

        }
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

    public KeyboardInput getKeyboardInput(){
        return keyboardInput;
    }

    public void addKill(){
        enemiesKilled++;
        toNextLevel++;
    }
    public void stop(){
        sentinel = false;
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0,0,800,600);
        g.drawImage(Assets.getGameOver(), 0,0,null);
        g.setFont(new Font("PHOSPHATE", Font.BOLD,180));
        g.setColor(Color.RED);
        g.drawString("Game", 165,190);
        g.drawString("Over", 175,350);

        /*
        g.setColor(new Color(0, 20, 73, 152));
        g.fillRoundRect(250,335,300,90, 40,40);
        g.fillRoundRect(250,435,300,90,40,40);
        g.setColor(Color.white);
        g.setFont(new Font("PHOSPHATE", Font.PLAIN, 90));
        g.drawString("Play", 300,410);
        g.drawString("Quit", 300, 510);

         */

        bs.show();

    }
    public GameEngine getGameEngine(){
        return this;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }
    public int getEnemiesKilled(){
        return enemiesKilled;
    }

    public class MouseInput implements MouseListener {

        private int mX;
        private int mY;

        public MouseInput() {

        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            mX = e.getX();
            mY = e.getY();
            if (mX >= 250 && mX <= 550) {
                if (mY >= 335 && mY <= 425) {
                    //play
                    State.setState(gameState);
                    System.out.println("state set");

                }
                if (mY >= 435 && mY <= 525) {
                    //quit
//                    stop();
                    System.exit(1);
                }
//                else
//                    playAgain();
            }
        }

        @Override
        public void mouseReleased (MouseEvent e){

        }

        @Override
        public void mouseEntered (MouseEvent e){

        }

        @Override
        public void mouseExited (MouseEvent e){

        }

    }

//    public void playAgain(){
//        run();
//    }
}