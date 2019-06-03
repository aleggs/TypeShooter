import java.awt.*;

public class NPC extends Thing{

    protected int health;
    private int rand;
    private String name;
    private GameEngine game;
    //need spawn coords, string tag,
    public NPC(GameEngine gameIn, float xIn, float yIn, int widthIn, int heightIn, String nameIn){
        super(xIn, yIn, widthIn, heightIn);
        health = 4;
        name = nameIn;
        rand = (int) (Math.random()*6) + 1;
        game = gameIn;
    }
    @Override
    public void tick() {
        if (name.length()==0){
            game.addKill();
            NPCManager.getNPCList().remove(this);
            return;
        }
        System.out.println(game.getKeyboardInput().getWordTyped());
        if (game.getKeyboardInput().getWordTyped().toLowerCase().contains(name.substring(0,1))){
            name = name.substring(1);
            game.getKeyboardInput().resetWordTyped();
        }
        if (y >= 570){
            System.out.println("YOU DIED");
            game.stop();
        }
    }

    @Override
    public void render(Graphics g) {
        if (rand == 1)
            g.drawImage(Assets.getRedShip1(), (int) x, (int) y, null);
        if (rand == 2)
            g.drawImage(Assets.getRedShip2(), (int) x, (int) y, null);
        if (rand == 3)
            g.drawImage(Assets.getRedShip3(), (int) x, (int) y, null);
        if (rand == 4)
            g.drawImage(Assets.getRedShip4(), (int) x, (int) y, null);
        if (rand == 5)
            g.drawImage(Assets.getRedShip5(), (int) x, (int) y, null);
        if (rand == 6)
            g.drawImage(Assets.getRedShip6(), (int) x, (int) y, null);
        g.setColor(Color.WHITE);
//        g.fillRect((int) x-15, (int) y + 50, 50, 25);
        g.setFont(new Font("MONOSPACED", Font.BOLD, 14));
//        g.setColor(Color.BLACK);
        g.drawString(name, (int) x + 20 - (getLength() * 4), (int) y + 65);
    }
    public void addY(float i){
        y += i;
    }
    public boolean equals(NPC npc){
        if (name.equals(npc.name))
            return true;
        return false;
    }

    public String getString(){
        return name;
    }
    public int getLength(){
        return name.length();
    }
}
