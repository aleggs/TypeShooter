import java.awt.*;

public abstract class Thing {

    protected float x, y;
    protected int width, height;
    public Thing(float xIn, float yIn, int widthIn, int heightIn){
        x = xIn;
        y = yIn;
        width = widthIn;
        height = heightIn;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
