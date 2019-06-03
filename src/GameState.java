import java.awt.*;

public class GameState extends State{

    private Player player;

    public GameState(GameEngine gameIn){
        super(gameIn);
        player = new Player(gameIn,380,500,100,100);
    }
    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.getBackground(), 0,0,null);
        player.render(g);
    }
}
