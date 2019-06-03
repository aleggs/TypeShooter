import java.awt.*;

public abstract class Mob extends Thing{

    protected int health;

    public Mob(float xIn, float yIn, int widthIn, int heightIn){
        super(xIn, yIn, widthIn, heightIn);
        health = 4;
    }
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
