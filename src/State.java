import java.awt.*;

public abstract class State {
    //game state manager
    private static State currentState = null;

    public static State getCurrentState(){
        return currentState;
    }
    public static void setState(State state){
        currentState = state;
    }

    public int tick;
    public abstract void tick();
    public abstract void render(Graphics g);

}