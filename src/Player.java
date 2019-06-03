import java.awt.*;

public class Player extends Mob{

    private GameEngine game;

    public Player(GameEngine gameIn, float xIn, float yIn, int widthIn, int heightIn){
        super(xIn, yIn, widthIn, heightIn);
        game = gameIn;
    }
    @Override
    public void tick() {
        if(game.getKeyboardInput().i){
//            System.out.println("I TYPED AN \"I\"");
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.getPlayer(), (int) x,(int) y, null);
    }
}
