import java.awt.*;

public class GameState extends State{

    public GameState(){

    }
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.getBackground(), 0,0,null);
        g.drawImage(Assets.getPlayer(),100,100,null);
    }
}
